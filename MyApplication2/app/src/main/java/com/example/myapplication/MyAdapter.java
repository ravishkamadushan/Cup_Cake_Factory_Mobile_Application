package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList fName_id, lName_id, address_id, email_id, number_id;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener){
        listener = clickListener;
    }


    public MyAdapter(Context context, ArrayList fName_id, ArrayList lName_id, ArrayList address_id, ArrayList email_id, ArrayList number_id) {
        this.context = context;
        this.fName_id = fName_id;
        this.lName_id = lName_id;
        this.address_id = address_id;
        this.email_id = email_id;
        this.number_id = number_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_order_list,parent,false);
        return new MyViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.fName_id.setText(String.valueOf(fName_id.get(position)));
        holder.lName_id.setText(String.valueOf(lName_id.get(position)));
        holder.address_id.setText(String.valueOf(address_id.get(position)));
        holder.email_id.setText(String.valueOf(email_id.get(position)));
        holder.number_id.setText(String.valueOf(number_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return fName_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fName_id, lName_id,address_id,email_id,number_id;
        private ImageView imageView;



        public MyViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);

            fName_id=itemView.findViewById(R.id.textfname);
            lName_id=itemView.findViewById(R.id.textlname);
            address_id=itemView.findViewById(R.id.textaddress);
            email_id=itemView.findViewById(R.id.textemail);
            number_id=itemView.findViewById(R.id.textnumber);
            imageView = itemView.findViewById(R.id.delete_id);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());

                }
            });

        }
    }
}
