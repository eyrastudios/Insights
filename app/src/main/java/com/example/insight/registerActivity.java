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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class registerActivity extends AppCompatActivity {
    private TextView signinPage;
            EditText username, mobileNumber, email, password;
            Button register;
            FirebaseAuth auth;
            DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username     = findViewById(R.id.editTextNameid);
        mobileNumber = findViewById(R.id.editTextMobileid);
        email    = findViewById(R.id.editTextEmailid);
        password = findViewById(R.id.editTextPasswordid);
        register     = findViewById(R.id.signUpBtid);
        auth        = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtusername = username.getText().toString();
                String txtemail = email.getText().toString();
                String txtpassword = password.getText().toString();

                if (TextUtils.isEmpty(txtusername) || (TextUtils.isEmpty(txtemail) || (TextUtils.isEmpty(txtpassword)))){
                    Toast.makeText(registerActivity.this, "Please fill all form fields", Toast.LENGTH_SHORT).show();
                } else if(txtpassword.length() <= 7){
                    Toast.makeText(registerActivity.this, "Password must be at least eight characters", Toast.LENGTH_SHORT).show();
                }else{
                    register(txtusername,txtemail,txtpassword);
                }

            }
        });


       signinPage = findViewById(R.id.signin_pageid);
        signinPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registerActivity.this, signin_Activity.class);
                startActivity(intent);
            }
        });

    }

    private void register(final String username, String email , String password){
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            assert firebaseUser != null;
                            String userid = firebaseUser.getUid();
                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                            final HashMap<String, String>  hashMap =new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("username", username);
                            hashMap.put("imageURL", "default");

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(registerActivity.this, homeActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
                        }else {
                            Toast.makeText(registerActivity.this, "You can't use this Email", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
