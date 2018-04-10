package com.example.ericklopes.carinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView modeloTv;
    EditText preco;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        modeloTv = findViewById(R.id.modelo);
        preco = findViewById(R.id.preco);
        img = findViewById(R.id.imageView);

        String modelo = "";
        Intent it = getIntent();
        if(it!=null)
            modelo = it.getStringExtra("modelo");

        modelo = modelo.toLowerCase();

        switch (modelo)
        {
            case "civic":
                modeloTv.setText("Honda Civic");
                preco.setText("R$100.000,00");
                img.setImageResource(R.drawable.civic);
                break;
            case "hrv":
                modeloTv.setText("Honda HRV");
                preco.setText("R$50.000,00");
                //img.setImageDrawable(R.drawable.civic);
                break;
            case "city":
                modeloTv.setText("Honda City");
                preco.setText("R$25.000,00");
                //img.setImageDrawable(R.drawable.civic);
                break;

        }
    }
}
