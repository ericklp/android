package com.example.ericklopes.customlisttime;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    TextView nome;
    TextView cidade;
    TextView estado;
    TextView titulo;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nome = findViewById(R.id.nomeTime);
        cidade = findViewById(R.id.cidade);
        estado = findViewById(R.id.estado);
        titulo = findViewById(R.id.titulos);
        img = findViewById(R.id.img);

        Intent it = getIntent();
        String time = "";

        if(it!=null)
            time = it.getStringExtra("time");

        time = time.toLowerCase();

        switch (time)
        {
            case "atlético pr":
                nome.setText("Atlético Paranaense");
                cidade.setText("Curitiba");
                estado.setText("Paraná");
                titulo .setText("1");
                img.setImageResource(R.drawable.atletico);
                break;
            case "coritiba":
                nome.setText("Coritiba");
                cidade.setText("Curitiba");
                estado.setText("Paraná");
                titulo .setText("1");
                img.setImageResource(R.drawable.coritiba);
                break;
            case "grêmio":
                nome.setText("Grêmio");
                cidade.setText("Porto Alegre");
                estado.setText("Rio Grande do Sul");
                titulo .setText("2");
                img.setImageResource(R.drawable.gremio);
                break;
            default:
                break;

        }


    }
}
