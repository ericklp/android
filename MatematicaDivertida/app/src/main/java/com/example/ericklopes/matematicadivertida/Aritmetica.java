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

public class Aritmetica extends AppCompatActivity {

    TextView equacaoTv, progresso;
    EditText resposta;
    ProgressBar progress;
    int resultado, nota;
    int num1, num2, aux;
    boolean soma;
    AlertDialog alerta;
    String equacao_str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica);

        equacaoTv = findViewById(R.id.equacaoTv);
        progresso = findViewById(R.id.progresso);
        resposta = findViewById(R.id.resposta);
        progress = findViewById(R.id.progressBar);

        geraEquacao();
    }

    public void onClickValida(View view) {
        if(resposta.length() != 0) {
            int respostaDoUsuario = Integer.parseInt(resposta.getText().toString());

            if(respostaDoUsuario == resultado){
                nota = nota + 20;
                criaAlert("Parabéns! Respota correta.", equacao_str+" = "+String.valueOf(respostaDoUsuario));

            } else {
                criaAlert("Resposta Incorreta", "A reposta correta é "+equacao_str+" = "+String.valueOf(resultado));
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
                    geraEquacao();
                } else {
                    progress.incrementProgressBy(1);
                    geraEquacao();
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

    public void geraEquacao() {
        Random randomGenerator = new Random();
        num1 = randomGenerator.nextInt(10);
        num2 = randomGenerator.nextInt(10);
        soma = randomGenerator.nextBoolean();
        resposta.setText("");

        if(num1 < num2) {
            aux = num1;
            num1 = num2;
            num2 = aux;
        }

        if(soma) {
            resultado = num1 + num2;
            equacao_str = String.valueOf(num1)+" + "+String.valueOf(num2);
        } else {
            resultado = num1 - num2;
            equacao_str = String.valueOf(num1)+" - "+String.valueOf(num2);
        }

        equacaoTv.setText(equacao_str+" = ?");
        progresso.setText(String.valueOf(progress.getProgress())+" de "+String.valueOf(progress.getMax()));
    }

    public void restart() {
        progress.setProgress(0);
        nota = 0;
    }
}
