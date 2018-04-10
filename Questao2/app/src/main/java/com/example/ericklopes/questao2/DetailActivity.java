package com.example.ericklopes.questao2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView num;
    private TextView nome;
    private TextView partido;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        num = findViewById(R.id.numero);
        nome = findViewById(R.id.nomeCand);
        partido = findViewById(R.id.partidoCand);
        img = findViewById(R.id.imageView);

        Intent it = getIntent();
        String candidato = "";

        if(it!=null)
            candidato = it.getStringExtra("cand");

        candidato = candidato.toLowerCase();

        switch (candidato)
        {
            case "albert einstein":
                num.setText("Candidato 1");
                partido.setText("Partido dos Físicos");
                nome.setText("Albert Einstein");
                img.setImageResource(R.drawable.albert);
                break;
            case "nikola tesla":
                num.setText("Candidato 2");
                partido.setText("Partido Energético");
                nome.setText("Nikola Tesla");
                img.setImageResource(R.drawable.nikola);
                break;
            case "alan turing":
                num.setText("Candidato 3");
                partido.setText("Partido da Computação");
                nome.setText("Alan Turing");
                img.setImageResource(R.drawable.alan);
                break;
        }

    }
}
