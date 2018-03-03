package com.example.mayman.qahwagy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.mayman.qahwagy.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 2000;
    private FirebaseAuth mAuth;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash_screen);

        mAuth = FirebaseAuth.getInstance();
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    public void onStart() {
        super.onStart();
//         Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null){
            startActivity(new Intent(getBaseContext(),LoginActivity.class));
        }
    }

}