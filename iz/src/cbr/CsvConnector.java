package cbr;


import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

public class CsvConnector implements Connector {
	
	@Override
	public Collection<CBRCase> retrieveAllCases() {
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile("data/results.csv")));
			if (br == null)
				throw new Exception("Error opening file");

			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#") || (line.length() == 0))
					continue;
				String[] values = line.split(";");

				CBRCase cbrCase = new CBRCase();

				ExaminationDescription examinationDescription = new ExaminationDescription();
				examinationDescription.setSymptoms(values[0]);
				examinationDescription.setTemperature(Double.parseDouble(values[1]));
				examinationDescription.setPressureHigh(Integer.parseInt(values[2]));
				examinationDescription.setPressureLow(Integer.parseInt(values[3]));
				examinationDescription.setBmi(Double.parseDouble(values[4]));
				examinationDescription.setRedBloodCellCount(Double.parseDouble(values[5]));
				examinationDescription.setHemoglobin(Double.parseDouble(values[6]));
				examinationDescription.setHematocrit(Double.parseDouble(values[7]));
				examinationDescription.setWhiteBloodCellCount(Double.parseDouble(values[8]));
				examinationDescription.setPlatelet(Double.parseDouble(values[9]));
				examinationDescription.setGlucose(Double.parseDouble(values[10]));
				examinationDescription.setCalcium(Double.parseDouble(values[11]));
				examinationDescription.setSodium(Double.parseDouble(values[12]));
				examinationDescription.setPotassium(Double.parseDouble(values[13]));
				examinationDescription.setUrea(Double.parseDouble(values[14]));
				examinationDescription.setCreatinine(Double.parseDouble(values[15]));
				examinationDescription.setBilirubin(Double.parseDouble(values[16]));
				examinationDescription.setAge(Integer.parseInt(values[17]));
				examinationDescription.setSex(values[18]);
				examinationDescription.setBolest(values[19]);
				
				cbrCase.setDescription(examinationDescription);
				cases.add(cbrCase);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cases;
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
	}
	
	@Override
	public void close() {
	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
	}

}