package com.example.ericklopes.drinkmixer;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MasterActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] drinks =
                new String[]{"Batida de Sonho de Valsa", "Drink dos Deuses", "Quentão"};

        ArrayAdapter<String> array =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drinks);

        setListAdapter(array);
        //setContentView(R.layout.activity_master);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent it = new Intent(this, DetailActivity.class);
        it.putExtra("drinkId", position);
        System.out.println("position:"+ position);
        startActivity(it);
    }
}
