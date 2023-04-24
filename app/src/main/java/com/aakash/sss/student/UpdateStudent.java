package com.aakash.sss.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aakash.sss.database.DBHelper;
import com.aakash.sss.Activitys.StudentActivity;
import com.aakash.sss.R;
import com.google.android.material.textfield.TextInputEditText;

public class UpdateStudent extends AppCompatActivity {

    ShowStudents ss;
    TextInputEditText id,name,std,div,phone,address,mail;
    DBHelper db;
    Button show,up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        id = (TextInputEditText) findViewById(R.id.idup);
        name = (TextInputEditText) findViewById(R.id.nameup);
        std = (TextInputEditText) findViewById(R.id.stdup);
        div = (TextInputEditText) findViewById(R.id.divup);
        phone = (TextInputEditText) findViewById(R.id.mobileup);
        mail = (TextInputEditText) findViewById(R.id.addmailup);
        address = (TextInputEditText) findViewById(R.id.addressup);
        show = (Button) findViewById(R.id.btnshowup);
        up = (Button) findViewById(R.id.btnupdateup) ;
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


        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendmail();
                sendMessage();


                boolean fine2 = true;
                try {
                    String nam = name.getText().toString();
                    String st = std.getText().toString();
                    String di = div.getText().toString();
                    String phon = phone.getText().toString();
                    String mai = mail.getText().toString();
                    String addres = address.getText().toString();
                    //db.SaveData(first,last);
                    String ID = id.getText().toString();
                    long id = Long.parseLong(ID);
                    db.UpdateDetail(id,nam, st, di, phon,mai,addres);
                }
                catch (Exception ex){
                    fine2=false;
                    Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                }
                finally {
                    if(fine2){
                        Toast.makeText(getApplicationContext(), "Update", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
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
                //"Email:-" + mail.getText().toString() + "\n" +
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
            smsManager.sendTextMessage(phon,null,"Hello, " + nam + " your Information is updated check your email" + ".",null,null);
            Toast.makeText(getApplicationContext(), "SMS sent successfully!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Please Enter All the Fill...", Toast.LENGTH_SHORT).show();
        }
    }

    public void arrowback(View view) {
        Intent i = new Intent(this, StudentActivity.class);
        startActivity(i);
    }


}