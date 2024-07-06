package com.example.laundrysystem.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.laundrysystem.R;
import com.example.laundrysystem.User.user;
import com.example.laundrysystem.User.user_home_screen;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class admin extends AppCompatActivity {

    public Button btn_user;
    public Button btn_admin;

    EditText loginUsername, loginPassword;
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        btn_user = (Button)findViewById(R.id.btn_user);
        btn_admin = (Button) findViewById(R.id.btn_admin);
        btn_login = (Button)findViewById(R.id.btn_login);

        loginUsername = findViewById(R.id.username);
        loginPassword = findViewById(R.id.password);

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this, user.class);
                startActivity(intent);
            }
        });


            btn_admin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(admin.this, admin.class);
                    startActivity(intent);
                }
            });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Validate username and password
                if (!validateUsername() || !validatePassword())
                {

                }
                   else
                   {
                    // Check if Admin exists
                        checkAdmin();
                        Intent intent = new Intent(admin.this, admin_addingform.class);
                        startActivity(intent);
                    }
            }
        });
    }

    private Boolean validateUsername(){
        String val = loginUsername.getText().toString();
        if(val.isEmpty()){
            loginUsername.setError("Username cannot be empty");
            return  false;
        }else{
            loginUsername.setError(null);
            return  true;
        }
    }
    private Boolean validatePassword(){
        String val = loginPassword.getText().toString();
        if(val.isEmpty()){
            loginPassword.setError("Password cannot be empty");
            return  false;
        }else{
            loginPassword.setError(null);
            return  true;
        }
    }

    private void checkAdmin(){
        String adminUsername = loginUsername.getText().toString().trim();
        String adminPassword = loginPassword.getText().toString().trim();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Admin");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(adminUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    loginUsername.setError(null);
                    String passwordFromDb = snapshot.child(adminUsername).child("password").getValue(String.class);

                    if(!Objects.equals(passwordFromDb, adminUsername))
                    {
                        loginUsername.setError(null);

                    }
                    else
                    {
                        loginPassword.setError("Invalid Credentials!");
                        loginPassword.requestFocus();
                    }
                }
                else
                {
                    loginUsername.setError("User Does Not Exist!");
                    loginUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}