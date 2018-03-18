package com.example.subhash.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Main2Activity extends AppCompatActivity {
    WebView w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main2);
        w=(WebView)findViewById(R.id.webview);
        Bundle b=getIntent().getExtras();
        String t=b.getString("web");
        w.loadUrl(t);
        myprogres j= new myprogres(Main2Activity.this);
        j.execute();

        Toast.makeText(Main2Activity.this,"Help on its way!!!!",Toast.LENGTH_SHORT).show();
    }
}
