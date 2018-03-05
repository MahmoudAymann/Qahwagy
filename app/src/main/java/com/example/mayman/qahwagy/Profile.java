package com.example.mayman.qahwagy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayman.qahwagy.adapter.DataAdapter;
import com.example.mayman.qahwagy.service.UBloodWalpaber;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class Profile extends AppCompatActivity {

    DatabaseReference mUsersDatabaseReference, mOrderDbase;
    FirebaseUser firebaseUser;

    ImageView imageView;
    ArrayList<String> userObjsArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String currentUserId = firebaseUser.getUid();

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(Profile.this));

        imageView = findViewById(R.id.profileimg);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploodBG();
            }
        });


        mUsersDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserId);
        mUsersDatabaseReference.keepSynced(true);

        //GET & SET USER DATA
        mUsersDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.v("onDataChange", "here   " + dataSnapshot.toString());

                String nameDb = dataSnapshot.child("name").getValue().toString();
                String imageDb = dataSnapshot.child("image").getValue().toString();

                toolbar.setTitle(nameDb);

                if (imageDb.length() > 10) {
                    Picasso.with(Profile.this).load(imageDb).centerCrop().resize(100, 100).into(imageView);
                }

            }//end onDataChange

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Profile.this, getString(R.string.SOMTHING_WRONG) + databaseError, Toast.LENGTH_SHORT).show();
            }//end onCancelled

        }); //end get&set user data


        mOrderDbase = FirebaseDatabase.getInstance().getReference().child("Order").child(currentUserId);


        mOrderDbase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    for (DataSnapshot dataSnapshot2 : dataSnapshot1.getChildren()) {
                        String data = dataSnapshot2.getValue(String.class);
                        userObjsArrayList.add(data);
                    }
                }

                Toast.makeText(Profile.this, ""+userObjsArrayList.size(), Toast.LENGTH_SHORT).show();
                dataAdapter = new DataAdapter(userObjsArrayList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        recyclerView.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
    }//end

    private void UploodBG() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, Integer.valueOf(getString(R.string.selectPhotoIntent)));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Integer.valueOf(getString(R.string.selectPhotoIntent))) {
            if (resultCode == RESULT_OK) {
                Uri Imguri = data.getData();
                UploodBGHelper(Imguri);

            } else {
                Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void UploodBGHelper(Uri uri) {
        getApplicationContext().startService(new Intent(getApplicationContext(), UBloodWalpaber.class)
                .putExtra(getString(R.string.uBloodwallpaperServiceintent), uri.toString())
                .setAction("ACTION"));
    }

    @Override
    protected void onStart() {
        super.onStart();


    }//end onStart()


}
