package com.pigo.guess_reloaded;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class Category extends AppCompatActivity {

    static String clickedKategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button KtgAllg = findViewById(R.id.btnKtgAllg);
        KtgAllg.setOnClickListener(v -> {
            Intent i = new Intent(Category.this, MainActivity.class);
            clickedKategorie = "allgemein";
            startActivity(i);
        });

        Button KtgAktuelles = findViewById(R.id.btnKtgAktuelles);
        KtgAktuelles.setOnClickListener(v -> {
            Intent i = new Intent(Category.this, MainActivity.class);
            clickedKategorie = "aktuelles";
            startActivity(i);
        });

        Button KtgGeschichte = findViewById(R.id.btnKtgGeschichte);
        KtgGeschichte.setOnClickListener(v -> {
            Intent i = new Intent(Category.this, MainActivity.class);
            clickedKategorie = "geschichte";
            startActivity(i);
        });
    }

}
