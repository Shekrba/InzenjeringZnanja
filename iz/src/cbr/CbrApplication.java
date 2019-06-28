package cbr;


import gui.MainFrame;
import model.Bolest;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.*;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.MaxString;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Threshold;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CbrApplication implements StandardCBRApplication {

	private boolean cbc;
	private boolean bmp;

	Connector _connector;  /** Connector object */
	CBRCaseBase _caseBase;  /** CaseBase object */

	NNConfig simConfig;  /** KNN configuration */
	
	public void configure() throws ExecutionException {
		_connector =  new CsvConnector();
		
		_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
		
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
		
		// simConfig.addMapping(new Attribute("id", ExaminationDescription.class), new Interval(1));
		simConfig.addMapping(new Attribute("symptoms", ExaminationDescription.class), new MaxString());
		//simConfig.addMapping(new Attribute("price", ExaminationDescription.class), new Interval(100));
		simConfig.addMapping(new Attribute("temperature", ExaminationDescription.class), new Interval(1.2));
		simConfig.addMapping(new Attribute("pressureHigh", ExaminationDescription.class), new Interval(15));
		simConfig.addMapping(new Attribute("pressureLow", ExaminationDescription.class), new Interval(15));
		simConfig.addMapping(new Attribute("bmi", ExaminationDescription.class), new Interval(3));
		if(cbc) {
			simConfig.addMapping(new Attribute("redBloodCellCount", ExaminationDescription.class), new Interval(1));
			simConfig.addMapping(new Attribute("hemoglobin", ExaminationDescription.class), new Interval(3));
			simConfig.addMapping(new Attribute("hematocrit", ExaminationDescription.class), new Interval(8));
			simConfig.addMapping(new Attribute("whiteBloodCellCount", ExaminationDescription.class), new Interval(2));
			simConfig.addMapping(new Attribute("platelet", ExaminationDescription.class), new Interval(100));
		}
		if(bmp){
			simConfig.addMapping(new Attribute("glucose", ExaminationDescription.class), new Interval(20));
			simConfig.addMapping(new Attribute("calcium", ExaminationDescription.class), new Interval(3));
			simConfig.addMapping(new Attribute("sodium", ExaminationDescription.class), new Interval(28));
			simConfig.addMapping(new Attribute("potassium", ExaminationDescription.class), new Interval(1.5));
			simConfig.addMapping(new Attribute("urea", ExaminationDescription.class), new Interval(2));
			simConfig.addMapping(new Attribute("creatinine", ExaminationDescription.class), new Interval(30));
			simConfig.addMapping(new Attribute("bilirubin", ExaminationDescription.class), new Interval(0.2));
		}
		simConfig.addMapping(new Attribute("age", ExaminationDescription.class), new Threshold(7));
		simConfig.addMapping(new Attribute("sex", ExaminationDescription.class), new Equal());
		

		
		//simConfig.addMapping(new Attribute("duration", ExaminationDescription.class), new Interval(2));
		// simConfig.addMapping(new Attribute("season", ExaminationDescription.class), new Equal());
		// simConfig.addMapping(new Attribute("accommodation", ExaminationDescription.class), new Equal());
		// simConfig.addMapping(new Attribute("hotel", ExaminationDescription.class), new Equal());

		// Equal - returns 1 if both individuals are equal, otherwise returns 0
		// Interval - returns the similarity of two number inside an interval: sim(x,y) = 1-(|x-y|/interval)
		// Threshold - returns 1 if the difference between two numbers is less than a threshold, 0 in the other case
		// EqualsStringIgnoreCase - returns 1 if both String are the same despite case letters, 0 in the other case
		// MaxString - returns a similarity value depending of the biggest substring that belong to both strings
		// EnumDistance - returns the similarity of two enum values as the their distance: sim(x,y) = |ord(x) - ord(y)|
		// EnumCyclicDistance - computes the similarity between two enum values as their cyclic distance
		// Table - uses a table to obtain the similarity between two values. Allowed values are Strings or Enums. The table is read from a text file.
		// TableSimilarity(List<String> values).setSimilarity(value1,value2,similarity) 
	}

	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 5);
		System.out.println("Retrieved cases:");
		MainFrame.setBolesti(new ArrayList<>());
		HashMap<String,Double> sum=new HashMap<String,Double>();
		HashMap<String,Integer> br=new HashMap<String,Integer>();
		for (RetrievalResult nse : eval) {
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
			if(nse.getEval()>0) {
				if (sum.containsKey(nse.get_case().getDescription().toString())) {
					Double d = sum.get(nse.get_case().getDescription().toString());
					d += nse.getEval();
					sum.put(nse.get_case().getDescription().toString(), d);
					Integer integer = br.get(nse.get_case().getDescription().toString());
					integer++;
					br.put(nse.get_case().getDescription().toString(), integer);
				} else {
					sum.put(nse.get_case().getDescription().toString(), nse.getEval());
					br.put(nse.get_case().getDescription().toString(), 1);
				}
			}
		}
		for(String boles : sum.keySet()){
			Bolest bolest=new Bolest();
			bolest.setNaziv(boles);
			bolest.setProcenat(Math.round((float)(double)sum.get(boles)/br.get(boles)*100));
			MainFrame.getBolesti().add(bolest);
		}

	}

	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		Collection<CBRCase> cases = _caseBase.getCases();
		for (CBRCase c: cases)
			System.out.println(c.getDescription());
		return _caseBase;
	}

	public void doCbr(ArrayList<String> symptoms,boolean bmpTest,boolean cbcTest){
		StandardCBRApplication recommender = new CbrApplication();
		for(String symptom:symptoms) {
			try {
				recommender.configure();

				recommender.preCycle();

				CBRQuery query = new CBRQuery();


				ExaminationDescription examinationDescription = new ExaminationDescription();
				examinationDescription.setSymptoms(symptom);
				examinationDescription.setTemperature(MainFrame.getTemperatura());
				examinationDescription.setPressureLow((int)MainFrame.getPritisakLow());
				examinationDescription.setPressureHigh((int)MainFrame.getPritisakHigh());
				examinationDescription.setSex(MainFrame.getPol());
				examinationDescription.setBmi(MainFrame.getBmi());
				cbc=cbcTest;
				if(cbcTest){
					examinationDescription.setWhiteBloodCellCount(MainFrame.getCbc().getWhiteBloodCellCount());
					examinationDescription.setRedBloodCellCount(MainFrame.getCbc().getRedBloodCellCount());
					examinationDescription.setHematocrit(MainFrame.getCbc().getHematocrit());
					examinationDescription.setHemoglobin(MainFrame.getCbc().getHemoglobin());
					examinationDescription.setPlatelet(MainFrame.getCbc().getPlatelet());
				}
				bmp=bmpTest;
				if(bmpTest){
					examinationDescription.setGlucose(MainFrame.getBmp().getGlucose());
					examinationDescription.setSodium(MainFrame.getBmp().getSodium());
					examinationDescription.setPotassium(MainFrame.getBmp().getPotassium());
					examinationDescription.setCalcium(MainFrame.getBmp().getCalcium());
					examinationDescription.setUrea(MainFrame.getBmp().getUrea());
					examinationDescription.setCreatinine(MainFrame.getBmp().getCreatinine());
					examinationDescription.setBilirubin(MainFrame.getBmp().getBilirubin());
				}

				query.setDescription(examinationDescription);
				recommender.cycle(query);

				recommender.postCycle();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}