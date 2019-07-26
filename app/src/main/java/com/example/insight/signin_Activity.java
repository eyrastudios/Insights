package com.example.insight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class signin_Activity extends AppCompatActivity {
    private TextView signupPage;
    private EditText getEmail,getpassword;
    private Button loginBT;
    private FirebaseAuth mAuth;
            DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        getEmail = findViewById(R.id.editTextEmailid);
        getpassword = findViewById(R.id.editTextPasswordid);
        loginBT = findViewById(R.id.loginButtonid);
        mAuth = FirebaseAuth.getInstance();

        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtusername = getEmail.getText().toString();
                String txtpassword = getpassword.getText().toString();

                if(TextUtils.isEmpty(txtpassword) || (TextUtils.isEmpty(txtpassword))){
                    Toast.makeText(signin_Activity.this, "You can't Login with this username or Password", Toast.LENGTH_SHORT).show();
                }else {
                    mAuth.signInWithEmailAndPassword(txtusername,txtpassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Intent intent = new Intent(signin_Activity.this, homeActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    }else {
                                        Toast.makeText(signin_Activity.this, "Authentication Failed!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });


        // Going to SignUP Activity
        signupPage = findViewById(R.id.signup_pageid);
        signupPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signin_Activity.this,registerActivity.class);
                startActivity(intent);
            }
        });
    }
}
