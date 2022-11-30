package com.aakash.sss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.aakash.sss.student.AddStudents;
import com.aakash.sss.teacher.Teacher;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeAcivity extends AppCompatActivity {

    AlertDialog.Builder builder;

    //
    SliderView sliderView;
    int[] images ={R.drawable.sindhutaisapkal01,R.drawable.sindhutaisapkal02,R.drawable.sindhutaisapkal03,
            R.drawable.sindhutaisapkal04,R.drawable.sindhutaisapkal05,R.drawable.sindhutaisapkal06};
    SliderAdp sliderAdp;
    //
    ImageView btMenu;
    DrawerLayout drawerLayout;
    public static ArrayList<String> arrayList = new ArrayList<>();

    MainAdapter adapter;
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
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);
        btMenu = findViewById(R.id.bt_menu);
        recyclerView =findViewById(R.id.recycler_view);

        arrayList.clear();

        //Add menu item in array list
        arrayList.add("Home");
        arrayList.add("About");
        arrayList.add("Student");
        arrayList.add("Teacher");
        arrayList.add("TimeTable");
        arrayList.add("Gallery");
        arrayList.add("Exit");

        //Initialize adapter
        adapter = new MainAdapter(this,arrayList);
        //Set layout  manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set adapter
        recyclerView.setAdapter(adapter);

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open drawer
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        //
        sliderView = findViewById(R.id.slider_view);

        builder = new AlertDialog.Builder(this);
        sliderAdp = new SliderAdp(images);
        sliderView.setSliderAdapter(sliderAdp);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        //

        //listView = findViewById(R.id.list);


//        //Initialize And Assign Variable
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//
//        //Set Home Selected
//        bottomNavigationView.setSelectedItemId(R.id.homea);
//
//        //Perform ItemSelectedListener
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.student:
//                        startActivity(new Intent(HomeAcivity.this,StudentActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.homea:
////                        startActivity(new Intent(getApplicationContext(), HomeAcivity.class));
////                        overridePendingTransition(0,0);
//                    case R.id.teacher:
//                        startActivity(new Intent(HomeAcivity.this, Teacher.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.info:
//                        startActivity(new Intent(HomeAcivity.this, Info.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });

        //listItemShow();

//        adapterListView = new AdapterListView(this, arrayList);
//        listView.setAdapter(adapterListView);




    }

//    private void listItemShow() {
//        arrayList = new ArrayList();
//
//        arrayList.add(new ListViewPojo("Primary","1 to 8"));
//        arrayList.add(new ListViewPojo("Secondary","9 and 10"));
//        arrayList.add(new ListViewPojo("Higher Secondary","11 and 12"));
//    }

    public void about(View view) {
        Intent i = new Intent(getApplicationContext(),Info.class);
        startActivity(i);
    }




@Override
protected void onPause() {
    super.onPause();
    //Close drawer
    closerDrawer(drawerLayout);

}

}
