package com.example.ericklopes.questao2prova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] nome = {"Albert Einstein ", "Nikola Tesla", "Alan Turing"};
    String[] partido = {"Partido dos Físicos", "Partido Energético", "Partido da Computação"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListCell adapter = new ListCell(MainActivity.this, time, imageId);
        list=findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(MainActivity.this , "Clicou na "+time[position], Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(MainActivity.this, DetailActivity.class);
                    //Object obj = MainActivity.this.getListAdapter().getItem(position);
                    String item = (String)parent.getItemAtPosition(position);
                    it.putExtra("time", item);
                    startActivity(it);

                }
            }
        );
    }
}
