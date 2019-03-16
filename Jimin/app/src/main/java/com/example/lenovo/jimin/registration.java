package com.example.lenovo.jimin;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

public class registration extends AppCompatActivity {
    TextInputEditText name,address,mobile,password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        mobile=findViewById(R.id.password);
        password=findViewById(R.id.password);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();

            }
        });
    }
    public void validation()
    {
        if(name.getText().toString().equals(""))
        {
            name.setError("Please enter name");
        }
        if(address.getText().toString().equals(""))
        {
            address.setError("Please enter your address");
        }
        if(mobile.getText().toString().equals(""))
        {
            mobile.setError("Please enter your mobile number");
        }
        if(password.getText().toString().equals(""))
        {
            password.setError("Please enter your password");
        }
    }
}
