package com.example.ericklopes.cores;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar sbRed, sbGreen, sbBlue;
    TextView selectedColor, color;
    String [] hexColor = {"00","00", "00"};
    ImageView mImageView;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbRed   = (SeekBar) findViewById(R.id.seekBarRed);
        sbGreen = (SeekBar) findViewById(R.id.seekBarGreen);
        sbBlue  = (SeekBar) findViewById(R.id.seekBarBlue);

        sbRed.setOnSeekBarChangeListener(new EventSeek((byte)0));
        sbGreen.setOnSeekBarChangeListener(new EventSeek((byte)1));
        sbBlue.setOnSeekBarChangeListener(new EventSeek((byte)2));

        mImageView = (ImageView) findViewById(R.id.imageView);

        selectedColor   = (TextView) findViewById(R.id.selectedColor);
        color           = (TextView) findViewById(R.id.color);

        setColor("#"+hexColor[0]+hexColor[1]+hexColor[2]);

    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }

    private void setColor(String str) {
        selectedColor.setText(str);
        color.setBackgroundColor(Color.parseColor(str));
    }

    public void setHexNumber(int progress, byte color) {
        String c = Integer.toHexString(progress);
        hexColor[color] = (c.length()==2 ? "" : 0) + c;
        setColor("#"+hexColor[0]+hexColor[1]+hexColor[2]);
    }

    private class EventSeek implements SeekBar.OnSeekBarChangeListener {
        private byte color;

        public EventSeek(byte color){
            this.color = color;
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            setHexNumber(progress, color);
            dispatchTakePictureIntent();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }

    };

};


