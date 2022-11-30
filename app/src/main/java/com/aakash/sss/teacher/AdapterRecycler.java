package com.aakash.sss.teacher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aakash.sss.R;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyHolder> {
    Context context;
    ArrayList<Teachers> arrayList;

    public AdapterRecycler(Context context, ArrayList<Teachers> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public AdapterRecycler.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.custom_recycler_grid,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler.MyHolder holder,int position) {

        holder.name.setText(arrayList.get(position).getName());
        holder.namepost.setText(arrayList.get(position).getNamepost());
        holder.image.setImageResource(arrayList.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+arrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView namepost;
        ImageView image;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            namepost = itemView.findViewById(R.id.namepost);
            image = itemView.findViewById(R.id.image);
        }
    }
}
