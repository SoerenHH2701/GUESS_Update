package com.pigo.guess_reloaded;

public class DB_Columns_QANDA {

    int id;
    String frage;
    String antwort;
    String kategorie;
    String schwierigkeit;

    public DB_Columns_QANDA(){
    }

    public DB_Columns_QANDA(String frage, String antwort, String kategorie, String schwierigkeit){
        this.frage = frage;
        this.antwort = antwort;
        this.kategorie = kategorie;
        this.schwierigkeit = schwierigkeit;
    }
    // getting ID
    public int getID() { return this.id; };

    // setting ID
    public void setID(int id){
        this.id = id;
    }

    // getting Frage
    public String getFrage(){
        return this.frage;
    }

    // setting Frage
    public void setFrage(String frage){
        this.frage = frage;
    }

    // getting Antwort
    public String getAntwort(){
        return this.antwort;
    }

    // setting Antwort
    public void setAntwort(String anwort){
        this.antwort = anwort;
    }

    // getting Kategorie
    public String getKategorie() { return this.kategorie; }

    // setting Kategorie
    public  void setKategorie(String kategorie) { this.kategorie = kategorie; }

    // getting Schwierigkeit
    public String getSchwierigkeit() { return this.schwierigkeit; }

    // setting Schwierigkeit
    public void setSchwierigkeit(String schwierigkeit) { this.schwierigkeit = schwierigkeit; }
}