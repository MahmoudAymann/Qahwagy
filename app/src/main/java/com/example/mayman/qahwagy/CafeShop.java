package com.example.mayman.qahwagy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class CafeShop extends AppCompatActivity {

    CardView cardView1, cardView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_shop);

        cardView1 = findViewById(R.id.card_view1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CafeShop.this,Starbucks.class));
            }
        });

        cardView2 = findViewById(R.id.card_view2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CafeShop.this,Costa.class));
            }
        });

    }
}
