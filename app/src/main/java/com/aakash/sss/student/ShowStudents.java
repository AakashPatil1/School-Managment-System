package com.aakash.sss.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aakash.sss.database.DBHelper;
import com.aakash.sss.StudentActivity;
import com.aakash.sss.MyAdapter;
import com.aakash.sss.R;

import java.util.ArrayList;

public class ShowStudents extends AppCompatActivity  { // implements View.OnClickListener

    DBHelper DB;
    RecyclerView recyclerView;
    ArrayList<String> id,name,std,div,phone,mail,address;
    MyAdapter adapter;
    ProgressDialog dialog;
    EditText edtsearch;

    Button b1,b2,b3,b4,b5,b6,b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);

//        b1 = findViewById(R.id.btn_1);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                displaydata();
//            }
//        });
//        b2 = findViewById(R.id.btn_2);
//        b2.setOnClickListener(this);
//        b3 = findViewById(R.id.btn_3);
//        b3.setOnClickListener(this);
//        b4 = findViewById(R.id.btn_4);
//        b4.setOnClickListener(this);
//        b5 = findViewById(R.id.btn_5);
//        b5.setOnClickListener(this);
//        b6 = findViewById(R.id.btn_6);
//        b6.setOnClickListener(this);
//        b7 = findViewById(R.id.btn_7);
//        b7.setOnClickListener(this);





//        btn = (Button) findViewById(R.id.btnsearch);
//        edtsearch =(EditText) findViewById(R.id.edtsearch);

        DB = new DBHelper(this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        std = new ArrayList<>();
        div = new ArrayList<>();
        phone = new ArrayList<>();
        mail = new ArrayList<>();
        address = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerV);
        adapter = new MyAdapter(this,id,name,std,div,phone,mail,address);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
          //show student method
        displaydata();
    

    }
    
    
    
    
    
    
    private void displaydata() {
        Cursor cursor = DB.getdata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "No Entery Exist", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                std.add(cursor.getString(2));
                div.add(cursor.getString(3));
                phone.add(cursor.getString(4));
                mail.add(cursor.getString(5));
                address.add(cursor.getString(6));
            }
        }
    }

    private void displaydata1() {
        boolean fine1=true;

        try {
            String idi = edtsearch.getText().toString();
            if (idi.equals("")) {
                edtsearch.setError("Enter id");
            } else {
                Cursor cursor = DB.getdataa(idi);
                if (cursor.getCount()==0) {
                    Toast.makeText(this, "No Entery Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
//                    std.ensureCapacity(cursor.getCount());
//                    do {
//                        id.add(cursor.getString(0));
//                        name.add(cursor.getString(1));
//                        std.add(cursor.getString(2));
//                        div.add(cursor.getString(3));
//                        phone.add(cursor.getString(4));
//                        mail.add(cursor.getString(5));
//                        address.add(cursor.getString(6));
//                    } while (cursor.moveToNext());
                    while (cursor.moveToNext())
                    {
                        id.add(cursor.getString(0));
                        name.add(cursor.getString(1));
                        std.add(cursor.getString(2));
                        div.add(cursor.getString(3));
                        phone.add(cursor.getString(4));
                        mail.add(cursor.getString(5));
                        address.add(cursor.getString(6));
                    }
                }
            }
        }

            catch (Exception ex)
            {
                fine1=false;
                Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), "No Records...", Toast.LENGTH_SHORT).show();
            }
//            finally {
//                if(fine1) {
//                    Toast.makeText(getApplicationContext(), "Records Show Successfully...", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
//                }
//            }
    }

//    @Override
//    public void onClick(View v) {
//        boolean fine1=true;
//        Button button = (Button) v;
//
//        try {
//            String category = button.getText().toString();
//            dialog.setTitle("Fetching " + category);
//            dialog.show();
//                Cursor cursor = DB.getdataa(category);
//                if (cursor.getCount()==0) {
//                    Toast.makeText(this, "No Entery Exists", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                else {
//                    while (cursor.moveToNext())
//                    {
//                        id.add(cursor.getString(0));
//                        name.add(cursor.getString(1));
//                        std.add(cursor.getString(2));
//                        div.add(cursor.getString(3));
//                        phone.add(cursor.getString(4));
//                        mail.add(cursor.getString(5));
//                        address.add(cursor.getString(6));
//                    }
//                }
//
//        }
//
//        catch (Exception ex)
//        {
//            fine1=false;
//            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
//            //Toast.makeText(getApplicationContext(), "No Records...", Toast.LENGTH_SHORT).show();
//        }
//
//
//
//
//    }



    public void arrowback(View view) {
        Intent i = new Intent(this, StudentActivity.class);
        startActivity(i);
    }

}