package com.example.subhash.myapp;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DecimalFormat;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    DecimalFormat dec = new DecimalFormat("#0");
    private GoogleMap mMap;
    double lati=23.54,logi=87.29;
    String h=String.valueOf(dec.format(lati)),i=String.valueOf(dec.format(logi));
    LocationManager locationManager;
    TextView t1,t2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        t1=(TextView)findViewById(R.id.textView);
        Bundle b=getIntent().getExtras();
        final String url=b.getString("a");

        t2=(TextView)findViewById(R.id.textView2);
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myprogres j= new myprogres(MapsActivity.this);
                j.execute();
                String url1=url+h+i;
                Intent intent=new Intent(MapsActivity.this,Main2Activity.class);
                 intent.putExtra("web",url1);
                 startActivity(intent);
            }
        });
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        t1.setText("Latitude:"+String.valueOf(dec.format(lati)));
        t2.setText("Longitude:"+String.valueOf(dec.format(logi)));
        LatLng sydney = new LatLng(lati, logi);
        mMap.addMarker(new MarkerOptions().position(sydney).title(String.valueOf(lati)+","+String.valueOf(logi))).setDraggable(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16f));
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

                LatLng postition=marker.getPosition();
                i=String.valueOf(dec.format(postition.longitude));
                h=String.valueOf(dec.format(postition.latitude));

                t1.setText("Latitude:"+String.valueOf(dec.format(postition.latitude)));
                t2.setText("Longitude:"+String.valueOf(dec.format(postition.longitude)));
            }

            @Override
            public void onMarkerDrag(Marker marker) {
                LatLng postition=marker.getPosition();
                i=String.valueOf(dec.format(postition.longitude));
                h=String.valueOf(dec.format(postition.latitude));

                t1.setText("Latitude:"+String.valueOf(dec.format(postition.latitude)));
                t2.setText("Longitude:"+String.valueOf(dec.format(postition.longitude)));
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                LatLng postition=marker.getPosition();
                i=String.valueOf(dec.format(postition.longitude));
                h=String.valueOf(dec.format(postition.latitude));

                t1.setText("Latitude:"+String.valueOf(dec.format(postition.latitude)));
                t2.setText("Longitude:"+String.valueOf(dec.format(postition.longitude)));
            }
        });
    }



}
