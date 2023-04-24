package com.aakash.sss.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aakash.sss.database.DBHelper;
import com.aakash.sss.Activitys.StudentActivity;
import com.aakash.sss.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddStudents extends AppCompatActivity {

    TextInputEditText name,std,div,phone,address,mail;
    Button ad,send;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students);

        name = (TextInputEditText) findViewById(R.id.addname);
        std = (TextInputEditText) findViewById(R.id.addstd);
        div = (TextInputEditText) findViewById(R.id.adddiv);
        phone = (TextInputEditText) findViewById(R.id.addmobile);
        mail = (TextInputEditText) findViewById(R.id.addmail);
        address = (TextInputEditText) findViewById(R.id.addaddress);
        ad = (Button) findViewById(R.id.btnaddstudent);

        db = new DBHelper(this);

        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendmail();


                //Permission
                if (ContextCompat.checkSelfPermission(AddStudents.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                    sendMessage();
                }else{
                    ActivityCompat.requestPermissions(AddStudents.this,new String[]{Manifest.permission.SEND_SMS},100);
                }


                String nam = name.getText().toString();
                String st = std.getText().toString();
                String di = div.getText().toString();
                String phon = phone.getText().toString();
                String mai = mail.getText().toString();
                String addres = address.getText().toString();

                if (nam.equals("") || st.equals("") || di.equals("") || phon.equals("") || mai.equals("") || addres.equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter All the Fill...", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkDatastudent = db.insertDatastudent(nam, st, di, phon,mai, addres);
                    if (checkDatastudent == true)
                    {
                        Toast.makeText(AddStudents.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    } else
                    {
                        Toast.makeText(AddStudents.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private void sendmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ mail.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT,"Your Information");
        intent.putExtra(Intent.EXTRA_TEXT, "Name:-" + name.getText().toString() + "\n" +
                "Standard:-" + std.getText().toString() + "\n" +
                "Division:-" + div.getText().toString() + "\n" +
                "Roll No.:-" + "Sorry not Available" + "\n" +
                "Mobile No.:-" + phone.getText().toString() + "\n" +
                "Email:-" + mail.getText().toString() + "\n" +
                "Address:-" + address.getText().toString() + "\n" +
                "\n" +
                "\n" +
                "\n" +
                "If there is any mistake in the above information, inform your class head."
        );
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Send Email"));
    }


    private void sendMessage() {

        String nam = name.getText().toString();
        String st = std.getText().toString();
        String di = div.getText().toString();
        String phon = phone.getText().toString();

        if (!phon.equals("") && !nam.equals("") && !st.equals("") && !di.equals("")){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phon,null,"Hello, " + nam + " your Admission is confirm in " + st + "std. your Division is " +di + "Other Information send your email" +".",null,null);
            Toast.makeText(getApplicationContext(), "SMS sent successfully!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Please Enter All the Fill...", Toast.LENGTH_SHORT).show();
        }
    }

    public void arrowback(View view) {
        Intent i = new Intent(this, StudentActivity.class);
        startActivity(i);
//        System.exit(1);
    }



}