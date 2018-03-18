package com.example.subhash.myapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton b1,b2,b3,b4,b5;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final String d="https://api.thingspeak.com/update?key=3UUMFCHD36N3ZF6H&field1=";
        final String e="https://api.thingspeak.com/update?key=3UUMFCHD36N3ZF6H&field2=";
        final String f="https://api.thingspeak.com/update?key=3UUMFCHD36N3ZF6H&field3=";
        final String g="https://api.thingspeak.com/update?key=3UUMFCHD36N3ZF6H&field4=";
        final String h="https://api.thingspeak.com/update?key=3UUMFCHD36N3ZF6H&field5=";

        b1= (ImageButton)findViewById(R.id.imageButton1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity.this,MapsActivity.class);
                i1.putExtra("a",d);
                startActivity(i1);

            }
        });
        b2= (ImageButton)findViewById(R.id.imageButton5);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity.this,MapsActivity.class);
                i1.putExtra("a",e);
                startActivity(i1);

            }
        });
        b3= (ImageButton)findViewById(R.id.imageButton4);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity.this,MapsActivity.class);
                i1.putExtra("a",f);
                startActivity(i1);

            }
        });
        b4= (ImageButton)findViewById(R.id.imageButton3);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity.this,MapsActivity.class);
                i1.putExtra("a",g);
                startActivity(i1);

            }
        });
        b5= (ImageButton)findViewById(R.id.imageButton2);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity.this,MapsActivity.class);
                i1.putExtra("a",h);
                startActivity(i1);

            }
        });


    }

}
