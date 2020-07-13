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
        onDelete = CASCADE),tableName = "PozeClienti")
public class PozeClienti {

    @PrimaryKey(autoGenerate = true)
    private  int idPoza;

    @ColumnInfo(name = "IdClient")
    private int clientId;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB,name = "Poza adaugata")
    private byte[] image;

    @Ignore
    public PozeClienti() {
    }

    public PozeClienti(int idPoza, int clientId, byte[] image) {
        this.idPoza = idPoza;
        this.clientId = clientId;
        this.image = image;
    }

    public int getIdPoza() {
        return idPoza;
    }

    public void setIdPoza(int idPoza) {
        this.idPoza = idPoza;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
