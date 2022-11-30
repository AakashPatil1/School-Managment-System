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
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.aakash.sss.teacher.Teacher;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Info extends AppCompatActivity {

    AlertDialog.Builder builder;
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
        setContentView(R.layout.activity_info);

        drawerLayout = findViewById(R.id.drawer_layout);
        btMenu = findViewById(R.id.bt_menu);
        recyclerView = findViewById(R.id.recycler_view);

        //Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set adapter
        recyclerView.setAdapter(new MainAdapter(this,HomeAcivity.arrayList));

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open drawer
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

//        //Initialize And Assign Variable
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//
//        //Set Home Selected
//        bottomNavigationView.setSelectedItemId(R.id.info);
//
//        //Perform ItemSelectedListener
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.student:
//                        startActivity(new Intent(Info.this, StudentActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.teacher:
//                        startActivity(new Intent(Info.this, Teacher.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.homea:
//                        startActivity(new Intent(Info.this, HomeAcivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.info:
//                        //Toast.makeText(getApplicationContext(), "Coming Soon" , Toast.LENGTH_SHORT).show();
////                        startActivity(new Intent(getApplicationContext(), Info.class));
////                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });
    }

    public void Address(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("https://www.google.com/maps/place/Sindhutai+Sapkal+Orphanage/@18.5203195,73.9759189,17z/data=!3m1!4b1!4m5!3m4!1s0x3bc2c25e6b1fad3d:0x6ca194a7073a583d!8m2!3d18.5203195!4d73.9781077");
        intent.setData(data);
        startActivity(Intent.createChooser(intent,"Launch Maps"));
    }

    public void email(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:?subject=" + "sss@gmail.com");
        intent.setData(data);
        startActivity(Intent.createChooser(intent,"Send Mail"));
    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + "09881337914"));
        startActivity(intent);
    }

    public void facbook(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/profile.php?id=432854353437101&ref=content_filter"));
        startActivity(i);
    }

    public void website(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sindhutaisapkal.org/"));
        startActivity(i);
    }

    public void instagram(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/dr.sindhutai_sapkal.maai/?igshid=12zx2tx5ws2xw"));
        startActivity(i);
    }

//    public void setting(View view) {
//
//        //Uncomment the below code to Set the message and title from the strings.xml file
//        builder.setMessage("AAKASH") .setTitle("Patil");
//
//        //Setting message manually and performing action on button click
//        builder.setMessage("Do you want to Logout?")
//                .setCancelable(false)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        Intent i = new Intent(Info.this, login.class);
//                        startActivity(i);
//                        finish();
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //  Action for 'NO' Button
//                        dialog.cancel();
//                    }
//                });
//        //Creating dialog box
//        AlertDialog alert = builder.create();
//        //Setting the title manually
//        alert.setTitle("Logout");
//        alert.show();
//        Intent i = new Intent(Info.this, login.class);
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