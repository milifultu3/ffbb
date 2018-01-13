package com.hellnear.myapps.fleshfoodbbs.views;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hellnear.myapps.fleshfoodbbs.R;

/**
 * Created by Shared on 2018/01/13.
 */

public class MainView {
    private Activity mActivity;
    private int mViewId;
    private MapFragment mMapFragment;
    private GoogleMap mMap;

    private static final LatLng TOKYO = new LatLng(35.681382, 139.766084);
    public MainView(AppCompatActivity activity, int viewId) {
        this.mActivity = activity;
        this.mViewId = viewId;
    }

    public static MainView newInstance(AppCompatActivity activity, int viewId) {
        MainView mainView = new MainView(activity, viewId);
        mainView.initialization();
        return mainView;
    }

    private void initialization() {
        mActivity.setContentView(mViewId);
    }

    public void setContentView() {
        mMapFragment = (MapFragment) mActivity.getFragmentManager().findFragmentById(R.id.mapFragment);
        mMapFragment.getMapAsync((OnMapReadyCallback) mActivity);
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(TOKYO).title("Marker in Tokyo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(TOKYO));

        CameraUpdate cUpdate = CameraUpdateFactory.newLatLngZoom(TOKYO, 15);
        mMap.moveCamera(cUpdate);
    }
}
