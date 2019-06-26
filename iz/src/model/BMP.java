package model;

public class BMP {
    private double glucose;
    private double calcium;
    private double sodium;
    private double potassium;
    private double urea;
    private double creatinine;
    private double bilirubin;

    public BMP(){

    }

    public BMP(double glucose, double calcium, double sodium, double potassium, double urea, double creatinine, double bilirubin) {
        this.glucose = glucose;
        this.calcium = calcium;
        this.sodium = sodium;
        this.potassium = potassium;
        this.urea = urea;
        this.creatinine = creatinine;
        this.bilirubin = bilirubin;
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
}
