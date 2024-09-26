package com.fatec.Navigation_Between_Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tela3 extends AppCompatActivity {

    private Intent in;
    private int score;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);
        init();
    }

    public void init() {

        sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        int background = sharedPreferences.getInt("background", 0);

        if (getIntent().hasExtra("vl_extra")) {
            int vl_recebido = getIntent().getIntExtra("vl_extra", 0);
            TextView txtScore = findViewById(R.id.txtScoreT3);
            txtScore.setText(String.valueOf(vl_recebido));
            score = vl_recebido;

        } else {
            System.out.println("Não achou!");
        }

        if (background != 0) {
            ConstraintLayout layout3 = findViewById(R.id.layout3);
            layout3.setBackgroundColor(background);

        }
        else {
            System.out.println("Não achou o background!");
        }
    }

    public void voltarTP(View view) {
        in = new Intent(Tela3.this, MainActivity.class);
        in.putExtra("vl_extra", score);
        startActivity(in);
    }

    public void voltarT2(View view) {
        in = new Intent(Tela3.this, Tela2.class);
        in.putExtra("vl_extra", score);
        startActivity(in);
    }

    public int getColor() {
        ConstraintLayout mainLayout = findViewById(R.id.layout3);
        if (mainLayout.getBackground() instanceof ColorDrawable) {
            ColorDrawable viewColor = (ColorDrawable) mainLayout.getBackground();
            return viewColor.getColor();
        } else {
            // Retorna uma cor padrão caso o fundo não seja um ColorDrawable
            return Color.TRANSPARENT;
        }
    }

    public void changeColorBlueTP(View view) {
        ConstraintLayout mainLayout = findViewById(R.id.layout3);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        int blueColor = ContextCompat.getColor(this, R.color.blue);
        int whiteColor = ContextCompat.getColor(this, R.color.white);
        int currentColor = getColor();

        if (currentColor == blueColor) {
            // Se a cor atual é azul, muda para preto
            mainLayout.setBackgroundColor(whiteColor);
            editor.putInt("background", whiteColor); // backgroundColor é o valor da cor que você deseja salvar
            editor.apply();
        } else {
            // Caso contrário, muda para azul
            mainLayout.setBackgroundColor(blueColor);
            editor.putInt("background", blueColor); // backgroundColor é o valor da cor que você deseja salvar
            editor.apply();
        }
    }

    public void changeColorRedTP(View view) {
        ConstraintLayout mainLayout = findViewById(R.id.layout3);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        int redColor = ContextCompat.getColor(this, R.color.red);
        int whiteColor = ContextCompat.getColor(this, R.color.white);
        int currentColor = getColor();

        if (currentColor == redColor) {
            // Se a cor atual é azul, muda para preto
            mainLayout.setBackgroundColor(whiteColor);
            editor.putInt("background", whiteColor); // backgroundColor é o valor da cor que você deseja salvar
            editor.apply();
        } else {
            // Caso contrário, muda para azul
            mainLayout.setBackgroundColor(redColor);
            editor.putInt("background", redColor); // backgroundColor é o valor da cor que você deseja salvar
            editor.apply();
        }
    }

    public void incrementarTP(View view) {
        TextView txtScore = findViewById(R.id.txtScoreT3);
        score++;
        txtScore.setText(String.valueOf(score));
    }

    public void decrementarTP(View view) {
        TextView txtScore = findViewById(R.id.txtScoreT3);
        score--;
        txtScore.setText(String.valueOf(score));
    }
}