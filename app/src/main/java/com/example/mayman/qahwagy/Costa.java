package com.example.mayman.qahwagy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import java.util.ArrayList;

public class Costa extends AppCompatActivity {

CardView cardView,cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7;
    int check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costa);

        cardView = findViewById(R.id.card_viewCosta);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Costa.this,OrderA.class);
                intent.putExtra("sr",1);
                startActivity(intent);
            }
        });


        cardView1 = findViewById(R.id.card_viewCosta1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Costa.this,OrderA.class);
                intent.putExtra("sr",2);
                startActivity(intent);

            }
        });
        cardView2 = findViewById(R.id.card_viewCosta2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent(Costa.this,OrderA.class);
                intent.putExtra("sr",3);
                startActivity(intent);

            }
        });
        cardView3 = findViewById(R.id.card_viewCosta3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent(Costa.this,OrderA.class);
                intent.putExtra("sr",4);
                startActivity(intent);

            }
        });
        cardView4 = findViewById(R.id.card_viewCosta4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Costa.this,OrderA.class);
                intent.putExtra("sr",5);
                startActivity(intent);

            }
        });
        cardView5 = findViewById(R.id.card_viewCosta5);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent(Costa.this,OrderA.class);
                intent.putExtra("sr",6);
                startActivity(intent);
            }
        });

    }
}
