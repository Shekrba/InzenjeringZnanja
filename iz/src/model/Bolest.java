package model;

import java.util.ArrayList;
import java.util.List;

public class Bolest {
    ArrayList<String> simptomi;
    int procenat;
    String naziv;

    public Bolest(ArrayList<String> simptomi, int procenat, String naziv) {
        this.simptomi = simptomi;
        this.procenat = procenat;
        this.naziv = naziv;
    }

    public ArrayList<String> getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(ArrayList<String> simptomi) {
        this.simptomi = simptomi;
    }

    public int getProcenat() {
        return procenat;
    }

    public void setProcenat(int procenat) {
        this.procenat = procenat;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
