package com.example.infotrip.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Arrays;

@Entity(tableName = "Clienti")
public class Clienti {

    @PrimaryKey(autoGenerate = true)
    private int idClient;

    @ColumnInfo(name = "NumeClient")
    private String nume;

    @ColumnInfo(name = "PrenumeClient")
    private String prenume;

    @ColumnInfo(name = "DataNasterii")
    private String dataNastere;

    @ColumnInfo(name = "Email")
    private String email;

    @ColumnInfo(name = "Parola")
    private String parola;

    @ColumnInfo(name = "Tara")
    private String tara;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB,name = "Pozaprofil")
    private byte[] image;


    @Ignore
    public Clienti() {
    }


    public Clienti(int idClient, String nume, String prenume, String dataNastere, String email, String parola, String tara, byte[] image) {
        this.idClient = idClient;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNastere = dataNastere;
        this.email = email;
        this.parola = parola;
        this.tara = tara;
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Clienti{" +
                "idClient=" + idClient +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", dataNastere='" + dataNastere + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                ", tara='" + tara + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
