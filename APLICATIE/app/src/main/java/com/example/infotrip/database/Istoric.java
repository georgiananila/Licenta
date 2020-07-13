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
        onDelete = CASCADE),tableName = "Istoric")
public class Istoric {

    @PrimaryKey(autoGenerate = true)
    private int id_Istoric;

    @ColumnInfo(name = "IdClient")
    private int clientId;

    @ColumnInfo(name = "Denumire Locatie")
    private String denumireLocatie;

    @ColumnInfo(name="Rating")
    private  float rating;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB,name = "Poza locatie")
    private byte[] image;

    @Ignore
    public Istoric() {
    }

    public Istoric(int id_Istoric, int clientId, String denumireLocatie, float rating, byte[] image) {
        this.id_Istoric = id_Istoric;
        this.clientId = clientId;
        this.denumireLocatie = denumireLocatie;
        this.rating = rating;
        this.image = image;
    }


    public int getId_Istoric() {
        return id_Istoric;
    }

    public void setId_Istoric(int id_Istoric) {
        this.id_Istoric = id_Istoric;
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





