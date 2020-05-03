package com.example.infotrip.activitati;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infotrip.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;
import java.util.List;

public class DetaliiLocatiiAccomodationActivity extends AppCompatActivity {

    String mTitle;
    List<HashMap<String, String >> mInterogrationDetails = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalii_locatii_accomodation);
        mTitle = getIntent().getStringExtra("title");
        mInterogrationDetails = (List<HashMap<String, String>>) getIntent().getSerializableExtra("Array");

        Log.d("Title", mTitle);

        for(int i = 0; i < mInterogrationDetails.size(); i++){
            Log.d("Lista", mInterogrationDetails.get(i).toString());
        }

        populateListByTitle();
    }

    private void populateListByTitle(){
        final int listSize = mInterogrationDetails.size();
        for(int i = 0; i < listSize; i++){
            HashMap<String, String> currentLocation = mInterogrationDetails.get(i);
            Log.e("Compare1", mTitle);
            String nameOfLocation = currentLocation.get("place_name") + " : " + currentLocation.get("vicinity");
            Log.e("Compare2", nameOfLocation);

            Log.e("BOOLEAN = ", String.valueOf(0 == mTitle.compareTo(nameOfLocation) ));
            if(0 == mTitle.compareTo(nameOfLocation) ){
                Log.d("place_name",currentLocation.get("place_name"));
                Log.d("vicinity",currentLocation.get("vicinity"));
                Log.d("latitude",currentLocation.get("latitude"));
                Log.d("longitude",currentLocation.get("longitude"));
                Log.d("referance",currentLocation.get("referance"));
                Log.d("types", currentLocation.get("types"));
                Log.d("icon", currentLocation.get("icon"));
                Log.d("user_ratings_total", String.valueOf(currentLocation.get("user_ratings_total")));
                Log.d("rating", String.valueOf(currentLocation.get("rating")));
                Log.d("isOpen", String.valueOf(currentLocation.get("isOpen")));
            }
        }
    }
}
