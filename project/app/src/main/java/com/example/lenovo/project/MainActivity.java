
package com.example.lenovo.project;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText edtname,edtmail;
    Button btnadd,btnclear,btnretrive;
    public static final String demoPref="data";
    public static final String Name="nameid";
    public static final String Email="emailid";
  //  public static final String kAnita = "anita";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();//initlization
        actionPerform();

        sharedPreferences = getSharedPreferences(demoPref,Context.MODE_PRIVATE);

      if (sharedPreferences.contains(Name)) {

            edtname.setText(sharedPreferences.getString(Name,""));
        } if (sharedPreferences.contains(Email)) {
            edtmail.setText(sharedPreferences.getString(Email,""));
        }

    }

//    void updateAnita(String value) {
  //      SharedPreferences.Editor editor = sharedPreferences.edit();
    //    editor.putString(kAnita, value);
      //  editor.commit();
        //btnclear.callOnClick();
        //Toast.makeText(getApplicationContext(),"Updated value "  + value, Toast.LENGTH_LONG).show();
    //}

    private void actionPerform() {
        //data add
       btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = edtname.getText().toString();
              //  updateAnita(name);

               String m=edtmail.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Name,n);
                editor.putString(Email,m);
                editor.commit();
            }
        });

        //data clear
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtname.setText("");
                edtmail.setText("");
            }
        });


        //retrive data
        btnretrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String äValue = sharedPreferences.getString(kAnita, "Not found");
               // Toast.makeText(getApplicationContext(),"Fetched value "  + äValue, Toast.LENGTH_LONG).show();

             //  sharedPreferences=getSharedPreferences(demoPref,Context.MODE_PRIVATE);
                if (sharedPreferences.contains(Name))
                {
                    edtname.setText(sharedPreferences.getString(Name,""));
                }
                if (sharedPreferences.contains(Email))
                {
                    edtmail.setText(sharedPreferences.getString(Email,""));
                }
            }
        });
    }

    //intilization of android id's
    private void init() {

        edtname=findViewById(R.id.edt_name);

        edtmail=findViewById(R.id.edt_email);

        btnadd=findViewById(R.id.btn_Add);

        btnclear=findViewById(R.id.btn_Clear);

        btnretrive=findViewById(R.id.btn_Retrive);
    }
}
