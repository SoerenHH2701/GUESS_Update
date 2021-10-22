package com.pigo.guess_reloaded;

// Tabellendefinition für die selektierten Fragen und Antworten.
// Hier werden die Fragen und Antworten gespeichert / abgefragt, sofern der User eine Schwierigkeitsstufe und eine Kategorie wählt

public class DB_Columns_QA {

    int idQA;
    String frageQA;
    String antwortQA;
    public DB_Columns_QA(){   }
    public DB_Columns_QA(int idQA, String frageQA, String antwortQA){
        this.idQA = idQA;
        this.frageQA = frageQA;
        this.antwortQA = antwortQA;
    }

    public DB_Columns_QA(String frageQA, String antwortQA){
        this.frageQA = frageQA;
        this.antwortQA = antwortQA;
    }
    public int getIdQA(){
        return this.idQA;
    }

    public void setIdQA(int idQA){
        this.idQA = idQA;
    }

    public String getfrageQA(){
        return this.frageQA;
    }

    public void setfrageQA(String frageQA){
        this.frageQA = frageQA;
    }

    public String getantwortQA(){
        return this.antwortQA;
    }

    public void setantwortQA(String antwortQA){
        this.antwortQA = antwortQA;
    }



}
