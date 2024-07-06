package com.example.laundrysystem.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laundrysystem.R;

public class user_profile extends AppCompatActivity {


//    FireBase Connection
        TextView profileName,profileAddress,profileEmail,profilePassword,profileNumber;
//    public Button btn_back;
    public Button btn_uploadImage;
    public Button btn_editProfile;
    public Button btn_logout;

    public ImageButton imageButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);


//        btn_back = (Button) findViewById(R.id.btn_back_userprofile);
        btn_uploadImage = (Button) findViewById(R.id.btn_upload_image_userprofile);
        btn_editProfile = (Button) findViewById(R.id.btn_edit_profile_userprofile);
        btn_logout = (Button) findViewById(R.id.btn_logout_userprofile);
        imageButton =  (ImageButton) findViewById(R.id.imageButton);

//        FireBase Connection
        profileName = findViewById(R.id.profileName);
        profileAddress = findViewById(R.id.profileAddress);
        profileEmail = findViewById(R.id.profileEmail);
        profilePassword = findViewById(R.id.profilePassword);
        profileNumber = findViewById(R.id.profileNumber);

    //        Function
         showUserData();


        //        Button Back
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(user_profile.this, user_home_screen.class);
                startActivity(intent);
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_profile.this, user.class);
                startActivity(intent);
            }
        });
    }
    //      Show user Data
           public void showUserData(){

                Intent intent = getIntent();

                String nameUser = intent.getStringExtra("name");
                String emailUser = intent.getStringExtra("email");
                String passwordUser = intent.getStringExtra("password");
                String numberUser = intent.getStringExtra("contactNumber");
//                String nameUser = intent.getStringExtra("name");

               profileName.setText(nameUser);
               profileEmail.setText(emailUser);
               profilePassword.setText(passwordUser);
               profileNumber.setText(numberUser);

           }


    //end of function
}//end of class
