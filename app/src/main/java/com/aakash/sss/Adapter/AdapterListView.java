package com.aakash.sss.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.aakash.sss.Models.ListViewPojo;
import com.aakash.sss.R;

import java.util.ArrayList;

public class AdapterListView extends BaseAdapter {
    Context context;
    ArrayList<ListViewPojo> listViewPojos;

    public AdapterListView(Context context, ArrayList<ListViewPojo> listViewPojos) {
        this.context = context;
        this.listViewPojos = listViewPojos;
    }

    @Override
    public int getCount() {
        return listViewPojos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.custom_list, viewGroup, false);
        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);

        title.setText(listViewPojos.get(position).getTitle());
        description.setText(listViewPojos.get(position).getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+listViewPojos.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
