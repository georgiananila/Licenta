package com.example.infotrip.utility;

import android.util.Log;

public class UrlCreator {

    private  int ProximityRadius=3000;

    public String getUrlByType(double latitude, double longitude, String nearbyPlace){
        StringBuilder googleURL=new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googleURL.append("location="+latitude+","+longitude);
        googleURL.append("&radius="+ProximityRadius);
        googleURL.append("&type=" +nearbyPlace);
        googleURL.append("&sensor=true" );
        googleURL.append("&key=" +"AIzaSyBf7hKxub428BvuSnOk9OaPJdhIYHDI0yY");

        Log.d("googleMapsActivity","url = "+googleURL.toString());

        return googleURL.toString();
    }

    public String getUrlNearbyPlace(double latitude, double longitude){
        StringBuilder googleURL=new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googleURL.append("location="+latitude+","+longitude);
        googleURL.append("&radius="+ProximityRadius);
        googleURL.append("&sensor=true" );
        googleURL.append("&key=" +"AIzaSyBf7hKxub428BvuSnOk9OaPJdhIYHDI0yY");

        Log.d("googleMapsActivity","url = "+googleURL.toString());

        return googleURL.toString();
    }

    public String getUrlForPhoto(int height,int width,String photoReference){
        StringBuilder googleURL=new StringBuilder("https://maps.googleapis.com/maps/api/place/photo?");
        googleURL.append("maxwidth="+width);
        googleURL.append("&maxheight="+height);
        googleURL.append("&photoreference=" + photoReference);
        googleURL.append("&key=" +"AIzaSyBf7hKxub428BvuSnOk9OaPJdhIYHDI0yY");

        Log.d("photoGET","url = "+googleURL.toString());
        return googleURL.toString();
    }
}
