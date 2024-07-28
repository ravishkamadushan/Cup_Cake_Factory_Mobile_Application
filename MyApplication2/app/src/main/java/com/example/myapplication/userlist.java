package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class userlist extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> fName,lName, address, email, number;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        DB = new DBHelper(this);
        fName = new ArrayList<>();
        lName = new ArrayList<>();
        address = new ArrayList<>();
        email = new ArrayList<>();
        number = new ArrayList<>();
        recyclerView =findViewById(R.id.viewdata1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

        //remove order details
        adapter = new MyAdapter(this,fName,lName,address,email,number);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                fName.remove(position);
                lName.remove(position);
                address.remove(position);
                email.remove(position);
                number.remove(position);
                adapter.notifyItemRemoved(position);

            }
        });


    }
    //Display data
    private void displaydata(){
        Cursor cursor = DB.getdata();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No any Orders", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()){
                fName.add(cursor.getString(0));
                lName.add(cursor.getString(1));
                address.add(cursor.getString(2));
                email.add(cursor.getString(3));
                number.add(cursor.getString(4));

            }
        }
    }
}