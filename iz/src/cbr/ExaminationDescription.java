package cbr;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class ExaminationDescription implements CaseComponent {

	private String symptoms;
	private double temperature;
	private int pressureHigh;
	private int pressureLow;
	private double bmi;
	private double redBloodCellCount;
	private double hemoglobin;
	private double hematocrit;
	private double whiteBloodCellCount;
	private double platelet;
	private double glucose;
	private double calcium;
	private double sodium;
	private double potassium;
	private double urea;
	private double creatinine;
	private double bilirubin;


	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public int getPressureHigh() {
		return pressureHigh;
	}

	public void setPressureHigh(int pressureHigh) {
		this.pressureHigh = pressureHigh;
	}

	public int getPressureLow() {
		return pressureLow;
	}

	public void setPressureLow(int pressureLow) {
		this.pressureLow = pressureLow;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public double getRedBloodCellCount() {
		return redBloodCellCount;
	}

	public void setRedBloodCellCount(double redBloodCellCount) {
		this.redBloodCellCount = redBloodCellCount;
	}

	public double getHemoglobin() {
		return hemoglobin;
	}

	public void setHemoglobin(double hemoglobin) {
		this.hemoglobin = hemoglobin;
	}

	public double getHematocrit() {
		return hematocrit;
	}

	public void setHematocrit(double hematocrit) {
		this.hematocrit = hematocrit;
	}

	public double getWhiteBloodCellCount() {
		return whiteBloodCellCount;
	}

	public void setWhiteBloodCellCount(double whiteBloodCellCount) {
		this.whiteBloodCellCount = whiteBloodCellCount;
	}

	public double getPlatelet() {
		return platelet;
	}

	public void setPlatelet(double platelet) {
		this.platelet = platelet;
	}

	public double getGlucose() {
		return glucose;
	}

	public void setGlucose(double glucose) {
		this.glucose = glucose;
	}

	public double getCalcium() {
		return calcium;
	}

	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}

	public double getSodium() {
		return sodium;
	}

	public void setSodium(double sodium) {
		this.sodium = sodium;
	}

	public double getPotassium() {
		return potassium;
	}

	public void setPotassium(double potassium) {
		this.potassium = potassium;
	}

	public double getUrea() {
		return urea;
	}

	public void setUrea(double urea) {
		this.urea = urea;
	}

	public double getCreatinine() {
		return creatinine;
	}

	public void setCreatinine(double creatinine) {
		this.creatinine = creatinine;
	}

	public double getBilirubin() {
		return bilirubin;
	}

	public void setBilirubin(double bilirubin) {
		this.bilirubin = bilirubin;
	}

	@Override
	public Attribute getIdAttribute() {
		return null;
	}
	
}
