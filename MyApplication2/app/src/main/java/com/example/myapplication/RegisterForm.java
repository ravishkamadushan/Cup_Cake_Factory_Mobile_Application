package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterForm extends AppCompatActivity {

    EditText firstname,lastname,username,email,password;
    Button register;
    DBHelper2 DB;
    DBHelper3 db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);

        firstname = (EditText) findViewById(R.id.nameTV2);
        lastname = (EditText) findViewById(R.id.nameTV3);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.emailTV);
        password = (EditText)findViewById(R.id.password);
        register = findViewById(R.id.redisterBTN2);
        DB = new DBHelper2(this);
        db = new DBHelper3(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting values from text fields
                String fn = firstname.getText().toString();
                String ln = lastname.getText().toString();
                String user = username.getText().toString();
                String em = email.getText().toString();
                String pass = password.getText().toString();

                Boolean checkinsertdata = db.insertregisterdata(fn,ln,user,em,pass);
                if (checkinsertdata==true)
                {
                    Toast.makeText(RegisterForm.this, "Data Saved", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RegisterForm.this, "Data not Saved", Toast.LENGTH_SHORT).show();
                }


                if (TextUtils.isEmpty(fn)|| TextUtils.isEmpty(ln)|| TextUtils.isEmpty(user)|| TextUtils.isEmpty(em)|| TextUtils.isEmpty(pass)) {
                    Toast.makeText(RegisterForm.this, "All field are Required", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pass.equals(pass)){
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert =DB.insertData(user,pass);
                            if (insert==true){
                                Toast.makeText(RegisterForm.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                register2();
                            }
                        }
                    }

                }
                }
        });

    }

    //Create the methods
    public void register2() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}