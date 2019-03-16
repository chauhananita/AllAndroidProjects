package com.example.lenovo.newmap;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int MY_LOCATION_REQUEST = 1001;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationClient;
    boolean isSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getMyLocation();
    }

    private void getMyLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_LOCATION_REQUEST);
        } else {
            getLocation();
        }

    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        mFusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    addMarker(latLng);
                    addCircle(latLng);
                    addpolyline();
                    addpolygone();

                }
            }
        });
    }

    private void addpolyline() {
        LatLng p1 = new LatLng(18.566588, 73.911359);
        LatLng p2 = new LatLng(18.567951, 73.910683);
        LatLng p3 = new LatLng(18.568856, 73.910814);
        LatLng p4 = new LatLng(18.569025, 73.911530);

        List<LatLng> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);

        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.addAll(points).color(Color.BLUE).width(20);

        mMap.addPolyline(polylineOptions);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng point : points) {
            builder.include(point);
        }
        LatLngBounds bounds = builder.build();

        int padding = 20;
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        mMap.animateCamera(cu);

    }
    private void addpolygone() {
        LatLng p1 = new LatLng(18.566588, 73.911359);
        LatLng p2 = new LatLng(18.567951, 73.910683);
        LatLng p3 = new LatLng(18.568856, 73.910814);
        LatLng p4 = new LatLng(18.569025, 73.911530);

        List<LatLng> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);

        PolygonOptions polygonOptionsOptions = new PolygonOptions();
        polygonOptionsOptions.addAll(points).strokeColor(Color.BLUE).strokeWidth(10).fillColor(Color.BLUE);

        Polygon polygon = mMap.addPolygon(polygonOptionsOptions);

        polygon.setClickable(true);

        mMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(Polygon polygon) {

                if(isSelected) {
                    isSelected =  false;
                    polygon.setFillColor(Color.GRAY);
                }
                else {
                    isSelected=true;
                    polygon.setFillColor(Color.GREEN);
                }
            }
        });

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng point : points) {
            builder.include(point);
        }
        LatLngBounds bounds = builder.build();

        int padding = 20;
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        mMap.animateCamera(cu);

    }


    private void addCircle(LatLng latLng) {
        CircleOptions circleOptions = new CircleOptions().center(latLng).fillColor(Color.GREEN).strokeColor(Color.GREEN).radius(50);
        mMap.addCircle(circleOptions);
    }

    // Add a marker in Sydney and move the camera
    private void addMarker(LatLng latLng) {
        mMap.addMarker(new MarkerOptions().position(latLng).title("Current location"));

        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(latLng, 15);
        mMap.animateCamera(location);

        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(vimanNagar));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if ((requestCode == MY_LOCATION_REQUEST)) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                getMyLocation();
            }
        }
    }
}


