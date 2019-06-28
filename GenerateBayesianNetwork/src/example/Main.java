package example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.prs.Edge;
import unbbayes.prs.Node;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.PotentialTable;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;

public class Main {

	private static List<String> bolesti=new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {



		JIPEngine engine = new JIPEngine();

		engine.consultFile("program.pl");
		JIPQuery query = engine.openSynchronousQuery("uzmi(bolest,X)");
		

		JIPTerm solution;
		while ( (solution = query.nextSolution()) != null) {
			System.out.println("solution: " + solution);
			for (JIPVariable var: solution.getVariables()) {
				System.out.println(var.getName() + "=" + var.getValue());
				bolesti.add(var.getValue().toString());
			}
		}

		for (String bolest:bolesti) {
			ProbabilisticNetwork net = new ProbabilisticNetwork(bolest);

			ProbabilisticNode varBolest = new ProbabilisticNode();
			varBolest.setName(bolest);
			varBolest.appendState("da");
			varBolest.appendState("ne");
			PotentialTable probBolest = varBolest.getProbabilityFunction();
			probBolest.addVariable(varBolest);

			query=engine.openSynchronousQuery("prevalence("+bolest+",X)");
			while ( (solution = query.nextSolution()) != null) {
				for (JIPVariable var: solution.getVariables()) {
					probBolest.setValue(0, Float.parseFloat(var.getValue().toString())/100);
					probBolest.setValue(1, 1-Float.parseFloat(var.getValue().toString())/100);
				}
			}

			net.addNode(varBolest);


			query=engine.openSynchronousQuery(bolest+"(X,Y)");
			while ( (solution = query.nextSolution()) != null) {
				for (JIPVariable var: solution.getVariables()) {
					if(var.getName().equals("X")){
						ProbabilisticNode varSymptom = new ProbabilisticNode();
						varSymptom.setName(var.getValue().toString());
						varSymptom.appendState("da");
						varSymptom.appendState("ne");
						System.out.println(bolest+" "+var.getValue());
						net.addNode(varSymptom);
						PotentialTable probSymptom = varSymptom.getProbabilityFunction();
						probSymptom.addVariable(varSymptom);

						net.addEdge( new Edge(varBolest, varSymptom) );

						JIPQuery query1=engine.openSynchronousQuery(bolest+"("+var.getValue().toString()+",Y)");
						JIPTerm solution1;
						while ( (solution1 = query1.nextSolution()) != null) {
							for (JIPVariable var1 : solution1.getVariables()) {
								probSymptom.setValue(0, Float.parseFloat(var1.getValue().toString())/100);  // taxi is blue & witness observed as blue
								probSymptom.setValue(1, 1-Float.parseFloat(var1.getValue().toString())/100);
							}
						}

						float x=calculateFalsePercent(var.getValue().toString(),bolest);
						// taxi is green & witness observed as blue
						probSymptom.setValue(2, x);  // taxi is blue & witness observed as green
						probSymptom.setValue(3, 1-x);  // taxi is green & witness observed as green
					}
				}
			}

			new NetIO().save(new File(bolest+".net"), net);
		}
		
		


	}
	
	private static float calculateFalsePercent(String symptom,String b){
		JIPEngine engine = new JIPEngine();
		engine.consultFile("program.pl");
		float ret=0;
		JIPQuery query;
		JIPTerm solution;
		
		for (String bolest:bolesti) {
			if(b.equals(bolest)){
				continue;
			}
			query = engine.openSynchronousQuery(bolest+"("+symptom+",X)");
			while ( (solution = query.nextSolution()) != null) {
				for (JIPVariable var: solution.getVariables()) {
					JIPQuery query1 = engine.openSynchronousQuery("prevalence("+bolest+",X)");
					JIPTerm solution1;
					while ( (solution1 = query1.nextSolution()) != null) {
						for (JIPVariable var1: solution1.getVariables()) {
							ret+=Float.parseFloat(var.getValue().toString())/100*Float.parseFloat(var1.getValue().toString())/100;
						}
					}
					
				}
			}
		}
		
		return ret;
	}

}
