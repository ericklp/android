package com.example.ericklopes.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.nio.DoubleBuffer;

public class MainActivity extends AppCompatActivity {

    private double currentBillTotal;
    private int currentCustomPercent;
    private EditText tip10EditText;
    private EditText tip15EditText;
    private EditText tip20EditText;
    private EditText total10EditText;
    private EditText total15EditText;
    private EditText total20EditText;
    private TextView customTipTextView;
    private EditText billEditText;
    private EditText tipCustomEditText;
    private EditText totalCustomEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tip10EditText = (EditText) findViewById(R.id.tip10EditTextField);
        tip15EditText = (EditText) findViewById(R.id.tip15EditTextField);
        tip20EditText = (EditText) findViewById(R.id.tip20EditTextField);
        total10EditText = (EditText) findViewById(R.id.total10EditTextField);
        total15EditText = (EditText) findViewById(R.id.total15EditTextField);
        total20EditText = (EditText) findViewById(R.id.total20EditTextField);
        customTipTextView = (TextView) findViewById(R.id.customTipTextView);
        tipCustomEditText = (EditText) findViewById(R.id.tipCustomEditTextField);
        billEditText = (EditText) findViewById(R.id.billEditText);
        totalCustomEditText = (EditText) findViewById(R.id.totalCustomEditTextField);
        SeekBar customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);

        currentCustomPercent = customSeekBar.getProgress();

        billEditText.addTextChangedListener(billTextWatcher);

        customSeekBar.setOnSeekBarChangeListener(customSeekBarListener);
    }

    private SeekBar.OnSeekBarChangeListener customSeekBarListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    currentCustomPercent = progress;
                    updateCustom();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };

    private TextWatcher billTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                currentBillTotal = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e){
                currentBillTotal = 0.0;
            }

            updateCustom();
            updateStandard();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void updateStandard() {
        double tenPercentTip = currentBillTotal * .10;
        double tenPercentTotal = currentBillTotal + tenPercentTip;
        double fifPercentTip = currentBillTotal * .15;
        double fifPercentTotal = currentBillTotal + fifPercentTip;
        double twentyPercentTip = currentBillTotal * .20;
        double twentyPercentTotal = currentBillTotal + twentyPercentTip;

        tip10EditText.setText(String.format("%.02f", tenPercentTip));
        total10EditText.setText(String.format("%.02f", tenPercentTotal));
        tip15EditText.setText(String.format("%.02f", fifPercentTip));
        total15EditText.setText(String.format("%.02f", fifPercentTotal));
        tip20EditText.setText(String.format("%.02f", twentyPercentTip));
        total20EditText.setText(String.format("%.02f", twentyPercentTotal));
    }

    private void updateCustom() {
        customTipTextView.setText(currentCustomPercent + "%");

        double customTipAmount = currentBillTotal * currentCustomPercent * .01;
        double customTotalAmount = currentBillTotal + customTipAmount;

        tipCustomEditText.setText(String.format("%.02f", customTipAmount));
        totalCustomEditText.setText(String.format("%.02f", customTotalAmount));
    }


}
