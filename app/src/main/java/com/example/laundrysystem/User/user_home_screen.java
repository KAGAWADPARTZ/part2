package com.example.laundrysystem.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laundrysystem.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class user_home_screen extends AppCompatActivity {


//    Retrieve Data From Firebase
    CircleImageView laundry_img;
    TextView  laundryName, services, price, location;
    public ImageButton btn_laundry;
    public ImageButton btn_status;
    public ImageButton btn_history;
    public ImageButton btn_profile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home_screen);

        btn_laundry = (ImageButton) findViewById(R.id.btn_laundry);
        btn_status = (ImageButton)  findViewById(R.id.btn_status);
        btn_history = (ImageButton) findViewById(R.id.btn_history);
        btn_profile = (ImageButton) findViewById(R.id.btn_profile);


//        Getting RecyclerView from xml file

        btn_laundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(user_home_screen.this, user_home_screen.class);
            startActivity(intent);
            }
        });

        btn_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_home_screen.this, user_status.class);
                startActivity(intent);
            }
        });

        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_home_screen.this, user_history.class);
                startActivity(intent);
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                
                Intent intent = new Intent(user_home_screen.this, user_profile.class);
                startActivity(intent);
            }
        });

    }
//    public static class myViewHolder extends RecyclerView.ViewHolder{
//
//    }
}
