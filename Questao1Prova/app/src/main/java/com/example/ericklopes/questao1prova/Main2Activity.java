package com.example.ericklopes.questao1prova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView nomeTv;
    private  TextView mediaFinalTv;
    private  TextView condicaoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent it = getIntent();

        nomeTv = findViewById(R.id.nome);
        mediaFinalTv = findViewById(R.id.mediaFinal);
        condicaoTv = findViewById(R.id.cond);

        if (it != null) {
            Bundle params = it.getExtras();
            if (params != null) {
                String nameStr = params.getString("nome");
                nomeTv.setText(nameStr.toString());

                double nota1 = params.getDouble("nota1");
                double nota2 = params.getDouble("nota2");

                int freq = params.getInt("freq");
                double mediaFinal = (nota1 + nota2) / 2;

                mediaFinalTv.setText(String.valueOf(mediaFinal));

                if (freq < 75)
                    condicaoTv.setText("Reprovado por falta");
                else if (mediaFinal < 4)
                    condicaoTv.setText("Reprovado por nota");
                else if (mediaFinal >= 7 && freq > 75)
                    condicaoTv.setText("Aprovado");
                else if (mediaFinal <= 4 && mediaFinal <= 6.9 && freq < 75)
                    condicaoTv.setText("Final");
            }
        }
    }
}
