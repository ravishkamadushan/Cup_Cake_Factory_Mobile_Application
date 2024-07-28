package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper3 extends SQLiteOpenHelper {
    public DBHelper3(Context context) {
        super(context, "reg.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Registerdetails(firstname TEXT, lastname TEXT, username TEXT primary key, email TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists Registerdetails ");

    }

    //checking whether data inserted or not
    public Boolean insertregisterdata(String firstname, String lastname, String username, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname",firstname);
        contentValues.put("lastname",lastname);
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = db.insert("Registerdetails",null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getdata(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Registerdetails", null);
        return cursor;
    }
}

