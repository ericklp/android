package com.example.ericklopes.tempcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view){
        RadioButton toCelsius = (RadioButton) findViewById(R.id.radioCelcius);
        RadioButton toFar = (RadioButton) findViewById(R.id.radioFahrenheit);

        TextView input  = (TextView) findViewById(R.id.input);
        TextView out    = (TextView) findViewById(R.id.tvOut);

        if(input.length()==0)
            Toast.makeText(this, "Forneça uma temperatura!", Toast.LENGTH_SHORT).show();

        float inputTemp = Float.parseFloat(input.getText().toString());

        if(toCelsius.isChecked())
            out.setText("A temperatura convertida é de: "+String.valueOf(F2C(inputTemp)));
        else
            out.setText("A temperatura convertida é de: "+String.valueOf(C2F(inputTemp)));
    }

    public float F2C(float fahrenheit) {
        return ((fahrenheit-32)*5/9);
    }
    public float C2F(float celcius) {
        return ((celcius*9/5)+32);
    }
}
