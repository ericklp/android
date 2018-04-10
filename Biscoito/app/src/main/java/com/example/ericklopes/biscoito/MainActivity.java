package com.example.ericklopes.biscoito;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.ericklopes.biscoito.R;

public class MainActivity extends AppCompatActivity {

    SeekBar seekbar;
    TextView tvSorte, tvSb;

    String[] sorte = {  "A vida trará coisas boas se tiveres paciência.",
                        "Demonstre amor e alegria em todas as oportunidades e verás\n" +
                                "que a paz nasce dentro de você.",
                        "Não compense na ira o que lhe falta na razão.",
                        "Defeitos e virtudes são apenas dois lados da mesma moeda.",
                        "A maior de todas as torres começa no solo.",
                        "Não há que ser forte. Há que ser flexível",
                        "Gente todo dia arruma os cabelos, por que não o coração?",
                        "Há três coisas que jamais voltam; a flecha lançada, a palavra\n" +
                                "dita e a oportunidade perdida.",
                        "A juventude não é uma época da vida, é um estado de espírito.",
                        "Podemos escolher o que semear, mas somos obrigados a\n" +
                                "colher o que plantamos."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbar = findViewById(R.id.seekBar);
        tvSorte = findViewById(R.id.sorte);
        tvSb    = findViewById(R.id.sbTv);
        //ImageView img = findViewById(R.id.imageView);
        //img.setImageResource(R.drawable.biscoito);

        seekbar.setProgress(0);
        seekbar.setOnSeekBarChangeListener(new EventSeek());

        setSorte(0);
    }

    public void setSorte(int index) {
        if(index<sorte.length) {
            tvSorte.setText(sorte[index]);
            tvSb.setText(String.valueOf(index+1));
        }
    }

    private class EventSeek implements SeekBar.OnSeekBarChangeListener {


        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            setSorte(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }

    };
}
