package com.pigo.guess_reloaded;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DB_Handler db;
    private final List<Integer> shuffleList = new ArrayList<>();
    private Integer shuffelListIncrease = 0, androidProgress = 0, maxLife = 10, minLife = 0;
    private String dbFrage, dbAntwort, dbAntwFalsch1, dbAntwFalsch2, dbAntwFalsch3;
    private TextView tvFrageDB, tvAntwortDB;
    private Button antwort1, antwort2, antwort3, antwort4, buttonNewGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Deaktiviere Button New Game
        Button buttonNewGame = (findViewById(R.id.buttonNewGame));
        buttonNewGame.setEnabled(false);
        buttonNewGame.setVisibility(View.GONE);

        db = new DB_Handler(this);
        db.removeAllRowsFromNewsTable();

        // Initialisierung der Listen
        List<DB_Columns_QANDA> qanda = db.getAllQANDA();
        List<DB_Columns_QA> qa = db.getAllQA();

        // Prüfe Größe der Tabelle; wenn Tabellengröße abweichend wird die Tabelle gedropped und die Fragen hinzugefügt (onUpgrade)
        if (db.getSizeQA("selected_qa_table") != 0) {

        } else {
            for (DB_Columns_QANDA cn : qanda) {
                db.addSelectedQA(new DB_Columns_QA(cn.getFrage(), cn.getAntwort(), cn.getAntwort_falsch_1(), cn.getAntwort_falsch_2(), cn.getAntwort_falsch_3()));
            }
        }

        // Beziehe die Daten aus Tabelle "Selected_QA_Table" und mische diese zufällig
        for (int i = 0; i < db.getSize("selected_qa_table"); i++) {
            shuffleList.add(i);
        }
        Collections.shuffle(shuffleList);
        setFragenToButtons();

    }

    public void addToProgressBar() {
        ProgressBar progressBar = (findViewById(R.id.progressBar));
        for (int a = 0; a <= 9; a++) {
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                androidProgress = androidProgress + 1;
                progressBar.setProgress(androidProgress);
            }, 50 * a);
        }
    }

    public void setFragenToButtons() {

        Button buttonNewGame = (findViewById(R.id.buttonNewGame));
        ProgressBar progressBar = (findViewById(R.id.progressBar));

        // Beziehe Fragen und Antworten und speichere sie in Variable
        dbFrage = getFrage(shuffleList.get(shuffelListIncrease));
        dbAntwort = getAntwort(shuffleList.get(shuffelListIncrease));
        dbAntwFalsch1 = getDbAntwFalsch1(shuffleList.get(shuffelListIncrease));
        dbAntwFalsch2 = getDbAntwFalsch2(shuffleList.get(shuffelListIncrease));
        dbAntwFalsch3 = getDbAntwFalsch3(shuffleList.get(shuffelListIncrease));

        // Speicher Antwortmöglichkeiten in List und shuffle, damit Antworten an unterschiedlichen Stellen stehen
        ArrayList<String> antworten = new ArrayList<>();
        antworten.add(dbAntwort);
        antworten.add(dbAntwFalsch1);
        antworten.add(dbAntwFalsch2);
        antworten.add(dbAntwFalsch3);

        Collections.shuffle(antworten);

        Button antwort1 = findViewById(R.id.antwort1);
        Button antwort2 = findViewById(R.id.antwort2);
        Button antwort3 = findViewById(R.id.antwort3);
        Button antwort4 = findViewById(R.id.antwort4);

        for (int i = 0; i < antworten.size(); i++) {
            antwort1.setText(antworten.get(0));
            antwort2.setText(antworten.get(1));
            antwort3.setText(antworten.get(2));
            antwort4.setText(antworten.get(3));
        }

        String antwort1Text = antwort1.getText().toString();
        String antwort2Text = antwort2.getText().toString();
        String antwort3Text = antwort3.getText().toString();
        String antwort4Text = antwort4.getText().toString();

        antwort1.setOnClickListener(v -> {
            String ButtonAntw1Text = antwort1.getText().toString();

            antwort1.setEnabled(false);
            antwort2.setEnabled(false);
            antwort3.setEnabled(false);
            antwort4.setEnabled(false);

            if (dbAntwort.equals(ButtonAntw1Text)) {
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(6);
                if (anim.getRepeatCount() >= 6) {
                    antwort1.setBackgroundColor(getResources().getColor(R.color.green));
                    addToProgressBar();
                    Handler handler = new Handler();
                    handler.postDelayed(() -> {
                        antwort1.setEnabled(true);
                        antwort2.setEnabled(true);
                        antwort3.setEnabled(true);
                        antwort4.setEnabled(true);
                        antwort1.setBackgroundColor(getResources().getColor(R.color.buttonDefault));
                        shuffelListIncrease++;
                        if (androidProgress < 100) {
                            setFragenToButtons();
                        }
                        if (androidProgress == 100) {
                            Intent i = new Intent(MainActivity.this, Winner.class);
                            startActivity(i);
                        }
                    }, 3000);
                }
                antwort1.startAnimation(anim);
            } else {
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(6);
                antwort1.startAnimation(anim);
                antwort1.setBackgroundColor(getResources().getColor(R.color.red));

                if (dbAntwort.equals(antwort2Text)) {
                    antwort2.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (dbAntwort.equals(antwort3Text)) {
                    antwort3.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (dbAntwort.equals(antwort4Text)) {
                    antwort4.setBackgroundColor(getResources().getColor(R.color.green));
                }
                buttonNewGame.setVisibility(View.VISIBLE);
                buttonNewGame.setEnabled(true);
                buttonNewGame.setOnClickListener(v1 -> {
                    Intent i = new Intent(MainActivity.this, Difficulty.class);
                    startActivity(i);
                });

            }
        });

        antwort2.setOnClickListener(v -> {
            String ButtonAntw2Text = antwort2.getText().toString();

            // Buttons deaktivieren
            antwort1.setEnabled(false);
            antwort2.setEnabled(false);
            antwort3.setEnabled(false);
            antwort4.setEnabled(false);

            if (dbAntwort.equals(ButtonAntw2Text)) {
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(6);
                if (anim.getRepeatCount() >= 6) {
                    antwort2.setBackgroundColor(getResources().getColor(R.color.green));
                    addToProgressBar();
                    Handler handler = new Handler();
                    handler.postDelayed(() -> {
                        // Buttons wieder aktivieren
                        antwort1.setEnabled(true);
                        antwort2.setEnabled(true);
                        antwort3.setEnabled(true);
                        antwort4.setEnabled(true);
                        antwort2.setBackgroundColor(getResources().getColor(R.color.buttonDefault));
                        shuffelListIncrease++;
                        if (androidProgress < 100) {
                            setFragenToButtons();
                        }
                        if (androidProgress == 100) {
                            Intent i = new Intent(MainActivity.this, Winner.class);
                            startActivity(i);
                        }
                    }, 3000);
                }
                antwort2.startAnimation(anim);
            } else {
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(6);
                antwort2.startAnimation(anim);
                antwort2.setBackgroundColor(getResources().getColor(R.color.red));

                if (dbAntwort.equals(antwort1Text)) {
                    antwort1.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (dbAntwort.equals(antwort3Text)) {
                    antwort3.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (dbAntwort.equals(antwort4Text)) {
                    antwort4.setBackgroundColor(getResources().getColor(R.color.green));
                }
                buttonNewGame.setVisibility(View.VISIBLE);
                buttonNewGame.setEnabled(true);
                buttonNewGame.setOnClickListener(v1 -> {
                    Intent i = new Intent(MainActivity.this, Difficulty.class);
                    startActivity(i);
                });
            }
        });

        antwort3.setOnClickListener(v -> {
            String ButtonAntw3Text = antwort3.getText().toString();

            antwort1.setEnabled(false);
            antwort2.setEnabled(false);
            antwort3.setEnabled(false);
            antwort4.setEnabled(false);

            if (dbAntwort.equals(ButtonAntw3Text)) {

                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(6);
                if (anim.getRepeatCount() >= 6) {
                    antwort3.setBackgroundColor(getResources().getColor(R.color.green));
                    addToProgressBar();
                    Handler handler = new Handler();
                    handler.postDelayed(() -> {
                        antwort1.setEnabled(true);
                        antwort2.setEnabled(true);
                        antwort3.setEnabled(true);
                        antwort4.setEnabled(true);
                        antwort3.setBackgroundColor(getResources().getColor(R.color.buttonDefault));
                        shuffelListIncrease++;
                        if (androidProgress < 100) {
                            setFragenToButtons();
                        }
                        if (androidProgress == 100) {
                            Intent i = new Intent(MainActivity.this, Winner.class);
                            startActivity(i);
                        }
                    }, 3000);
                }
                antwort3.startAnimation(anim);
            } else {
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(6);

                antwort3.startAnimation(anim);
                antwort3.setBackgroundColor(getResources().getColor(R.color.red));

                if (dbAntwort.equals(antwort1Text)) {
                    antwort1.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (dbAntwort.equals(antwort2Text)) {
                    antwort2.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (dbAntwort.equals(antwort4Text)) {
                    antwort4.setBackgroundColor(getResources().getColor(R.color.green));
                }
                buttonNewGame.setVisibility(View.VISIBLE);
                buttonNewGame.setEnabled(true);
                buttonNewGame.setOnClickListener(v1 -> {
                    Intent i = new Intent(MainActivity.this, Difficulty.class);
                    startActivity(i);
                });
            }
        });

        antwort4.setOnClickListener(v -> {
            String ButtonAntw4Text = antwort4.getText().toString();

            antwort1.setEnabled(false);
            antwort2.setEnabled(false);
            antwort3.setEnabled(false);
            antwort4.setEnabled(false);

            if (dbAntwort.equals(ButtonAntw4Text)) {
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(6);
                if (anim.getRepeatCount() >= 6) {
                    antwort4.setBackgroundColor(getResources().getColor(R.color.green));
                    addToProgressBar();
                    Handler handler = new Handler();
                    handler.postDelayed(() -> {
                        antwort1.setEnabled(true);
                        antwort2.setEnabled(true);
                        antwort3.setEnabled(true);
                        antwort4.setEnabled(true);
                        antwort4.setBackgroundColor(getResources().getColor(R.color.buttonDefault));
                        shuffelListIncrease++;
                        if (androidProgress < 100) {
                            setFragenToButtons();
                        }
                        if (androidProgress == 100) {
                            Intent i = new Intent(MainActivity.this, Winner.class);
                            startActivity(i);
                        }
                    }, 3000);
                }
                antwort4.startAnimation(anim);
            } else {
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(100);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(6);
                antwort4.startAnimation(anim);
                antwort4.setBackgroundColor(getResources().getColor(R.color.red));

                if (dbAntwort.equals(antwort1Text)) {
                    antwort1.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (dbAntwort.equals(antwort2Text)) {
                    antwort2.setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (dbAntwort.equals(antwort3Text)) {
                    antwort3.setBackgroundColor(getResources().getColor(R.color.green));
                }
                buttonNewGame.setVisibility(View.VISIBLE);
                buttonNewGame.setEnabled(true);
                buttonNewGame.setOnClickListener(v1 -> {
                    Intent i = new Intent(MainActivity.this, Difficulty.class);
                    startActivity(i);
                });
            }
        });

        tvFrageDB = findViewById(R.id.TextViewFrageDB);
        tvAntwortDB = findViewById(R.id.TextViewAntwortDB);

        tvFrageDB.setText(getFrage(shuffleList.get(shuffelListIncrease)));

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

    // Beziehe Antwort_falsch_1 aus Tabelle
    public String getDbAntwFalsch1(int iAntwFalsch1) {
        return db.getAllQA().get(iAntwFalsch1).getAntwort_falsch_1_QA();
    }

    // Beziehe Antwort_falsch_2 aus Tabelle
    public String getDbAntwFalsch2(int iAntwFalsch2) {
        return db.getAllQA().get(iAntwFalsch2).getAntwort_falsch_2_QA();
    }

    // Beziehe Antwort_falsch_1 aus Tabelle
    public String getDbAntwFalsch3(int iAntwFalsch3) {
        return db.getAllQA().get(iAntwFalsch3).getAntwort_falsch_3_QA();
    }

}