package com.example.flightio;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.flightio.engine.camera.Camera;
import com.example.flightio.engine.camera.Param;
import com.example.flightio.engine.coordinates.Point;
import com.example.flightio.engine.interpolation.Interpolation;
import com.example.flightio.engine.save.Litchi;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Frag2Flight extends Fragment {


    MapView mMapView;
    private GoogleMap googleMap;
    private ArrayList<Point> listMarkers = new ArrayList<>();
    private Param paramBase;
    private boolean noPhotoBool = false;

    public Frag2Flight(Param base){
        paramBase = base;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        final LayoutInflater lf = getActivity().getLayoutInflater();
        final View rootView = inflater.inflate(R.layout.frag2_flight_layout, container, false);


        // GOOGLE MAP
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

                // For showing a move to my location button
                //googleMap.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                LatLng sydney = new LatLng(43.979380, 5.772274);
                //googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                googleMap.clear();

                // Adding a marker on click
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng point) {
                        //allPoints.add(point);
                        //googleMap.clear();
                        googleMap.addMarker(new MarkerOptions().position(point));

                        // Adding the marker to the list
                        Point markedPoint = new Point(point.latitude, point.longitude);
                        double alti = paramBase.getAlti();
                        markedPoint.setZ(alti);
                        listMarkers.add(markedPoint);
                    }
                });



         // SAVE BUTTON


                // Button save
                final View save = rootView.findViewById(R.id.save);

                save.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                /* DO SOMETHING UPON THE CLICK */
                                    if (paramBase.getCanExport() && (listMarkers.size() == 4)){
                                        double sizeGroundBase = paramBase.getBase()[1];
                                        ArrayList<Point> listInter = new ArrayList<>();

                                        if (noPhotoBool) {
                                            listInter = Interpolation.computeInterSquareNoStop(listMarkers.get(0), listMarkers.get(1),
                                                    listMarkers.get(2), listMarkers.get(3), sizeGroundBase);
                                        }
                                        else {
                                            listInter = Interpolation.computeInterSquare4(listMarkers.get(0), listMarkers.get(1),
                                                    listMarkers.get(2), listMarkers.get(3), sizeGroundBase);
                                        }
                                        
                                        final String text = Litchi.listPointsToString(listInter);
                                        FileOutputStream fos = null;

                                        try {
                                            fos = lf.getContext().openFileOutput("litchi_mission.csv", lf.getContext().MODE_PRIVATE);
                                            fos.write((Litchi.litchiHeader() + "\n").getBytes());

                                            for (int i = 0; i < listInter.size(); i++) {
                                                Litchi pointLitchi = new Litchi(listInter.get(i));
                                                fos.write((pointLitchi.toString() + "\n").getBytes());
                                            }
                                            // Message succesful write
                                            //Toast.makeText(lf.getContext(), "Saved to " + lf.getContext().getFilesDir() + "/" + "litchi_mission.csv",
                                            //        Toast.LENGTH_LONG).show();

                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        } finally {
                                            if (fos != null){
                                                try {
                                                    fos.close();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                    }
                            }
                        }
                );




                // Delete Markers
                final View delete = rootView.findViewById(R.id.delete_markers);

                delete.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                googleMap.clear();
                            }
                        }
                );

                // No photos
                final View photo = rootView.findViewById(R.id.photo_mode);
                photo.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (noPhotoBool) {
                            FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.photo_mode);
                            fab.setImageResource(R.drawable.photos);
                        }
                        else {
                            FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.photo_mode);
                            fab.setImageResource(R.drawable.no_photos);
                        }
                        noPhotoBool = !noPhotoBool;     // reverse the boolean

                    }
                });


                // Go to litchi
                final View link = rootView.findViewById(R.id.export);

                link.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String url = "https://flylitchi.com/hub";
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                            }
                        }
                );




            }
        });






        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

}