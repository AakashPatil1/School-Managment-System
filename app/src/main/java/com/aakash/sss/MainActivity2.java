package com.aakash.sss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.aakash.sss.teacher.Teacher;

public class MainActivity2 extends AppCompatActivity {

    GridView GridView;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    ImageView btMenu;

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
        setContentView(R.layout.activity_main2);

        btMenu = findViewById(R.id.bt_menu);
        drawerLayout = findViewById(R.id.drawer_layout);
        recyclerView = findViewById(R.id.recycler_view);

        //Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set adapter
        recyclerView.setAdapter(new MainAdapter(MainActivity2.this,HomeAcivity.arrayList));

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open drawer
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        GridView = (GridView) findViewById(R.id.gridview);
        GridView.setAdapter(new ImageAdapter(this));
    }


    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closerDrawer(drawerLayout);

    }
}