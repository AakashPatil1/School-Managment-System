package com.aakash.sss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aakash.sss.database.DBHelper;
import com.google.android.material.textfield.TextInputEditText;

public class Signup extends AppCompatActivity {

    TextInputEditText fullname,username,email,phone,password,repassword;
    Button signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullname = (TextInputEditText) findViewById(R.id.signupfullname);
        username = (TextInputEditText) findViewById(R.id.signupusename);
        email = (TextInputEditText) findViewById(R.id.signupemail);
        phone = (TextInputEditText) findViewById(R.id.signupphone);
        password = (TextInputEditText) findViewById(R.id.signuppassword);
        repassword = (TextInputEditText) findViewById(R.id.signuprepassword);
        signup = (Button) findViewById(R.id.btnnextsignup) ;

        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = fullname.getText().toString();
                String user = username.getText().toString();
                String emai = email.getText().toString();
                String phon = phone.getText().toString();
                String passwor = password.getText().toString();
                String repasswor = repassword.getText().toString();


                //condition for check EditText
                if (user.equals("") || name.equals("") || emai.equals("") || phon.equals("") || passwor.equals("")){
                    Toast.makeText(Signup.this, "Please Enter All the Fill...", Toast.LENGTH_SHORT).show();
                }
                else{
                    //condition for check password
                    if(passwor.equals(repasswor)){
                        //checkuser
                        Boolean checkuser = DB.checkusername(user);
                        //user not exists then insert
                        if (checkuser==false){
                            Boolean insert = DB.insertData(name,user,emai,phon,passwor);
                            //data in database then show toast message
                            if (insert == true){
                                Toast.makeText(Signup.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Signup.this, HomeAcivity.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(Signup.this, "Registered Failed?", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Signup.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(Signup.this, "Password Not Matching!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });




    }

    public void signin(View view) {
        Intent intent = new Intent(getApplicationContext(),login.class);
        startActivity(intent);
    }
}