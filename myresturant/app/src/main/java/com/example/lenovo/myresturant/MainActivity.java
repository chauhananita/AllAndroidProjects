package com.example.lenovo.myresturant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(5*1000);
                    Intent intent = new Intent(MainActivity.this,myresturant1.class);
                    startActivity(intent);

                } catch (Exception e) {
                }
            }
        };
        thread.start();

    }
}
