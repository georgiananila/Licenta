package com.example.infotrip.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "ReviewAplicatie")
public class ReviewAplicatie {

    @PrimaryKey(autoGenerate = true)
    private int idReview;

   @ColumnInfo(name = "Rating")
    private String rating;

    @ColumnInfo(name = "Sugestii")
    private String sugestii;

    @Ignore
    public ReviewAplicatie() {
    }

    public ReviewAplicatie(int idReview, String rating, String sugestii) {
        this.idReview = idReview;
        this.rating = rating;
        this.sugestii = sugestii;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSugestii() {
        return sugestii;
    }

    public void setSugestii(String sugestii) {
        this.sugestii = sugestii;
    }
}
