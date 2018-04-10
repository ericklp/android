package com.example.ericklopes.questao1prova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    private EditText nameEt;
    private EditText nota1Et;
    private EditText nota2Et;
    private EditText freqEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcula(View view) {
        nameEt = findViewById(R.id.name);
        nota1Et = findViewById(R.id.nota1);
        nota2Et = findViewById(R.id.nota2);
        freqEt = findViewById(R.id.freq);

        String nome = nameEt.getText().toString();
        Double nota1 = Double.parseDouble(String.valueOf(nota1Et.getText()));
        Double nota2 = Double.parseDouble(String.valueOf(nota2Et.getText()));
        Integer freq = Integer.parseInt(String.valueOf(freqEt.getText()));

        boolean valid = true;
        if(nome.isEmpty()){
            Toast.makeText(MainActivity.this , "Insira um nome", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        if(nota1.isNaN()) {
            Toast.makeText(MainActivity.this, "Insira Nota 1", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if(nota2.isNaN()) {
            Toast.makeText(MainActivity.this, "Insira Nota 2", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if(freq<0 || freq>100) {
            Toast.makeText(MainActivity.this, "Frequencia não pode ser menor que 0 ou maior que 100.", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        if (valid) {
            Intent it = new Intent(this, Main2Activity.class);
            Bundle params = new Bundle();
            params.putString("nome", nome);
            params.putDouble("nota1", nota1);
            params.putDouble("nota2", nota2);
            params.putInt("freq", freq);

            it.putExtras(params);
            startActivity(it);
        }

    }
}
