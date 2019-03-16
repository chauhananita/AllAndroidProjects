package com.example.lenovo.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            String[] food={"Burgur","Pizza","Colddrink"};
            listview=findViewById(R.id.list_item);
            ListAdapter listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,food);
            listview.setAdapter(listAdapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String foodsvalue=String.valueOf(parent.getItemAtPosition(position));
                    Toast.makeText(MainActivity.this,foodsvalue,Toast.LENGTH_LONG).show();
                }
            });

    }
}
