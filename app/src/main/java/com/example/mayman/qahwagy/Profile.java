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
    TextView textView;
    ArrayList<UserObjs> userObjsArrayList = new ArrayList<>();
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
        dataAdapter = new DataAdapter(userObjsArrayList);
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

    void setData() {

    }

    @Override
    protected void onStart() {
        super.onStart();

        mOrderDbase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for ( DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    String data = dataSnapshot1.getValue(String.class);
                    Toast.makeText(Profile.this, ""+data, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }//end onStart()

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public UserViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }//end UserViewHolder

        public void setName(String name) {
            TextView textViewName = mView.findViewById(R.id.textViewNameP);
            textViewName.setText(name);
        }//end setName

//        public void setMilk(String milk) {
//            TextView textViewMilk = mView.findViewById(R.id.textViewMilk);
//            textViewMilk.setText(milk);
//        }//end setMilk
//
//
//        public void setSuger(String Suger) {
//            TextView textViewSuger = mView.findViewById(R.id.textViewSuger);
//            textViewSuger.setText(Suger);
//        }//end setMilk
//
//
//        public void setQuant(String milk) {
//            TextView textViewQuantity = mView.findViewById(R.id.textViewQuan);
//            textViewQuantity.setText(milk);
//        }//end setMilk
//
//
//        public void setSize(String milk) {
//            TextView textViewSize = mView.findViewById(R.id.textViewSize);
//            textViewSize.setText(milk);
//        }//end setMilk

    }//end UserViewHolder


}
