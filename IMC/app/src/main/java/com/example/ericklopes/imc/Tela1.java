package com.example.ericklopes.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Tela1 extends AppCompatActivity {

    private EditText nome;
    private EditText altura;
    private EditText peso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

    }

    public void onClick(View view) {
        Intent it = new Intent(this, Tela2.class);

        nome = (EditText) findViewById(R.id.nome);
        altura = (EditText) findViewById(R.id.altura);
        peso =  (EditText) findViewById(R.id.peso);

        Bundle params = new Bundle();
        params.putString("nome", String.valueOf(String.valueOf(nome.getText())));
        params.putDouble("peso", Double.parseDouble(String.valueOf(peso.getText())));
        params.putDouble("altura", Double.parseDouble(String.valueOf(altura.getText())));



        it.putExtras(params);
        startActivity(it);
    }
}
