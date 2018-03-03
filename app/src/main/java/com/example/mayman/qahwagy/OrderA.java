package com.example.mayman.qahwagy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class OrderA extends AppCompatActivity {
   @SuppressLint("StaticFieldLeak")
   public static Spinner spinner1, spinner2,spinner3;
    Button button;
    EditText editText;
    ArrayList<String> s1 = new ArrayList<>();
    ArrayList<String> list,list2,list3,list4,list5;

    DatabaseReference mUsersDatabaseReference;
    FirebaseUser firebaseUser;


int check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        list = new ArrayList<String>();
        list.add("small 10");
        list.add("medium 20");
        list.add("large 35");

        list2 = new ArrayList<String>();
        list2.add("small 16");
        list2.add("medium 25");
        list2.add("large 30");

        list3 = new ArrayList<String>();
        list3.add("small 16");
        list3.add("medium 26");
        list3.add("large 36");

        list4 = new ArrayList<String>();
        list4.add("small 14");
        list4.add("medium 24");
        list4.add("large 33");

        list5 = new ArrayList<String>();
        list5.add("small 11");
        list5.add("medium 22");
        list5.add("large 30");

        spinner1 = findViewById(R.id.spinner1);

        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        editText = findViewById(R.id.editText);


        Intent i = getIntent();
        check = i.getIntExtra("sr",0);

        if (check == 1)
        {
            ArrayAdapter<String> adp1 = new ArrayAdapter<String>
                    (OrderA.this, android.R.layout.simple_dropdown_item_1line,list);
            spinner1.setAdapter(adp1);
        }
        else if(check == 2){
            ArrayAdapter<String> adp1 = new ArrayAdapter<String>
                    (OrderA.this, android.R.layout.simple_dropdown_item_1line,list2);
            spinner1.setAdapter(adp1);
        }
        else if(check == 3){
            ArrayAdapter<String> adp1 = new ArrayAdapter<String>
                    (OrderA.this, android.R.layout.simple_dropdown_item_1line,list5);
            spinner1.setAdapter(adp1);
        }
        else if(check == 4){
            ArrayAdapter<String> adp1 = new ArrayAdapter<String>
                    (OrderA.this, android.R.layout.simple_dropdown_item_1line,list);
            spinner1.setAdapter(adp1);
        }
        else if(check == 5){
            ArrayAdapter<String> adp1 = new ArrayAdapter<String>
                    (OrderA.this, android.R.layout.simple_dropdown_item_1line,list2);
            spinner1.setAdapter(adp1);
        }
        else if(check == 6){
            ArrayAdapter<String> adp1 = new ArrayAdapter<String>
                    (OrderA.this, android.R.layout.simple_dropdown_item_1line,list3);
            spinner1.setAdapter(adp1);
        }
        else if(check == 7){
            ArrayAdapter<String> adp1 = new ArrayAdapter<String>
                    (OrderA.this, android.R.layout.simple_dropdown_item_1line,list4);
            spinner1.setAdapter(adp1);
        }
        else if(check == 8){
            ArrayAdapter<String> adp1 = new ArrayAdapter<String>
                    (OrderA.this, android.R.layout.simple_dropdown_item_1line,list5);
            spinner1.setAdapter(adp1);
        }

        button = findViewById(R.id.buttonbn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OrderA.this, "تم الطلب", Toast.LENGTH_SHORT).show();
                String hagm = spinner1.getSelectedItem().toString();
                String kemmeya = editText.getText().toString();
                Intent intent = new Intent(OrderA.this, Result.class);
                intent.putExtra("hagm",hagm);
                intent.putExtra("halib",spinner2.getSelectedItem().toString());
                intent.putExtra("sokkar",spinner3.getSelectedItem().toString());
                intent.putExtra("kemmeya",kemmeya);
                startActivity(intent);
            }
        });

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String currentUserId = firebaseUser.getUid();

    }
}
