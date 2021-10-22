package com.pigo.guess_reloaded;

import static java.security.AccessController.getContext;
import static java.util.Collections.shuffle;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView desk;
    private DB_Handler db;
    private final List<Integer> shuffleList = new ArrayList<>();
    private Integer shuffelListIncrease = 0;
    private String dbFrage;
    private String dbAntwort;
    private TextView tvFrageDB, tvAntwortDB, etAntwortUser;
    private Button btnNaechsteFrage, btnNeuesSpiel, btnLoesen, btnHighscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DB_Handler(this);

        // Initialisierung der Listen
        List<DB_Columns_QANDA> qanda = db.getAllQANDA();
        List<DB_Columns_QA> qa = db.getAllQA();

        // Prüfe Größe der Tabelle; wenn Tabellengröße abweichend wird die Tabelle gedropped und die Fragen hinzugefügt (onUpgrade)
        if (db.getSizeQA("selected_qa_table") != 0) {

        } else {
            for (DB_Columns_QANDA cn : qanda) {
                db.addSelectedQA(new DB_Columns_QA(cn.getFrage(), cn.getAntwort()));
            }
        }

        // Beziehe die Daten aus Tabelle "Selected_QA_Table" und mische diese zufällig
        for (int i = 0; i < db.getSize("selected_qa_table"); i++) {
            shuffleList.add(i);
            System.out.println(i);
        }

        Collections.shuffle(shuffleList);
        System.out.println(shuffleList);

        // Beziehe Fragen und Antworten und speichere sie in Variable
        dbFrage = getFrage(shuffleList.get(shuffelListIncrease));
        dbAntwort = getAntwort(shuffleList.get(shuffelListIncrease));

        tvFrageDB = findViewById(R.id.TextViewFrageDB);
        tvAntwortDB = findViewById(R.id.TextViewAntwortDB);

        tvFrageDB.setText(getFrage(shuffleList.get(shuffelListIncrease)));
        tvAntwortDB.setText(dbAntwort);

        System.out.println(dbFrage);
        System.out.println(dbAntwort);


    }

    // Beziehe Frage aus Tabelle
    public String getFrage(int iFrage) {
        return db.getAllQA().get(iFrage).getfrageQA();
    }

    // Beziehe Antwort aus Tabelle
    public String getAntwort(int iAntwort) {
        return db.getAllQA().get(iAntwort).getantwortQA();
    }


}