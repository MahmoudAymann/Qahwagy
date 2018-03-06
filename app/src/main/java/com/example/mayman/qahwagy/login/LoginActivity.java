package com.example.mayman.qahwagy.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mayman.qahwagy.MainActivity;
import com.example.mayman.qahwagy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout textInputLayoutEmail, textInputLayoutPass;

    Button loginButton;
    FirebaseAuth mAuth;

    ProgressDialog loginProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.email_textInputLayout_login_id);
        textInputLayoutPass = (TextInputLayout) findViewById(R.id.pass_textInputLayout_login_id);

        loginProgressDialog = new ProgressDialog(LoginActivity.this);

        loginButton = (Button) findViewById(R.id.login_button_id);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textInputLayoutEmail.getEditText().getText().toString();
                String pass = textInputLayoutPass.getEditText().getText().toString();

                if (!TextUtils.isEmpty(email) || !TextUtils.isEmpty(pass)) {
                    loginProgressDialog.setTitle("loading");
                    loginProgressDialog.setMessage("please wait");
                    loginProgressDialog.setCanceledOnTouchOutside(false);
                    loginProgressDialog.show();
                    loginUser(email, pass);
                }
            }
        });
    }//end onCreate

    private void loginUser(String email, String pass) {
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            loginProgressDialog.dismiss();
                            //doin
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            loginProgressDialog.hide();
                            Toast.makeText(LoginActivity.this, "connection prob", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }//end loginUser

    public void onclickreg(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }
}//end class LoginActivity