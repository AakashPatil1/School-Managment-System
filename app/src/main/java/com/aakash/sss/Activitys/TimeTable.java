package com.aakash.sss.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.aakash.sss.Activitys.HomeAcivity;
import com.aakash.sss.Adapter.MainAdapter;
import com.aakash.sss.R;

public class TimeTable extends AppCompatActivity {

    ImageView btMenu;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;

    public static void closerDrawer(DrawerLayout drawerLayout) {
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);


        drawerLayout = findViewById(R.id.drawer_layout);
        btMenu = findViewById(R.id.bt_menu);
        recyclerView = findViewById(R.id.recycler_view);

        //Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set adapter
        recyclerView.setAdapter(new MainAdapter(this, HomeAcivity.arrayList));

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open drawer
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closerDrawer(drawerLayout);

    }
}