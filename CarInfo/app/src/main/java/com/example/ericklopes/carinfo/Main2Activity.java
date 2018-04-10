package com.example.ericklopes.carinfo;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main2Activity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        int montadoraId = 5; //valor default para erro
        Intent it = getIntent();

        if(it!=null)
            montadoraId = it.getIntExtra("montadoraId", 5);

        if(montadoraId == 5) {

            Toast.makeText(this, "Montadora não encontrada", Toast.LENGTH_SHORT).show();
        }

        String[] itens = new String[]{"...", "...", "..."};

        if (montadoraId == 0 ) //FIAT
            itens = new String[]{"Uno", "Palio", "Punto"};
        else if (montadoraId == 1 ) //Chevrolet
            itens = new String[]{"Kadett", "Opala", "Cruze"};
        else if (montadoraId == 2 ) //Volkswagem
            itens = new String[]{"Gol", "Saveiro", "Parati"};
        else if (montadoraId == 3)//Honda
            itens = new String[]{"City", "HRV", "Civic"};

        ArrayAdapter<String> array =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
        setListAdapter(array);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent it = new Intent(this, DetailActivity.class);
        Object obj = this.getListAdapter().getItem(position);
        String item = obj.toString();
        it.putExtra("modelo", item);
        Toast.makeText(this, "Selecionado:" + item, Toast.LENGTH_SHORT).show();
        startActivity(it);

    }
}
