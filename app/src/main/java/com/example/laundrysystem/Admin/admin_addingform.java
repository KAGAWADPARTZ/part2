package com.example.laundrysystem.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laundrysystem.R;
import com.example.laundrysystem.User.signup_user;
import com.example.laundrysystem.User.user;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class        admin_addingform extends AppCompatActivity {

    EditText username,email,password,contact_number,shop_name,location;
    Button btn_Add;

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_addingform_screen);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        contact_number =(EditText) findViewById(R.id.contact_number);
        shop_name = (EditText) findViewById(R.id.Shops_Name);
        location = (EditText) findViewById(R.id.location);
        btn_Add = findViewById(R.id.Add);

        btn_Add.setOnClickListener(view -> {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("LaundryOwner");

            String  Username = username.getText().toString(),
                    Email = email.getText().toString(),
                    Password = password.getText().toString(),
                    Contact_Number = contact_number.getText().toString(),
                    Shop_name = shop_name.getText().toString(),
                    Location = location.getText().toString();

            HelperClass helper = new HelperClass(Username,Email,Password,Shop_name,Location,Contact_Number);

            reference.child(Shop_name).setValue(helper);

            Toast.makeText(admin_addingform.this, "Your Have Sign Up Successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(admin_addingform.this, admin_homescreen.class);
            startActivity(intent);
        });



    }
}
