package model;

public class CBC {
    private double redBloodCellCount;
    private double hemoglobin;
    private double hematocrit;
    private double whiteBloodCellCount;
    private double platelet;

    public CBC(){

    }

    public CBC(double redBloodCellCount, double hemoglobin, double hematocrit, double whiteBloodCellCount, double platelet) {
        this.redBloodCellCount = redBloodCellCount;
        this.hemoglobin = hemoglobin;
        this.hematocrit = hematocrit;
        this.whiteBloodCellCount = whiteBloodCellCount;
        this.platelet = platelet;
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
}
