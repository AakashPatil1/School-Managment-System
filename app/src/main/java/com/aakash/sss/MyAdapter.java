package com.aakash.sss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id_id, name_id, std_id,div_id, phone_id,mail_id, addres_id;


    public MyAdapter(Context context,ArrayList id_id, ArrayList name_id, ArrayList std_id, ArrayList div_id, ArrayList phone_id,ArrayList mail_id, ArrayList addres_id) {
        this.context = context;
        this.id_id = id_id;
        this.name_id = name_id;
        this.std_id = std_id;
        this.div_id = div_id;
        this.phone_id = phone_id;
        this.mail_id = mail_id;
        this.addres_id = addres_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id_id.setText(String.valueOf(id_id.get(position)));
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.std_id.setText(String.valueOf(std_id.get(position)));
        holder.div_id.setText(String.valueOf(div_id.get(position)));
        holder.phone_id.setText(String.valueOf(phone_id.get(position)));
        holder.mail_id.setText(String.valueOf(mail_id.get(position)));
        holder.addres_id.setText(String.valueOf(addres_id.get(position)));
    }
    @Override
    public int getItemCount() {
        return id_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_id,name_id,std_id, div_id , phone_id,mail_id, addres_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_id = itemView.findViewById(R.id.textid);
            name_id = itemView.findViewById(R.id.textname);
            std_id = itemView.findViewById(R.id.textstd);
            div_id = itemView.findViewById(R.id.textdivision);
            phone_id = itemView.findViewById(R.id.textMobile);
            mail_id = itemView.findViewById(R.id.textemail);
            addres_id = itemView.findViewById(R.id.textaddress);
        }
    }
}
