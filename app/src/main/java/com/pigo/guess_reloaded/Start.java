package com.pigo.guess_reloaded;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        DB_Handler db = new DB_Handler(this);

        // Prüfe Größe der Tabelle; wenn Tabellengröße abweichend wird die Tabelle gedropped und die Fragen hinzugefügt (onUpgrade)

        if (db.getSize("questions_and_answers_table") != 0) {
        } else {

            db.addQANDA(new DB_Columns_QANDA("Wie viele Weihnachtsbäume werden in Deutschland pro Jahr verkauft?","30000000","leicht","10","20","30"));
            db.addQANDA(new DB_Columns_QANDA("Im Jahr 2013 gab es in Deutschland ungefähr 15.000 Tankstellen. Wie viele Tankstellen gab es vor noch 50 Jahren um das Jahr 1970?","60000","leicht","40","50","60"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Piratenüberfälle gab es 2012 weltweit?","300","schwer","70","80","90"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Menschen in Deutschland nutzen ein Smartphone?","40000000","leicht","100","110","120"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Krankenkassen gibt es in Deutschland?","113","mittel","130","140","150"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Kinder wurden 2014 nicht im Krankenhaus geboren?","11391","schwer","160","170","180"));
            db.addQANDA(new DB_Columns_QANDA("Durchschnittliche Entferung, in der Menschen in den USA zu Ihrer Mutter Wohnen (km)","29","schwer","190","200","210"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel Prozent der Tinder Nutzer sind in einer Beziehung?","42","mittel","220","230","240"));
            db.addQANDA(new DB_Columns_QANDA("Betrag, den Facebook-Mitarbeiter bekommen können, wenn sie ihre Eizelle einfrieren lassen ($)","20000","mittel","250","260","270"));
            db.addQANDA(new DB_Columns_QANDA("Feinstaubbelastung in Deutschland durch den Straßenverkehr eines Monats (t)","2222","leicht","280","290","300"));
            db.addQANDA(new DB_Columns_QANDA("Feinstaubbelastung in Deutschland durch die Feuerwerke einer Sylvesternacht (t)","4000","mittel","310","320","330"));

            System.out.println("DB ROWS ADDED");

        }

        Button start = findViewById(R.id.btnStart);
        start.setVisibility(View.GONE);

        TextView tvLogo = findViewById(R.id.tvLogo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvLogo.append("G");
            }
        }, 600);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvLogo.append("U");
            }
        }, 900);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvLogo.append("E");
            }
        }, 1200);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvLogo.append("S");
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvLogo.append("S");
            }
        }, 1800);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                start.setVisibility(View.VISIBLE);
            }
        }, 2100);

        start.setOnClickListener(v -> {
            Intent i = new Intent(Start.this, Difficulty.class);
            startActivity(i);
        });

    }



}
