package com.example.ericklopes.carinfo;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

public class MontadoraActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int montadoraId = 5; //valor default para erro
        Intent it = getIntent();

        if(it!=null)
            montadoraId = it.getIntExtra("montadoraId", 4);

        if(montadoraId == 4) {

            Toast.makeText(this, "Montadora não encontrada", Toast.LENGTH_SHORT).show();
        }

        String[] itens;

        if (montadoraId == 0 ) //FIAT
            itens = new String[]{"Uno", "Palio", "Punto"};
        else if (montadoraId == 1 ) //Chevrolet
            itens = new String[]{"Kadett", "Opala", "Cruze"};
        else if (montadoraId == 2 ) //Volkswagem
            itens = new String[]{"Gol", "Saveiro", "Parati"};
        else //Honda
            itens = new String[]{"City", "HRV", "Civic"};

        ArrayAdapter<String> array =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, itens);
        setListAdapter(array);
    }
}
