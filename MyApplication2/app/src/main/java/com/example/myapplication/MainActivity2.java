package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        CardView Categories = (CardView)findViewById(R.id.categoriesCV);
        CardView AddCakes = (CardView)findViewById(R.id.addcakeCV);
        CardView Orders = (CardView)findViewById(R.id.ordersCV);
        CardView RegUser = (CardView)findViewById(R.id.deliveryCV);

        //open window related to categories
        Categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categories();
            }
        });

        //open window related to adding
        AddCakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNew();
            }
        });

        RegUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,reglist.class));
            }
        });

        //open window related to orders
        Orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,userlist.class));
            }
        });

        Button Logout = (Button)findViewById(R.id.logoutBTN);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               logout();

            }
        });

    }

    //Create the methods
    public void categories(){
        Intent intent = new Intent(this,MainActivity5.class);
        startActivity(intent);
    }
    public void addNew(){
        Intent intent = new Intent(this,AddNewOne.class);
        startActivity(intent);
    }

    public void logout(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}