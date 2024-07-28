package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(fName TEXT primary key, lName TEXT, address TEXT, email TEXT, number TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Userdetails");

    }
    //create method for inserting data
    public boolean insertuserdata(String fName, String lName, String address, String email, String number){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fName",fName);
        contentValues.put("lName",lName);
        contentValues.put("address",address);
        contentValues.put("email",email);
        contentValues.put("number",number);
        long result = DB.insert("Userdetails",null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    // create method for update data
    public boolean updateuserdata(String fName, String lName, String address, String email, String number){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("lName",lName);
        contentValues.put("address",address);
        contentValues.put("email",email);
        contentValues.put("number",number);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where fName = ?",new String[]{fName} );
        if (cursor.getCount()>0) {
            long result = DB.update("Userdetails", contentValues, "fName= ?", new String[]{fName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    // create method for delete data
    public boolean deleteuserdata(String fName){

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where fName = ?",new String[]{fName} );
        if (cursor.getCount()>0) {
            long result = DB.delete("Userdetails", "fName= ?", new String[]{fName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("select * from Userdetails", null);
        return cursor;

    }

}
