package com.example.lenovo.jimin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    EditText num;
float number1,number2;
boolean numaddition,numsubtraction,numdivision,nummultiplication;
    Button btn1,btn2,btn3,btnadd,btn4,btn5,btn6,btnsub,btn7,btn8,btn9,btnmul,btndot,btn0,btndiv,btnequ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);



        num=findViewById(R.id.num);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btnadd=findViewById(R.id.btnadd);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btnsub=findViewById(R.id.btnsub);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnmul=findViewById(R.id.btnmul);
        btndot=findViewById(R.id.btndot);
        btn0=findViewById(R.id.btn0);
        btndiv=findViewById(R.id.btndiv);
        btnequ=findViewById(R.id.btnequ);


  //      Intent intent = getIntent();
//        String name = intent.getExtras().getString("name");



        btn1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        num.setText(num.getText() + "1");
                                    }

                                });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(num.getText() + "2");
            }

        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(num.getText() + "3");
            }

        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(num.getText() + "4");
            }

        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(num.getText() + "5");
            }

        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(num.getText() + "6");
            }

        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(num.getText() + "7");
            }

        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(num.getText() + "8");
            }

        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(num.getText() + "9");
            }

        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(num.getText() + "0");
            }

        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == null) {
                    num.setText("");
                } else {
                    number1 = Float.parseFloat(num.getText() + "");

                    numaddition = true;
                    num.setText(null);


                }
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == null) {
                    num.setText("");
                } else {
                    number1 = Float.parseFloat(num.getText() + "");

                    numsubtraction = true;
                    num.setText(null);


                }
            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == null) {
                    num.setText("");
                } else {
                    number1 = Float.parseFloat(num.getText() + "");

                    numdivision = true;
                    num.setText(null);


                }
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == null) {
                    num.setText("");
                } else {
                    number1 = Float.parseFloat(num.getText() + "");

                    nummultiplication = true;
                    num.setText(null);


                }
            }
        });
        btnequ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number2 = Float.parseFloat(num.getText() + "");
                if(numaddition==true)
                {
                    num.setText(number1+number2+"");
                    numaddition=false;
                }
                if(numsubtraction==true)
                {
                    num.setText(number1-number2+"");
                    numsubtraction=false;
                }
                if(nummultiplication==true)
                {
                    num.setText(number1*number2+"");
                    nummultiplication=false;
                }
                if(numdivision==true)
                {
                    num.setText(number1/number2+"");
                    numdivision=false;
                }
            }
        });
    }
}

