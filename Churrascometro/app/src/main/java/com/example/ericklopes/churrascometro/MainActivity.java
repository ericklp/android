package com.example.ericklopes.churrascometro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    SeekBar sbMen, sbWomen, sbKids;
    TextView outputSausage, outputMeat, tvMen, tvWomen, tvKids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbMen   = (SeekBar) findViewById(R.id.seekBarMen);
        sbWomen = (SeekBar) findViewById(R.id.seekBarWomen);
        sbKids  = (SeekBar) findViewById(R.id.seekBarKids);

        outputSausage   = (TextView) findViewById(R.id.outputSausage);
        outputMeat      = (TextView) findViewById(R.id.outputMeat);

        tvMen       = (TextView) findViewById(R.id.tvMen);
        tvWomen     = (TextView) findViewById(R.id.tvWomen);
        tvKids      = (TextView) findViewById(R.id.tvKids);

        calculate(sbMen.getProgress(), sbWomen.getProgress(), sbKids.getProgress());

        sbMen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvMen.setText(String.valueOf(progress));
                calculate(progress, sbWomen.getProgress(), sbKids.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        sbWomen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvWomen.setText(String.valueOf(progress));
                calculate(sbMen.getProgress(), progress, sbKids.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        sbKids.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvKids.setText(String.valueOf(progress));
                calculate(sbMen.getProgress(), sbWomen.getProgress(), progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculate(int progressMen, int progressWomen, int progressKids) {
        double meat, sausage;

        sausage = (progressMen*0.25+progressWomen*0.2+progressKids*0.1);
        meat    = (progressMen*0.5+progressWomen*0.3+progressKids*0.2);

        outputSausage.setText(String.format("%.2f ",sausage)+"Kg");
        outputMeat.setText(String.format("%.2f ",meat)+"Kg");
    }

    public void calculate(View view) {
        double meat, sausage;

        sausage = (sbMen.getProgress()*0.25+sbWomen.getProgress()*0.2+sbKids.getProgress()*0.1);
        meat    = (sbMen.getProgress()*0.5+sbWomen.getProgress()*0.3+sbKids.getProgress()*0.2);

        outputSausage.setText(String.format("%.2f ",sausage)+"Kg");
        outputMeat.setText(String.format("%.2f ",meat)+"Kg");
    }


}
