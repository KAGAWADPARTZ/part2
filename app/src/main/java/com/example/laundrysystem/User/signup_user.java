package com.example.laundrysystem.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laundrysystem.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup_user extends AppCompatActivity {

//    public Button btn_sign_up;
    EditText name,email,password,contact_number;
    Button btn_sign_up;
    FirebaseDatabase database;
    DatabaseReference reference;

    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_signup);


        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        contact_number = findViewById(R.id.contact_number);
        btn_sign_up = (Button) findViewById(R.id.btn_sign_up);
        imageButton =  (ImageButton) findViewById(R.id.imageButton);

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String Name = name.getText().toString(),
                        Email = email.getText().toString(),
                        Password = password.getText().toString(),
                        Contact = contact_number.getText().toString();

                HelperClass helperClass = new HelperClass(Name,Email,Password,Contact);
                reference.child(Name).setValue(helperClass);

                Toast.makeText(signup_user.this, "Your Have Sign Up Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(signup_user.this, user.class);
                startActivity(intent);
            }
        });
//        Button Back
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup_user.this, user.class);
                startActivity(intent);
            }
        });
    }
}
