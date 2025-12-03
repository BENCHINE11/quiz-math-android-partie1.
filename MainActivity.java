package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvNumber1;
    private TextView tvNumber2;
    private TextView tvResult;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMul;
    private Button btnGenerate;

    private int currentNumber1;
    private int currentNumber2;

    private Random random;   // pour générer les nombres

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Récupérer les vues
        tvNumber1 = findViewById(R.id.tvNumber1);
        tvNumber2 = findViewById(R.id.tvNumber2);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnGenerate = findViewById(R.id.btnGenerate);

        random = new Random();

        // 2. Générer les premiers nombres
        generateNewNumbers();

        // 3. Gérer les événements des boutons

        // Bouton +
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = currentNumber1 + currentNumber2;
                tvResult.setText(String.valueOf(result));
            }
        });

        // Bouton -
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = currentNumber1 - currentNumber2;
                tvResult.setText(String.valueOf(result));
            }
        });

        // Bouton ×
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = currentNumber1 * currentNumber2;
                tvResult.setText(String.valueOf(result));
            }
        });

        // Bouton Générer
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewNumbers();
                tvResult.setText(getString(R.string.label_result)); // on réinitialise le texte du résultat
            }
        });
    }

    /**
     * Génère deux nombres aléatoires entre 111 et 999
     * et les affiche dans les TextView.
     */
    private void generateNewNumbers() {
        // nombre compris entre 111 et 999
        // random.nextInt((max - min) + 1) + min
        currentNumber1 = random.nextInt((999 - 111) + 1) + 111;
        currentNumber2 = random.nextInt((999 - 111) + 1) + 111;

        tvNumber1.setText(String.valueOf(currentNumber1));
        tvNumber2.setText(String.valueOf(currentNumber2));
    }
}
