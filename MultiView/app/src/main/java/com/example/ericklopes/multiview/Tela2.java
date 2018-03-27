package com.example.ericklopes.multiview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        TextView name = (TextView) findViewById(R.id.textView);

        Intent it = getIntent();
        if(it!=null){
            Bundle params = it.getExtras();
            if(params!=null) {
                name.setText("Olá "+params.getString("name")+"!");
            }
        }
    }

    public void onClick(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
