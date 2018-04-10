package com.example.ericklopes.carinfo;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] itens = new String[]{"Fiat", "Chevrolet", "Volkswagem", "Honda"};

        /*Veiculo city    = new Veiculo("City", "city.jpeg", 300000);
        Veiculo civic   = new Veiculo("Civic", "civic.jpeg", 500000);
        Veiculo hrv     = new Veiculo("HRV", "hrv.jpeg", 600000);

        Montadora fiat = new Montadora("Honda", );*/
        ArrayAdapter<String> array =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
        setListAdapter(array);
        //setContentView(R.layout.activity_main);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent it = new Intent(this, Main2Activity.class);
        it.putExtra("montadoraId", position);
        startActivity(it);

        //Pega o item da posicao
        /*
        Object obj = this.getListAdapter().getItem(position);
        String item = obj.toString();

        Toast.makeText(this, "Selecionado:" + item, Toast.LENGTH_SHORT).show();*/
    }
}