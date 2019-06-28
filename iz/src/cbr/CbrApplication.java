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
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

import java.util.ArrayList;
import java.util.Collection;

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
		simConfig.addMapping(new Attribute("type", ExaminationDescription.class), new Equal());
		//simConfig.addMapping(new Attribute("price", ExaminationDescription.class), new Interval(100));
		simConfig.addMapping(new Attribute("persons", ExaminationDescription.class), new Interval(2));
		simConfig.addMapping(new Attribute("region", ExaminationDescription.class), new Equal());
		

		
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
		for (RetrievalResult nse : eval)
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
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

/*
				ExaminationDescription examinationDescription = new ExaminationDescription();
				examinationDescription.setType("Skiing");
				examinationDescription.setPersons(4);
				examinationDescription.setRegion("France");
				examinationDescription.setTransportation("Plane");
				examinationDescription.setDuration(7);

				query.setDescription(examinationDescription);
				recommender.cycle(query);

				recommender.postCycle();*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}