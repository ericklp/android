package com.example.ericklopes.multiview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText name = (EditText)findViewById(R.id.name);


        Intent it = new Intent(this, Tela2.class);
        Bundle params = new Bundle();
        params.putString("name", String.valueOf(name.getText()));
        it.putExtras(params);

        startActivity(it);
    }
}
