package com.hellnear.myapps.fleshfoodbbs.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.hellnear.myapps.fleshfoodbbs.R;

/**
 * Created by Shared on 2018/01/13.
 */

public class StoreInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private View mInfoWindowView;

    public StoreInfoWindowAdapter(Activity activity) {
        mInfoWindowView = activity.getLayoutInflater().inflate(R.layout.marker_window, null);
    }
    @Override
    public View getInfoWindow(Marker marker) {
        ((TextView) mInfoWindowView.findViewById(R.id.marker_infowindow_title))
                .setText(marker.getTitle());
        ((TextView) mInfoWindowView.findViewById(R.id.marker_infowindow_snippet))
                .setText(marker.getSnippet());

        return mInfoWindowView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
