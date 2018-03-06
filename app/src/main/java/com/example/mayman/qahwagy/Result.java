package com.example.mayman.qahwagy;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Result extends AppCompatActivity {

    TextView textViewhagm, textViewhalib, textViewsokkar, textViewkemmeya, textViewTotal, tvTime;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);


        textViewhagm = findViewById(R.id.texthagm);
        textViewhagm.setText(getIntent().getStringExtra("hagm"));

        textViewhalib = findViewById(R.id.texthalib);
        textViewhalib.setText(getIntent().getStringExtra("halib"));

        textViewsokkar = findViewById(R.id.textsokkar);
        textViewsokkar.setText(getIntent().getStringExtra("sokkar"));

        textViewkemmeya = findViewById(R.id.textkemmeya);
        textViewkemmeya.setText(getIntent().getStringExtra("kemmeya"));

        String res = getIntent().getStringExtra("hagm");
        String kem = getIntent().getStringExtra("kemmeya");

        textViewTotal = findViewById(R.id.textTotal);
        String number = res.replaceAll("[^0-9]", "");
        int num1 = Integer.valueOf(number) * Integer.valueOf(kem);


        textViewTotal.setText(String.valueOf(num1));

        tvTime = findViewById(R.id.textTime);
reverseTimer(generateInteger(),tvTime);
    }

    private int generateInteger(){
        Random r = new Random();
        return r.nextInt(10000 - 600)+600;
    }

    public void reverseTimer(int Seconds, final TextView tv) {

        countDownTimer = new CountDownTimer(Seconds * 1000 + 1000, 500) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);

                int hours = seconds / (60 * 60);
                int tempMint = (seconds - (hours * 60 * 60));
                int minutes = tempMint / 60;
                seconds = tempMint - (minutes * 60);

                tv.setText("TIME : " + String.format("%02d", hours)
                        + ":" + String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                tv.setText("Completed");
            }
        }.start();
    }

}
