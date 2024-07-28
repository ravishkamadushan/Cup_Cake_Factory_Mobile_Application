package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class aboutus extends AppCompatActivity {

    //create objects
    private Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        // find the button by id
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.back2);

        //execute the method for opening the dial pad
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:011111222222"));
                startActivity(intent);
            }
        });

        //open window related to the menu
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

    }
    public void back() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}