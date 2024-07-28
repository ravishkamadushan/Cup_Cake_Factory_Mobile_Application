package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private Context context;
    private ArrayList firstname_id, lastname_id, username_id, email_id, password_id;

    public MyAdapter2(Context context, ArrayList firstname_id, ArrayList lastname_id, ArrayList username_id, ArrayList email_id, ArrayList password_id) {
        this.context = context;
        this.firstname_id = firstname_id;
        this.lastname_id = lastname_id;
        this.username_id = username_id;
        this.email_id = email_id;
        this.password_id = password_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.regentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.firstname_id.setText(String.valueOf(firstname_id.get(position)));
        holder.lastname_id.setText(String.valueOf(lastname_id.get(position)));
        holder.username_id.setText(String.valueOf(username_id.get(position)));
        holder.email_id.setText(String.valueOf(email_id.get(position)));
        holder.password_id.setText(String.valueOf(password_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return firstname_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstname_id,lastname_id, username_id, email_id, password_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            firstname_id = itemView.findViewById(R.id.firstname);
            lastname_id = itemView.findViewById(R.id.lastname);
            username_id = itemView.findViewById(R.id.username);
            email_id = itemView.findViewById(R.id.email);
            password_id = itemView.findViewById(R.id.password);

        }
    }
}
