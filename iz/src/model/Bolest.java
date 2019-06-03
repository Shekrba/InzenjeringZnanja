package model;

import java.util.ArrayList;

public class Bolest {
    private ArrayList<String> simptomi;
    private int procenat;
    private int poklapanje;
    private String naziv;

    public Bolest(){

    }

    public Bolest(ArrayList<String> simptomi, int procenat, int poklapanje, String naziv) {
        this.simptomi = simptomi;
        this.procenat = procenat;
        this.poklapanje = poklapanje;
        this.naziv = naziv;
    }

    public int getPoklapanje() {
        return poklapanje;
    }

    public void setPoklapanje(int poklapanje) {
        this.poklapanje = poklapanje;
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
