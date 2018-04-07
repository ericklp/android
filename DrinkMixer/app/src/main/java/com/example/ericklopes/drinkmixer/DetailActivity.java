package com.example.ericklopes.drinkmixer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int drinkId = 3; //valor default para erro
        Intent it = getIntent();
        String[] drinks =
                new String[]{"Batida de Sonho de Valsa", "Drink dos Deuses", "Quentão"};
        String[] ingredientes =
                new String[]{   "3 bombons Sonho de Valsa \n" +
                                "1 lata de leite condensado \n" +
                                "1/2 garrafa de pinga \n" +
                                "1 latinha de Guaraná",
                            "...",
                            "..."};

        EditText drinkName  = (EditText) findViewById(R.id.drinkName);
        EditText ingBox     = (EditText) findViewById(R.id.ingEditText);

        if(it!=null)
            drinkId = it.getIntExtra("drinkId", 3);

        if(drinkId == 3) {
            drinkName.setText("");
            ingBox.setText("");
            Toast.makeText(this, "Drink não encontrado", Toast.LENGTH_SHORT).show();
        } else {
            drinkName.setText(drinks[drinkId]);
            ingBox.setText(ingredientes[drinkId]);
        }
    }
}
