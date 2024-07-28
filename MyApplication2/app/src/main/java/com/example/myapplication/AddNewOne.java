package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class AddNewOne extends AppCompatActivity {

    ScrollView scrollView;
    EditText input;
    ImageView enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_one);

        scrollView = findViewById(R.id.scrollview);
        input  = findViewById(R.id.input);
        enter = findViewById(R.id.add);

        // open window related to the admin menu
        Button Add = (Button)findViewById(R.id.backBTN);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back2();

            }
        });

        //Function related to the adding new category
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                if (text == null || text.length() == 0){
                    Toast.makeText(AddNewOne.this, "Enter an Item", Toast.LENGTH_SHORT).show();
                }
                else {
                 addItem(text);
                 input.setText("");
                    Toast.makeText(AddNewOne.this, "Added " + text, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //Create the methods
    public void back2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void addItem(String item){

    }
}