package com.example.ericklopes.matematicadivertida;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MaiorNumero extends AppCompatActivity {

    TextView numeros, progresso;
    EditText resposta;
    ProgressBar progress;
    int resultado, nota;
    AlertDialog alerta;
    String num_str, aux;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maior_numero);

        numeros = findViewById(R.id.numeros);
        progresso = findViewById(R.id.progressoMaiorNumero);
        resposta = findViewById(R.id.respostaMaiorNumero);
        progress = findViewById(R.id.progressBar2);
        geraNumeros();
    }

    public void onClickValida(View view) {
        if(resposta.length() != 0) {
            int respostaDoUsuario = Integer.parseInt(resposta.getText().toString());

            if(respostaDoUsuario == resultado){
                nota = nota + 20;
                criaAlert("Parabéns! Resposta correta.", num_str+" = "+String.valueOf(respostaDoUsuario));

            } else {
                criaAlert("Resposta Incorreta", "A reposta correta é "+num_str+" = "+String.valueOf(resultado));
            }

        } else {
            Toast.makeText(this, "Digite uma resposta!", Toast.LENGTH_SHORT).show();
        }

    }

    private void criaAlert(String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("Ok, vamos para a próxima", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                if (progress.getProgress() == progress.getMax()-1) {
                    criaAlertFinal("Fim de jogo!", "Sua nota é: " + String.valueOf(nota));
                    restart();
                    geraNumeros();
                } else {
                    progress.incrementProgressBy(1);
                    geraNumeros();
                }
            }
        });
        alerta = builder.create();
        alerta.show();
    }

    private void criaAlertFinal(String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("Jogar novamente", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });

        builder.setNegativeButton("Sair do jogo", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });

        alerta = builder.create();
        alerta.show();
    }

    public void geraNumeros() {
        int num1, num2, num3;
        int maior, meio, menor;

        Random randomGenerator = new Random();
        num1 = randomGenerator.nextInt(10);
        num2 = randomGenerator.nextInt(10);
        num3 = randomGenerator.nextInt(10);
        num_str = String.valueOf(num1) + " - " + String.valueOf(num2) + " - " + String.valueOf(num3);
        resposta.setText("");

        if (num1 >= num2 && num1 >= num3) {
            maior = num1;
            if (num2 > num3) {
                meio = num2;
                menor = num3;
            } else {
                meio = num3;
                menor = num2;
            }
        } else {
            if (num2 >= num1 && num2 >= num3) {
                maior = num2;
                if (num1 > num3) {
                    meio = num1;
                    menor = num3;
                } else {
                    meio = num3;
                    menor = num1;
                }
            } else {
                if (num3 >= num1 && num3 >= num2) {
                    maior = num3;
                    if (num1 > num2) {
                        meio = num1;
                        menor = num2;
                    } else {
                        meio = num2;
                        menor = num1;
                    }
                }
            }
        }

        aux = String.valueOf(maior) + String.valueOf(meio) + String.valueOf(menor);
        resultado = Integer.parseInt(aux);

        numeros.setText(num_str);
        progresso.setText(String.valueOf(progress.getProgress())+" de "+String.valueOf(progress.getMax()));
    }


    public void restart() {
        progress.setProgress(0);
        nota = 0;
    }
}
