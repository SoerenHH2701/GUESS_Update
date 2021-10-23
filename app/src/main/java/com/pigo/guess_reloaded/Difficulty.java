package com.pigo.guess_reloaded;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class Difficulty extends AppCompatActivity {

    static String clickedDifficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        Button leicht = findViewById(R.id.btnSchwierigkeitLeicht);
        leicht.setOnClickListener(v -> {
            Intent i = new Intent(Difficulty.this, MainActivity.class);
            clickedDifficulty = "leicht";
            startActivity(i);
        });

        Button mittel = findViewById(R.id.btnSchwierigkeitMittel);
        mittel.setOnClickListener(v -> {
            Intent i = new Intent(Difficulty.this, MainActivity.class);
            clickedDifficulty = "mittel";
            startActivity(i);
        });

        Button schwer = findViewById(R.id.btnSchwierigkeitSchwer);
        schwer.setOnClickListener(v -> {
            Intent i = new Intent(Difficulty.this, MainActivity.class);
            clickedDifficulty = "schwer";
            startActivity(i);
        });
    }
}
