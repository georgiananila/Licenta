package com.example.infotrip.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Clienti.class,
        parentColumns = "idClient",
        childColumns = "IdClient",
        onDelete = CASCADE),tableName = "Favorite")

public class Favorite {

    @PrimaryKey(autoGenerate = true)
    private int idFav;

    @ColumnInfo(name = "IdClient")
    private int clientId;

    @ColumnInfo(name = "Denumire Locatie")
    private String denumireLocatie;

    @ColumnInfo(name="Rating")
    private  float rating;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB,name = "Poza locatie")
    private byte[] image;

    @Ignore
    public Favorite() {
    }

    public Favorite(int idFav, int clientId, String denumireLocatie, float rating, byte[] image) {
        this.idFav = idFav;
        this.clientId = clientId;
        this.denumireLocatie = denumireLocatie;
        this.rating = rating;
        this.image = image;
    }

    public int getIdFav() {
        return idFav;
    }

    public void setIdFav(int idFav) {
        this.idFav = idFav;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getDenumireLocatie() {
        return denumireLocatie;
    }

    public void setDenumireLocatie(String denumireLocatie) {
        this.denumireLocatie = denumireLocatie;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
