package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button Login,Register;
    ImageView Back;
    DBHelper2 DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText)findViewById(R.id.password1);
        Login = findViewById(R.id.signBTN);
        Register = findViewById(R.id.registerBTN);
        Back = findViewById(R.id.back2);

        DB = new DBHelper2(this);


        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                //validate usernames and passwords
                if (user.equals("admin")&& pass.equals("1234")){
                    Toast.makeText(MainActivity.this, "Login Granted", Toast.LENGTH_SHORT).show();
                    login();

                } else if (user.equals("user")&& pass.equals("1234")) {
                    Toast.makeText(MainActivity.this, "Login Granted", Toast.LENGTH_SHORT).show();
                    login2();

                } else if (TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainActivity.this, "All field are Required", Toast.LENGTH_SHORT).show();

                //validate usernames and passwords according to the database
                } else {
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if (checkuserpass==true){
                    Toast.makeText(MainActivity.this, "Login Granterd", Toast.LENGTH_SHORT).show();
                    login3();
                    }else {
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        //open window related to the registration form
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();

            }
        });

        //open window related to the home menu
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backhome();
            }
        });

    }

    //Create the methods
    public void login() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void login2() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
    public void login3() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void register() {
        Intent intent = new Intent(this, RegisterForm.class);
        startActivity(intent);
    }
    public void backhome() {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
}