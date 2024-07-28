package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class OrderForm extends AppCompatActivity {

    EditText fName,lName,address,email,number;
    Button order,view,update,delete;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);

        fName = findViewById(R.id.nameTV2);
        lName = findViewById(R.id.nameTV3);
        address = findViewById(R.id.addressTV4);
        email = findViewById(R.id.emailTV2);
        number = findViewById(R.id.contactTV2);
        order = findViewById(R.id.orderBTN2);
        update = findViewById(R.id.updateBTN2);
        delete = findViewById(R.id.deleteBTN2);
        view = findViewById(R.id.viewBTN2);

        DB = new DBHelper(this);

        // create order button
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fNameTXT = fName.getText().toString();
                String lNameTXT = lName.getText().toString();
                String addressTXT = address.getText().toString();
                String emailTXT = email.getText().toString();
                String contactTXT =number.getText().toString();

                //validation related to the empty fields
                if (fName.getText().toString().equals("")) {
                    Toast.makeText(OrderForm.this, "Enter Your First Name", Toast.LENGTH_SHORT).show();
                }
                else if (lName.getText().toString().equals("")) {
                    Toast.makeText(OrderForm.this, "Enter Your Last Name", Toast.LENGTH_SHORT).show();
                }
                else if (address.getText().toString().equals("")) {
                    Toast.makeText(OrderForm.this, "Enter Your Address", Toast.LENGTH_SHORT).show();
                }
                else if (email.getText().toString().equals("")) {
                    Toast.makeText(OrderForm.this, "Enter Your Email", Toast.LENGTH_SHORT).show();
                }
                else if (number.getText().toString().equals("")) {
                    Toast.makeText(OrderForm.this, "Enter Your Contact number", Toast.LENGTH_SHORT).show();
                }

                Boolean checkinsertdata = DB.insertuserdata(fNameTXT,lNameTXT,addressTXT,emailTXT,contactTXT);
                if (checkinsertdata==true){
                    Toast.makeText(OrderForm.this, "Order Conformed", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(OrderForm.this, "Details cannot be inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Create update button
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fNameTXT = fName.getText().toString();
                String lNameTXT = lName.getText().toString();
                String addressTXT = address.getText().toString();
                String emailTXT = email.getText().toString();
                String contactTXT =number.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(fNameTXT,lNameTXT,addressTXT,emailTXT,contactTXT);
                if (checkupdatedata==true){
                    Toast.makeText(OrderForm.this, "Order Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(OrderForm.this, "Details cannot be Updated", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Create delete button
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fNameTXT = fName.getText().toString();

                Boolean checkdeletedata = DB.deleteuserdata(fNameTXT);
                if (checkdeletedata==true){
                    Toast.makeText(OrderForm.this, "Order canceled", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(OrderForm.this, "Order cannot be canceled", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //create view button
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getdata();
                if (res.getCount()==0){
                    Toast.makeText(OrderForm.this, "No order details to show", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("First Name : "+res.getString(0)+"\n");
                    buffer.append("Last Name : "+res.getString(1)+"\n");
                    buffer.append("Address : "+res.getString(2)+"\n");
                    buffer.append("Email : "+res.getString(3)+"\n");
                    buffer.append("Contact Number: "+res.getString(4)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(OrderForm.this);
                builder.setCancelable(true);
                builder.setTitle("Order details");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });





    }

}