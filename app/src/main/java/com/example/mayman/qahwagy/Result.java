package com.example.mayman.qahwagy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView textViewhagm,textViewhalib, textViewsokkar, textViewkemmeya, textViewTotal;


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
        String number  = res.replaceAll("[^0-9]", "");
        int num1 = Integer.valueOf(number) * Integer.valueOf(kem);

        textViewTotal.setText(String.valueOf(num1));

    }

}
