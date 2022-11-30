package com.aakash.sss.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aakash.sss.database.DBHelper;
import com.aakash.sss.StudentActivity;
import com.aakash.sss.R;
import com.google.android.material.textfield.TextInputEditText;

public class DeleteStudents extends AppCompatActivity {

    TextInputEditText id, name, std, div, phone, address,mail;
    DBHelper db;
    Button show, del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_students);

        id = (TextInputEditText) findViewById(R.id.iddel);
        name = (TextInputEditText) findViewById(R.id.namedel);
        std = (TextInputEditText) findViewById(R.id.stddel);
        div = (TextInputEditText) findViewById(R.id.divdel);
        phone = (TextInputEditText) findViewById(R.id.mobiledel);
        mail = (TextInputEditText) findViewById(R.id.maildel);
        address = (TextInputEditText) findViewById(R.id.addressdel);
        show = (Button) findViewById(R.id.btnshowdel);
        del = (Button) findViewById(R.id.btndeletedel);
        db = new DBHelper(this);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idi = id.getText().toString();
                boolean fine1=true;
                if(idi.equals("")){
                    id.setError("Enter id");
                }
                else {
                    try{
                        String ID = id.getText().toString();
                        long id = Long.parseLong(ID);
                        String namaa=db.getName(id);
                        String stdd=db.getStd(id);
                        String divv=db.getDiv(id);
                        String mobileno=db.getMobile(id);
                        String maill=db.getMail(id);
                        String addresss=db.getAddress(id);
                        name.setText(namaa);
                        std.setText(stdd);
                        div.setText(divv);
                        phone.setText(mobileno);
                        mail.setText(maill);
                        address.setText(addresss);
                    }
                    catch (Exception ex)
                    {
                        fine1=false;
                        //Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "No Records...", Toast.LENGTH_SHORT).show();
                    }
                    finally {
                        if(fine1) {
                            Toast.makeText(getApplicationContext(), "Records Show Successfully...", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });


        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean fine3 = true;
                try {
                    String ID = id.getText().toString();
                    Integer id = Integer.parseInt(ID);
                    db.deleteData(id);
                }
                catch (Exception ex){
                    fine3=false;
                    Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                }
                finally {
                    if(fine3){
                        Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    public void arrowback(View view) {
        Intent i = new Intent(this, StudentActivity.class);
        startActivity(i);
    }
}