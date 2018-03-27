package com.example.ericklopes.imc;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeoutException;

public class Tela2 extends AppCompatActivity {

    private TextView textViewImc;
    private TextView valorIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        TextView resultado = (TextView) findViewById(R.id.resultado);
        textViewImc = findViewById(R.id.imc);
        valorIMC = findViewById(R.id.valorIMC);

        Intent it = getIntent();
        if(it!=null){
            Bundle params = it.getExtras();
            if(params!=null) {
                double peso = params.getDouble("peso");
                double altura = params.getDouble("altura");
                System.out.println("peso "+peso);
                System.out.println("altura "+altura);
                double imc = (peso / (altura*altura))*10000;
                System.out.println("imc: "+imc);

                valorIMC.setText("O valor do seu IMC é de: "+String.format("%.02f", imc));

                resultado.setText("Olá "+params.getString("nome")+"!");

                if(imc<15) {
                    textViewImc.setText("Extremamente abaixo do peso!");
                    textViewImc.setTextColor(Color.BLUE);
                }
                else if(imc>=15 && imc<16) {
                    textViewImc.setText("Gravemente abaixo do peso!");
                    textViewImc.setTextColor(Color.BLUE);
                }
                else if (imc>=16 && imc<18.5) {
                    textViewImc.setText("Abaixo do peso ideal!");
                    textViewImc.setTextColor(Color.BLUE);
                }
                else if (imc>=18.5 && imc<25) {
                    textViewImc.setText("Faixa de peso ideal!");
                    textViewImc.setTextColor(Color.GREEN);
                }
                else if (imc >= 25 && imc < 30) {
                    textViewImc.setText("Sobrepeso");
                    textViewImc.setTextColor(Color.RED);
                }
                else if (imc >= 30 && imc < 35) {
                    textViewImc.setText("Obesidade Grau I");
                    textViewImc.setTextColor(Color.RED);
                }
                else if (imc >= 35 && imc < 40) {
                    textViewImc.setText("Obesidade Grau II (GRAVE)");
                    textViewImc.setTextColor(Color.RED);
                }
                else if (imc >= 40) {
                    textViewImc.setText("Obesidade Grau III (MÓRBIDA)");
                    textViewImc.setTextColor(Color.RED);
                }

            }
        }
    }
}
