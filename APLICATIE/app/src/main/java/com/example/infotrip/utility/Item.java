package com.example.infotrip.utility;

import android.graphics.Bitmap;

public class Item {

    Bitmap background;
    String profile_name;
    int profilePhoto;
    float rating;

    public Item() {

    }

    public Item(Bitmap background, String profile_name, int profilePhoto, float rating) {
        this.background = background;
        this.profile_name = profile_name;
        this.profilePhoto = profilePhoto;
        this.rating = rating;
    }

    public Bitmap getBackground() {
        return background;
    }

    public void setBackground(Bitmap background) {
        this.background = background;
    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }

    public int getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(int profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }


}
