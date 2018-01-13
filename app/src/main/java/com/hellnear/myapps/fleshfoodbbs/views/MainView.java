package com.hellnear.myapps.fleshfoodbbs.views;

import android.app.Activity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hellnear.myapps.fleshfoodbbs.adapter.StoreInfoWindowAdapter;
import com.hellnear.myapps.fleshfoodbbs.R;

/**
 * Created by Shared on 2018/01/13.
 */

public class MainView {
    private Activity mActivity;
    private int mViewId;
    private MapFragment mMapFragment;
    private GoogleMap mMap;

    private static final LatLng VIEW = new LatLng(35.545979, 139.446683);
    private static final LatLng MACHIDA = new LatLng(35.543981, 139.445086);
    private static final LatLng SEIYU = new LatLng(35.543675, 139.443692);
    private static final LatLng TOKYU = new LatLng(35.542452, 139.446605);
    private static final LatLng DAIEI = new LatLng(35.540773, 139.449851);
    private static final LatLng SANWA = new LatLng(35.548901, 139.442888);

    public MainView(Activity activity, int viewId) {
        this.mActivity = activity;
        this.mViewId = viewId;
    }

    public static MainView newInstance(Activity activity, int viewId) {
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
        mMap.setInfoWindowAdapter(new StoreInfoWindowAdapter(mActivity));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                return true;
            }
        });
        mMap.addMarker(new MarkerOptions()
                .position(MACHIDA)
                .title("Machida Station"));
        mMap.addMarker(new MarkerOptions()
                .position(SEIYU)
                .title("Seiyu")
                .snippet("Vegetable_1 : 100yen\nVegetable_2 : 200 yen"));
        mMap.addMarker(new MarkerOptions()
                .position(TOKYU)
                .title("Tokyu Store")
                .snippet("Vegetable_1 : 150yen\nVegetable_2 : 150 yen"));
        mMap.addMarker(new MarkerOptions()
                .position(DAIEI)
                .title("Daiei")
                .snippet("Vegetable_1 : 120yen\nVegetable_2 : 230 yen"));
        mMap.addMarker(new MarkerOptions()
                .position(SANWA)
                .title("SANWA")
                .snippet("Vegetable_1 : 160yen\nVegetable_2 : 180 yen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MACHIDA));

        CameraUpdate cUpdate = CameraUpdateFactory.newLatLngZoom(VIEW, 15.5f);
        mMap.moveCamera(cUpdate);
    }
}
