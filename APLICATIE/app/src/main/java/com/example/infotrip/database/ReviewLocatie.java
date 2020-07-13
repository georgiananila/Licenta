package com.example.infotrip.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "ReviewLocatie")
public class ReviewLocatie {


    @PrimaryKey(autoGenerate = true)
    private int idReview;

    @ColumnInfo(name = "Sugestii")
    private String sugestii;

    @ColumnInfo(name = "rating")
    private String rating;

    @Ignore
    public ReviewLocatie() {
    }

    public ReviewLocatie(int idReview, String sugestii, String rating) {
        this.idReview = idReview;
        this.sugestii = sugestii;
        this.rating = rating;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public String getSugestii() {
        return sugestii;
    }

    public void setSugestii(String sugestii) {
        this.sugestii = sugestii;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
