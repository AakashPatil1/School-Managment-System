package com.aakash.sss.teacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.aakash.sss.Activitys.HomeAcivity;
import com.aakash.sss.Adapter.AdapterRecycler;
import com.aakash.sss.Adapter.MainAdapter;
import com.aakash.sss.Models.Teachers;
import com.aakash.sss.R;

import java.util.ArrayList;

public class Teacher extends AppCompatActivity {

    ArrayList<Teachers> arrayList1;
    RecyclerView recyclerView1;
    AdapterRecycler adapterRecycler;

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
        setContentView(R.layout.activity_teacher);

        drawerLayout = findViewById(R.id.drawer_layout);
        btMenu = findViewById(R.id.bt_menu);
        recyclerView = findViewById(R.id.recycler_view);

        //Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set adapter
        recyclerView.setAdapter(new MainAdapter(Teacher.this,HomeAcivity.arrayList));

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open drawer
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        gridListData();


        recyclerView1 = findViewById(R.id.recyclerViewLiner);
        recyclerView1.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView1.setLayoutManager(gridLayoutManager);

        adapterRecycler = new AdapterRecycler(this,arrayList1);
        recyclerView1.setAdapter(adapterRecycler);



//        //Initialize And Assign Variable
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//
//        //Set Home Selected
//        bottomNavigationView.setSelectedItemId(R.id.teacher);
//
//        //Perform ItemSelectedListener
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.student:
//                        startActivity(new Intent(Teacher.this, StudentActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.homea:
//                        startActivity(new Intent(Teacher.this, HomeAcivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.teacher:
////                        startActivity(new Intent(getApplicationContext(),Teacher.class));
////                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.info:
//                        startActivity(new Intent(Teacher.this, Info.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });

    }

    private void gridListData() {
        arrayList1 = new ArrayList<Teachers>();

        arrayList1.add(new Teachers("Mr.Dinesh B. Mali","Principal",R.drawable.mali_dineshsir));
        arrayList1.add(new Teachers("Mr.Rakesh Pawar","Teaching Staff",R.drawable.rakesh_pawarsir));
        arrayList1.add(new Teachers("Mr. Naresh Nerpager","Teaching Staff",R.drawable.naresh_nerpagersir));
        arrayList1.add(new Teachers("Mr. Yogesh Jadhav","Teaching Staff",R.drawable.yogesh_jadhavsir));

    }
//    public void setting(View view) {
//
//        builder.setMessage("AAKASH") .setTitle("Patil");
//
//        //Setting message manually and performing action on button click
//        builder.setMessage("Do you want to Logout?")
//                .setCancelable(false)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        Intent i = new Intent(Teacher.this, login.class);
//                        startActivity(i);
//                        finish();
////                        Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
////                                Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //  Action for 'NO' Button
//                        dialog.cancel();
////                        Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
////                                Toast.LENGTH_SHORT).show();
//                    }
//                });
//        //Creating dialog box
//        AlertDialog alert = builder.create();
//        //Setting the title manually
//        alert.setTitle("Logout");
//        alert.show();
//        Intent i = new Intent(Teacher.this, login.class);
//        startActivity(i);
//        finish();
//    }

//    int counter = 0;
//    @Override
//    public void onBackPressed() {
//        counter++;
//        if(counter == 2){
//            super.onBackPressed();
//        }
//        else{
//            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
//        }
//    }
@Override
protected void onPause() {
    super.onPause();
    //Close drawer
    closerDrawer(drawerLayout);

}

}