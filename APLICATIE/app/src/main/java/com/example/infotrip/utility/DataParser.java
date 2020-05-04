package com.example.infotrip.utility;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataParser {

    private HashMap<String,String> getSingleNearbyPlace(JSONObject googlePlaceJSON){

        HashMap<String,String> googlePlaceMap=new HashMap<>();
        String NameOfPlace="-NA-";
        String vicinity="-NA-";
        String latitude="";
        String longitude="";
        String referance="";
        String types = "";
        String icon = "";
        int userRatingTotal = 0;
        double rating = 0;
        boolean isOpen = false;
        int photoWidth=0;
        int photoHeight=0;
        String photoReference="";

        try {

            if (!googlePlaceJSON.isNull("name")){
                NameOfPlace=googlePlaceJSON.getString("name");
            }
            if (!googlePlaceJSON.isNull("vicinity")){
                vicinity=googlePlaceJSON.getString("vicinity");
            }
            latitude=googlePlaceJSON.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude=googlePlaceJSON.getJSONObject("geometry").getJSONObject("location").getString("lng");
            referance=googlePlaceJSON.getString("reference");
            types = getJSONTypes(googlePlaceJSON.getJSONArray("types"));
            if (!googlePlaceJSON.isNull("icon")){
                icon = googlePlaceJSON.getString("icon");
            }
            if (!googlePlaceJSON.isNull("user_ratings_total")){
                userRatingTotal = googlePlaceJSON.getInt("user_ratings_total");
            }
            if (!googlePlaceJSON.isNull("rating")){
                rating = googlePlaceJSON.getDouble("rating");
            }
            if (!googlePlaceJSON.isNull("open_now")){
                isOpen = googlePlaceJSON.getJSONObject("opening_hours").getBoolean("open_now");
            }
            if (!googlePlaceJSON.isNull("photos")) {
                JSONArray array=googlePlaceJSON.getJSONArray("photos");
                JSONObject photo= (JSONObject) array.get(0);
                photoWidth=photo.getInt("width");
                photoHeight=photo.getInt("height");
                photoReference=photo.getString("photo_reference");
            }

            googlePlaceMap.put("place_name",NameOfPlace);
            googlePlaceMap.put("vicinity",vicinity);
            googlePlaceMap.put("latitude",latitude);
            googlePlaceMap.put("longitude",longitude);
            googlePlaceMap.put("reference",referance);
            googlePlaceMap.put("types", types);
            googlePlaceMap.put("icon", icon);
            googlePlaceMap.put("user_ratings_total", String.valueOf(userRatingTotal));
            googlePlaceMap.put("rating", String.valueOf(rating));
            googlePlaceMap.put("isOpen", String.valueOf(isOpen));
            googlePlaceMap.put("photo_reference",photoReference);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  googlePlaceMap;
    }

    private String getJSONTypes(JSONArray types) {
        int counter = types.length();
        String retString = "";

        for(int i = 0; i < counter; i++){
            try {
                retString += (String)types.get(i);
                retString += ",";
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return retString;
    }

    private List<HashMap<String,String>> getAllNearbyPlaces(JSONArray jsonArray){
        int counter=jsonArray.length();

        List<HashMap<String,String>> NearbyPlacesList=new ArrayList<>();

        HashMap<String,String> NearbyPlaceMap=null;

        for(int i=0;i<counter;i++){
            try {
                NearbyPlaceMap=getSingleNearbyPlace((JSONObject)jsonArray.get(i));
                NearbyPlacesList.add(NearbyPlaceMap);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return  NearbyPlacesList;
    }

    public List<HashMap<String,String>> parse(String jSONdata){
        JSONArray jsonArray=null;
        JSONObject jsonObject;

        try {
            jsonObject=new JSONObject(jSONdata);
            jsonArray=jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return getAllNearbyPlaces(jsonArray);
    }
}
