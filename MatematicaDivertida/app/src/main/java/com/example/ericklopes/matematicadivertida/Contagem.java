package com.example.ericklopes.matematicadivertida;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Contagem extends AppCompatActivity {

    ImageView imagem;
    Button opc1, opc2, opc3, respostaBt;
    int respostaSelecionada;
    int respostaCerta;

    TextView progresso;
    ProgressBar progress;
    ArrayList<Integer> historicoJogadas;

    int nota;
    AlertDialog alerta;

    Integer[] respostas = {
            6,
            6,
            9,
            6,
            8,
            7,
            11,
            5,
            12,
            8
    };

    Integer[] imageId = {
            R.drawable.imagem_01,
            R.drawable.imagem_02,
            R.drawable.imagem_03,
            R.drawable.imagem_04,
            R.drawable.imagem_05,
            R.drawable.imagem_06,
            R.drawable.imagem_07,
            R.drawable.imagem_08,
            R.drawable.imagem_09,
            R.drawable.imagem_10
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contagem);

        imagem = findViewById(R.id.imagemSelecionada);
        opc1 = findViewById(R.id.opc1);
        opc2 = findViewById(R.id.opc2);
        opc3 = findViewById(R.id.opc3);
        respostaBt = findViewById(R.id.responderBt);
        progress = findViewById(R.id.progressBar);
        progresso = findViewById(R.id.progressoControlador);

        historicoJogadas = new ArrayList<Integer>();
        geraNumeros();

        zeraCores();
    }

    public void onClickOpc1(View view) {
        opc1.setBackgroundResource(R.color.colorPrimary);
        opc2.setBackgroundResource(R.color.colorAccent);
        opc3.setBackgroundResource(R.color.colorAccent);
        respostaSelecionada = Integer.parseInt(opc1.getText().toString());
    }

    public void onClickOpc2(View view) {
        opc1.setBackgroundResource(R.color.colorAccent);
        opc2.setBackgroundResource(R.color.colorPrimary);
        opc3.setBackgroundResource(R.color.colorAccent);
        respostaSelecionada = Integer.parseInt(opc2.getText().toString());
    }

    public void onClickOpc3(View view) {
        opc1.setBackgroundResource(R.color.colorAccent);
        opc2.setBackgroundResource(R.color.colorAccent);
        opc3.setBackgroundResource(R.color.colorPrimary);
        respostaSelecionada = Integer.parseInt(opc3.getText().toString());
    }

    public void onClickValida(View view) {
        if(respostaSelecionada != 0) {

            if(respostaSelecionada == respostaCerta){
                nota = nota + 20;
                criaAlert("Parabéns! Resposta correta.", "Reposta: " + respostaCerta);

            } else {
                criaAlert("Resposta Incorreta", "A reposta correta é: " + respostaCerta);
            }

        } else {
            Toast.makeText(this, "Digite uma resposta!", Toast.LENGTH_SHORT).show();
        }
        zeraCores();
    }

    private void criaAlert(String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("Ok, vamos para a próxima", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                if (progress.getProgress() == progress.getMax()-1) {
                    criaAlertFinal("Fim de jogo!", "Sua nota é: " + String.valueOf(nota));

                } else {
                    progress.incrementProgressBy(1);
                    geraNumeros();
                    respostaSelecionada=0;
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
                restart();
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
        int num1, num2, imgAleatoria;

        Random randomGenerator = new Random();
        num1 = randomGenerator.nextInt(10);
        num2 = randomGenerator.nextInt(10);
        imgAleatoria = randomGenerator.nextInt(10);

        for(int i=0; i< historicoJogadas.size(); i++)
        {
            if(historicoJogadas.get(i)==imgAleatoria)
            {
                imgAleatoria = randomGenerator.nextInt(10);
            }
        }

        respostaCerta = respostas[imgAleatoria];
        imagem.setImageResource(imageId[imgAleatoria]);
        historicoJogadas.add(imgAleatoria);

        boolean isErrado = true;

        while(isErrado){
            if(num1==num2 || num1==respostaCerta || num2==respostaCerta || num1==0 || num2==0){
                num1 = randomGenerator.nextInt(10);
                num2 = randomGenerator.nextInt(10);
            } else
            {
                isErrado=false;
            }
        }

        int[] sorted_arr = {num1, num2, respostaCerta};
        Arrays.sort(sorted_arr);

        opc1.setText(String.valueOf(sorted_arr[2]));
        opc2.setText(String.valueOf(sorted_arr[1]));
        opc3.setText(String.valueOf(sorted_arr[0]));

        progresso.setText(String.valueOf(progress.getProgress())+" de "+String.valueOf(progress.getMax()));
    }

    public void restart() {
        progress.setProgress(0);
        nota = 0;
        zeraCores();
        geraNumeros();
    }
    public void zeraCores() {
        opc1.setBackgroundResource(R.color.colorAccent);
        opc2.setBackgroundResource(R.color.colorAccent);
        opc3.setBackgroundResource(R.color.colorAccent);
    }
}
