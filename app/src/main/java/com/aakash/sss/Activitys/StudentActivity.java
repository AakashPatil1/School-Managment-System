package com.aakash.sss.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.aakash.sss.Adapter.MainAdapter;
import com.aakash.sss.R;
import com.aakash.sss.student.AddStudents;
import com.aakash.sss.student.DeleteStudents;
import com.aakash.sss.student.ShowStudents;
import com.aakash.sss.student.UpdateStudent;

public class StudentActivity extends AppCompatActivity {

    CardView cdadd,cdshow,cddetele,cdupdate,cd11;
    CardView iv1,iv2,iv3;

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
        setContentView(R.layout.activity_student);

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

        builder = new AlertDialog.Builder(this);
        cdadd = findViewById(R.id.add);
        cdshow = findViewById(R.id.show);
        cddetele = findViewById(R.id.delete);
        cdupdate = findViewById(R.id.update);
        //cdcard = findViewById(R.id.icard);
//        cd11 = findViewById(R.id.std11);

//        iv1 = findViewById(R.id.iv1);
//        iv2 = findViewById(R.id.iv2);
//        iv3 = findViewById(R.id.iv3);

        cdadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), AddStudents.class);
                startActivity(i);
            }
        });
        cdshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), ShowStudents.class);
                startActivity(i);
            }
        });
        cddetele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), DeleteStudents.class);
                startActivity(i);
            }
        });
        cdupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), UpdateStudent.class);
                startActivity(i);
            }
        });
//        cd11.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });
        //Initialize And Assign Variable
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//
//        //Set Home Selected
//        bottomNavigationView.setSelectedItemId(R.id.student);
//
//        //Perform ItemSelectedListener
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.student:
////                        startActivity(new Intent(getApplicationContext(),StudentActivity.class));
////                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.homea:
//                        startActivity(new Intent(StudentActivity.this, HomeAcivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.teacher:
//                        startActivity(new Intent(StudentActivity.this, Teacher.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.info:
//                        startActivity(new Intent(StudentActivity.this, Info.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });

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
//
//                        Intent i = new Intent(StudentActivity.this, login.class);
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
//        finish();
//        Intent i = new Intent(StudentActivity.this, login.class);
//        startActivity(i);
//        finish();
//    }

//    int counter = 0;
//    @Override
//    public void onBackPressed() {
//        counter++;
//        if(counter == 2){
//            super.onBackPressed();
//
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