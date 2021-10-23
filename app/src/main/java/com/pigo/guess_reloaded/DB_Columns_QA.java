package com.pigo.guess_reloaded;

// Tabellendefinition für die selektierten Fragen und Antworten.
// Hier werden die Fragen und Antworten gespeichert / abgefragt, sofern der User eine Schwierigkeitsstufe und eine Kategorie wählt

public class DB_Columns_QA {

    int idQA;
    String frageQA;
    String antwortQA;
    String antwort_falsch_1_QA;
    String antwort_falsch_2_QA;
    String antwort_falsch_3_QA;

    public DB_Columns_QA(){   }

    public DB_Columns_QA(String frageQA, String antwortQA, String antwort_falsch_1_QA, String antwort_falsch_2_QA, String antwort_falsch_3_QA){
        this.frageQA = frageQA;
        this.antwortQA = antwortQA;
        this.antwort_falsch_1_QA = antwort_falsch_1_QA;
        this.antwort_falsch_2_QA = antwort_falsch_2_QA;
        this.antwort_falsch_3_QA = antwort_falsch_3_QA;
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

    public String getAntwort_falsch_1_QA() { return this.antwort_falsch_1_QA; }

    public void setAntwort_falsch_1_QA(String antwort_falsch_1_QA) { this.antwort_falsch_1_QA = antwort_falsch_1_QA; }

    public String getAntwort_falsch_2_QA() { return this.antwort_falsch_2_QA; }

    public void setAntwort_falsch_2_QA(String antwort_falsch_2_QA) { this.antwort_falsch_2_QA = antwort_falsch_2_QA; }

    public String getAntwort_falsch_3_QA() { return this.antwort_falsch_3_QA; }

    public void setAntwort_falsch_3_QA(String antwort_falsch_3_QA) { this.antwort_falsch_3_QA = antwort_falsch_3_QA; }



}
