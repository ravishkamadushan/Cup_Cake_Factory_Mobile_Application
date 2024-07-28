package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        CardView Birthday = (CardView)findViewById(R.id.a1);
        CardView Chocolate = (CardView)findViewById(R.id.a2);
        CardView Red = (CardView)findViewById(R.id.a3);
        CardView Lemon = (CardView)findViewById(R.id.a4);
        CardView Coffee = (CardView)findViewById(R.id.a5);
        CardView Strawberry = (CardView)findViewById(R.id.a6);

        //open window related to birthday cakes
        Birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                birthday();
            }
        });

        //open window related to chocolate cakes
        Chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chocolate();
            }
        });

        //open window related to red velvet cakes
        Red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red();
            }
        });

        //open window related to lemon cakes
        Lemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lemon();
            }
        });

        //open window related to coffee cakes
        Coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffee();
            }
        });

        //open window related to strawberry cakes
        Strawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strawberry();
            }
        });


        //open window related to admin menu
        Button Add = (Button)findViewById(R.id.backBTN);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();

            }
        });
    }

    //Create the methods
    public void birthday(){
        Intent intent = new Intent(this,BirthdayCakes.class);
        startActivity(intent);
    }
    public void chocolate(){
        Intent intent = new Intent(this,ChocolateCakes.class);
        startActivity(intent);
    }
    public void red(){
        Intent intent = new Intent(this,RedVelvetCakes.class);
        startActivity(intent);
    }
    public void lemon(){
        Intent intent = new Intent(this,LemonCakes.class);
        startActivity(intent);
    }
    public void coffee(){
        Intent intent = new Intent(this,CoffeeCakes.class);
        startActivity(intent);
    }
    public void strawberry(){
        Intent intent = new Intent(this,StrawberryCakes.class);
        startActivity(intent);
    }
    public void back() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}