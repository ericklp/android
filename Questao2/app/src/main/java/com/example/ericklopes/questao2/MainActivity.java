package com.example.ericklopes.questao2;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] nomes = {"Albert Einstein", "Nikola Tesla", "Alan Turing"};
        String[] partido = {"Partido dos Físicos", "Partido Energético", "Partido da Computação"};
        ArrayAdapter<String> array =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);
        setListAdapter(array);
        //setContentView(R.layout.activity_main);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //Pega o item da posicao
        Object obj = this.getListAdapter().getItem(position);
        String item = obj.toString();

        Toast.makeText(this, "Selecionado:" + item, Toast.LENGTH_SHORT).show();

        Intent it = new Intent(MainActivity.this, DetailActivity.class);
        it.putExtra("cand", (String)item);
        startActivity(it);
    }
}
