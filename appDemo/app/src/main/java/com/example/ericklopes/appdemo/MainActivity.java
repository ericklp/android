package com.example.ericklopes.appdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out = (TextView)findViewById(R.id.out);
        out.setText("");
    }

    public void soma(View view) {
        EditText n1 = (EditText) findViewById(R.id.n1);
        EditText n2 = (EditText) findViewById(R.id.n2);

        if (n1.length() > 0 && n2.length() > 0) {
            int i1 = Integer.parseInt(n1.getText().toString());
            int i2 = Integer.parseInt(n2.getText().toString());
            if (view.getId() == R.id.bSoma)
                out.setText(String.valueOf(i1+i2));
            else if (view.getId() == R.id.bSub)
                out.setText(String.valueOf(i1-i2));
        } else {
            Toast msg = Toast.makeText(this, "Não deixe espacos vazios", Toast.LENGTH_SHORT);
            msg.show();
        }
    }
}
