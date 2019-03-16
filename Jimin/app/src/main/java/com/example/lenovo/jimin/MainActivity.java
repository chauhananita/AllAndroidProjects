package com.example.lenovo.jimin;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity   {


    TextInputEditText email,password;
    Button login,noacc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        noacc=findViewById(R.id.noacc);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                validation();

            }
        });

        noacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(MainActivity.this,registration.class);

                startActivity(a);
            }
        });


    }
    public void validation () {
        if(email.getText().toString().equals("")) {
            email.setError("Please enter your email Id");

        } else if (password.getText().toString().equals("")) {
            password.setError("Please enter your password");
        } else {
            if(email.getText().toString().equals("anita") && password.getText().toString().equals("taehyung")) {
                final String useremail = email.getText().toString();
                Intent j = new Intent(MainActivity.this, welcome.class);
                j.putExtra("name", useremail);
                finish();
                startActivity(j);
            }
        }


//        else
//        {
//            Intent i=new Intent(MainActivity.this,welcome.class);
//
//            startActivity(i);
//
//        }
    }


}
