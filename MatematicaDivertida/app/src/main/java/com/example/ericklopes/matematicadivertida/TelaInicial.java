package com.example.ericklopes.matematicadivertida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void onClickContagem(View view) {
        startActivity(new Intent(this, Contagem.class));
    }

    public void onClickAritmetica(View view) {
        startActivity(new Intent(this, Aritmetica.class));
    }

    public void onClickMaiorNumero(View view) {
        startActivity(new Intent(this, MaiorNumero.class));
    }
}
