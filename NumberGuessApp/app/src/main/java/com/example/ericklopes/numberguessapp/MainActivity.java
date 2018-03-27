package com.example.ericklopes.numberguessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int tries, num;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r  = new Random();
        num = r.nextInt(100) + 1;
        System.out.println(num);
        tries = 0;
    }

    public void guess(View view) {
        EditText entrada = (EditText) findViewById(R.id.input);
        TextView hint = (TextView) findViewById(R.id.hint);


        if (entrada.length()==0){
            Toast msg = Toast.makeText(this, "Insira o número", Toast.LENGTH_SHORT);
            msg.show();
        }
        else{
            int n_entrada = Integer.parseInt(entrada.getText().toString());

            tries++;

            if(n_entrada == num)
                hint.setText("Acertou! Você usou "+tries+" tentativas.");
            if(num > n_entrada)
                hint.setText("Número sorteado é maior!");
            if(num < n_entrada)
                hint.setText("Número sorteado é menor!");
        }
    }
}
