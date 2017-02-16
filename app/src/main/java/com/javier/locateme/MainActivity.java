package com.javier.locateme;

import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity  {

    LocationManager lm;
   MapsActivity mapsActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lm = (LocationManager) getSystemService(LOCATION_SERVICE);

//        Criteria crit =  new Criteria();

        boolean gpsIsOn = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (!gpsIsOn){
            Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(i);
        }

        Intent mapsin = new Intent(this, MapsActivity.class);
        startActivity(mapsin);

    }
}
