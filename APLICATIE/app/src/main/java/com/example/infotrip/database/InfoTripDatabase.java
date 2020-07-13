package com.example.infotrip.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Clienti.class,Favorite.class,Istoric.class,PozeClienti.class,ReviewAplicatie.class,ReviewLocatie.class},version = 7,exportSchema = false)
public abstract class InfoTripDatabase extends RoomDatabase {

    public abstract InfoTripDao infoTripDao();

}
