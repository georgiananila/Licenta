package com.example.infotrip.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface InfoTripDao {

    @Insert
    Long insertClient(Clienti client);

    @Insert
    Long insertFav(Favorite favorite);

    @Insert
    Long insertPoze(PozeClienti poza);

    @Insert
    Long insertIstoric(Istoric istoric);

    @Insert
    Long insertReviewAplicatie(ReviewAplicatie reviewAplicatie);

    @Insert
    Long insertReviewLocatie(ReviewLocatie locatie);

    @Query("SELECT* FROM Clienti where `Email`==:email")
    Clienti getClient(String email);

    @Query("SELECT* FROM Clienti")
    List<Clienti> getAllClienti();

    @Query("SELECT* FROM Favorite where `IdClient`==:idClient")
    List<Favorite> getFav(int  idClient);

    @Query("SELECT* FROM Istoric where `IdClient`==:idClient")
    List<Istoric> getIstoric(int  idClient);


    @Query("SELECT* FROM PozeClienti where `IdClient`==:idClient")
    List<PozeClienti> getPoze(int idClient);

}
