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

public class MainActivity extends AppCompatActivity {

    private Intent in;
    private int score = 0;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // Oculta os botões de navegação
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY // Modo imersivo que reaparece com gesto
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(uiOptions);

        sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        int background = sharedPreferences.getInt("background", 0);

        if (getIntent().hasExtra("vl_extra")) {
            int vl_recebido = getIntent().getIntExtra("vl_extra", 0);
            TextView txtScore = findViewById(R.id.txtScoreTP);
            txtScore.setText(String.valueOf(vl_recebido));
            score = vl_recebido;

        } else {
            System.out.println("Não achou!");
        }

        if (background != 0) {
            ConstraintLayout layout1 = findViewById(R.id.main_layout);
            layout1.setBackgroundColor(background);

        } else {
            System.out.println("Não achou o background!");
        }
    }

    public void avancarT2(View view) {
        in = new Intent(MainActivity.this, Tela2.class);
        in.putExtra("vl_extra", score);
        startActivity(in);
    }

    public int getColor() {
        ConstraintLayout mainLayout = findViewById(R.id.main_layout);
        if (mainLayout.getBackground() instanceof ColorDrawable) {
            ColorDrawable viewColor = (ColorDrawable) mainLayout.getBackground();
            return viewColor.getColor();
        } else {
            // Retorna uma cor padrão caso o fundo não seja um ColorDrawable
            return Color.TRANSPARENT;
        }
    }

    public void changeColorBlueTP(View view) {
        ConstraintLayout mainLayout = findViewById(R.id.main_layout);

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
        ConstraintLayout mainLayout = findViewById(R.id.main_layout);

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
        TextView txtScore = findViewById(R.id.txtScoreTP);
        score++;
        txtScore.setText(String.valueOf(score));
    }

    public void decrementarTP(View view) {
        TextView txtScore = findViewById(R.id.txtScoreTP);
        score--;
        txtScore.setText(String.valueOf(score));
    }

}