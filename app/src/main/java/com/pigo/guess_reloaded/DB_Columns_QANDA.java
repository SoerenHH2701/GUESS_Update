package com.pigo.guess_reloaded;

public class DB_Columns_QANDA {

    int id;
    String frage;
    String antwort;
    String schwierigkeit;
    String antwort_falsch_1;
    String antwort_falsch_2;
    String antwort_falsch_3;

    public DB_Columns_QANDA(){
    }

    public DB_Columns_QANDA(String frage, String antwort, String schwierigkeit, String antwort_falsch_1, String antwort_falsch_2, String antwort_falsch_3){
        this.frage = frage;
        this.antwort = antwort;
        this.schwierigkeit = schwierigkeit;
        this.antwort_falsch_1 = antwort_falsch_1;
        this.antwort_falsch_2 = antwort_falsch_2;
        this.antwort_falsch_3 = antwort_falsch_3;
    }

    public int getID() { return this.id; };

    public void setID(int id){
        this.id = id;
    }

    public String getFrage(){
        return this.frage;
    }

    public void setFrage(String frage){
        this.frage = frage;
    }

    public String getAntwort(){
        return this.antwort;
    }

    public void setAntwort(String anwort){
        this.antwort = anwort;
    }

    public String getSchwierigkeit() { return this.schwierigkeit; }

    public void setSchwierigkeit(String schwierigkeit) { this.schwierigkeit = schwierigkeit; }

    public String getAntwort_falsch_1() { return this.antwort_falsch_1; }

    public void setAntwort_falsch_1(String antwort_falsch_1) { this.antwort_falsch_1 = antwort_falsch_1; }

    public String getAntwort_falsch_2() { return this.antwort_falsch_2; }

    public void setAntwort_falsch_2(String antwort_falsch_2) { this.antwort_falsch_2 = antwort_falsch_2; }

    public String getAntwort_falsch_3() { return this.antwort_falsch_3; }

    public void setAntwort_falsch_3(String antwort_falsch_3) { this.antwort_falsch_3 = antwort_falsch_3; }
}