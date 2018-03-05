package com.example.mayman.qahwagy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Starbucks extends AppCompatActivity {
    CardView cardView, cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starbuck);

        cardView = findViewById(R.id.card_viewstarbucks);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starbucks.this,OrderA.class);
                intent.putExtra("sr",1);
                intent.putExtra("t","قهوة عادية");
                startActivity(intent);
            }
        });
        cardView1 = findViewById(R.id.card_viewCosta1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starbucks.this,OrderA.class);
                intent.putExtra("sr",2);
                intent.putExtra("t","دبل شوت اسبرسو");

                startActivity(intent);
            }
        });
        cardView2 = findViewById(R.id.card_viewCosta2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starbucks.this,OrderA.class);
                intent.putExtra("sr",3);
                intent.putExtra("t","cafe1");
                startActivity(intent);
            }
        });
        cardView3 = findViewById(R.id.card_viewCosta3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starbucks.this,OrderA.class);
                intent.putExtra("sr",4);
                intent.putExtra("t","دبل شوت اسبرسو");
                startActivity(intent);
            }
        });
        cardView4 = findViewById(R.id.card_viewCosta4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starbucks.this,OrderA.class);
                intent.putExtra("sr",5);
                intent.putExtra("t","cafe2");
                startActivity(intent);
            }
        });
        cardView5 = findViewById(R.id.card_viewCosta5);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starbucks.this,OrderA.class);
                intent.putExtra("sr",6);
                intent.putExtra("t"," اسبرسو");
                startActivity(intent);
            }
        });
        cardView6 = findViewById(R.id.card_viewCosta6);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starbucks.this,OrderA.class);
                intent.putExtra("sr",7);
                intent.putExtra("t","cafe4");
                startActivity(intent);
            }
        });
        cardView7 = findViewById(R.id.card_viewCosta7);
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starbucks.this,OrderA.class);
                intent.putExtra("sr",8);
                intent.putExtra("t","cafe5");
                startActivity(intent);
            }
        });

    }
}
