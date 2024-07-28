package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class reglist extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String>firstname, lastname, username, email, password;
    DBHelper3 db;
    MyAdapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglist);

        db = new DBHelper3(this);
        firstname = new ArrayList<>();
        lastname = new ArrayList<>();
        username = new ArrayList<>();
        email = new ArrayList<>();
        password = new ArrayList<>();
        recyclerView =findViewById(R.id.recycle2);
        adapter2 = new MyAdapter2(this, firstname, lastname, username, email, password);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata() {
        Cursor cursor = db.getdata();
        if (cursor.getCount()==0){
            Toast.makeText(this, "List empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()){
                firstname.add(cursor.getString(0));
                lastname.add(cursor.getString(1));
                username.add(cursor.getString(2));
                email.add(cursor.getString(3));
                password.add(cursor.getString(4));
            }
        }
    }
}