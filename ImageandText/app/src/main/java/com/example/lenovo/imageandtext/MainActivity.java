package com.example.lenovo.imageandtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] bts={"Jeon Jungkook","Kim Taehyung ","Park Jimin","Jung Hoseok","Kim Namjoon","Min Yoongi","Kim Seokjin","Bts"};

    //for bts images
    Integer[] imgid={R.drawable.jeon,R.drawable.kim,R.drawable.park,R.drawable.jung,R.drawable.namjoon,R.drawable.suga,R.drawable.jin,R.drawable.bts};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        CustomListView customListView=new CustomListView(this,bts,imgid);
        listView.setAdapter(customListView);

    }
}
