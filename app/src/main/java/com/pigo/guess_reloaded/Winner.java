package com.pigo.guess_reloaded;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_winner);

        Button btnWinner = (findViewById(R.id.btnRestart));

        btnWinner.setOnClickListener(v -> {
            Intent i = new Intent(Winner.this, Difficulty.class);
            startActivity(i);
        });

    }
}
