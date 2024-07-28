package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StrawberryCakes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strawberry_cakes);
        CardView Cake1 = (CardView)findViewById(R.id.s1);
        CardView Cake2 = (CardView)findViewById(R.id.s2);
        CardView Cake3 = (CardView)findViewById(R.id.s3);
        ImageView imageView = (ImageView)findViewById(R.id.back);

        //open window related to the admin menu
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        //open window related to order form
        Cake1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1();
            }
        });

        //open window related to order form
        Cake2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1();
            }
        });

        //open window related to order form
        Cake3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1();
            }
        });
    }

    //Create the methods
    public void s1(){
        Intent intent = new Intent(this,OrderForm.class);
        startActivity(intent);
    }
    public void back(){
        Intent intent = new Intent(this,MainActivity5.class);
        startActivity(intent);
    }
}