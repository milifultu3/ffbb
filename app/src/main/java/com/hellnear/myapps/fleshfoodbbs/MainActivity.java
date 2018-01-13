package com.hellnear.myapps.fleshfoodbbs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.hellnear.myapps.fleshfoodbbs.views.MainView;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MainView mMainView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainView = MainView.newInstance(this, R.layout.activity_main);
        mMainView.setContentView();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (mMainView != null) {
            mMainView.onMapReady(googleMap);
        }
    }
}
