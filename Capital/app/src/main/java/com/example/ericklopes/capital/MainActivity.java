package com.example.ericklopes.capital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Estados> estados = new ArrayList<Estados>();
    Random r;
    int n_estado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estados.add(new Estados("Parana", "Curitiba"));
        estados.add(new Estados("Sao Paulo", "Sao Paulo"));
        estados.add(new Estados("Ceara", "Fortaleza"));
        estados.add(new Estados("Rio Grande do Sul", "Porto Alegre"));
        estados.add(new Estados("Rio de Janeiro", "Rio de Janeiro"));

        r  = new Random();
        n_estado = r.nextInt(5) + 1;

        EditText estado = (EditText) findViewById(R.id.estado);
        estado.setText(estados.get(n_estado).getEstado());
    }

    public void capital(View view) {
        EditText capital = (EditText) findViewById(R.id.capital);
        TextView resultado = (TextView) findViewById(R.id.resultado);

        String s_capital = capital.getText().toString().toLowerCase();

        if(s_capital.equals(estados.get(n_estado).getCapital().toLowerCase()))
            resultado.setText("Acertou");
        else
            resultado.setText("Errooow");
    }


}
