package com.example.lenovo.navigation;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class Slide extends AppCompatActivity {
Toolbar toolbars;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        toolbarInit();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void toolbarInit() {
        toolbars=findViewById(R.id.jin);
        toolbars.setTitle("Jin");
        toolbars.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbars.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                return;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent q=new Intent(Slide.this,MainActivity.class);
        q.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(q);
        finish();

    }
}
