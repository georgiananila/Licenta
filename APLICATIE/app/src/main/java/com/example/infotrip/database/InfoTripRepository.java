package com.example.infotrip.database;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.room.Room;

import com.example.infotrip.utility.Email;

import java.util.ArrayList;
import java.util.List;


public class InfoTripRepository {

    private static InfoTripRepository single_instance=null;
    private InfoTripDatabase infoTripDatabase;
    Context context;
    private String DB_NAME = "Licentadb"; //numele bazei de date


    public static InfoTripRepository getInstance(Context context){
        if(single_instance==null){
            single_instance=new InfoTripRepository(context);
        }
        return single_instance;
    }


    private InfoTripRepository(Context context) {
        this.context = context;
        infoTripDatabase = Room.databaseBuilder(context, InfoTripDatabase.class, DB_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();

        Toast.makeText(context, "Database created...", Toast.LENGTH_LONG).show();
    }

    public void InsertClient(final Clienti client) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                infoTripDatabase.infoTripDao().insertClient((client));
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, client.getEmail() + "is Inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }

    public void InsertIstoric(final Istoric istoric) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {

                infoTripDatabase.infoTripDao().insertIstoric((istoric));

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, istoric.getClientId() + "is Inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }

    public void InsertFavorit(final Favorite favorite) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {

                infoTripDatabase.infoTripDao().insertFav((favorite));

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, favorite.getIdFav() + "is Inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }

    public void InsertPoze(final PozeClienti poza) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {

                infoTripDatabase.infoTripDao().insertPoze((poza));

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, poza.getIdPoza() + "is Inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }

    public void InsertReviewApp(final ReviewAplicatie reviewAplicatie) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {

                infoTripDatabase.infoTripDao().insertReviewAplicatie((reviewAplicatie));

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, reviewAplicatie.getIdReview() + "is Inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }

    public void InsertReviewLocatie(final ReviewLocatie reviewLocatie) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {

                infoTripDatabase.infoTripDao().insertReviewLocatie((reviewLocatie));

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context, reviewLocatie.getIdReview() + "is Inserted", Toast.LENGTH_LONG).show();
            }
        }.execute();
    }

    public Clienti getClient(String email) {

        Clienti client=new Clienti();
        client = infoTripDatabase.infoTripDao().getClient(email);
        Email.idClient = client.getIdClient();
        Log.e("IdClient", String.valueOf(Email.idClient));
        return client;

    }

    public List<Clienti> getAllClienti() {

        List<Clienti> clienti=new ArrayList<>();
        clienti = infoTripDatabase.infoTripDao().getAllClienti();

        for(Clienti c : clienti){
            Log.e("TEST", c.toString());
        }
        return clienti;
    }

    public List<Favorite> getFav(int idClient){
        List<Favorite> lista_favorite=new ArrayList<Favorite>();
        lista_favorite=infoTripDatabase.infoTripDao().getFav(idClient);
        return lista_favorite;
    }

    public List<Istoric> getIstoric(int idClient){
        List<Istoric> lista_istoric=new ArrayList<Istoric>();
        lista_istoric=infoTripDatabase.infoTripDao().getIstoric(idClient);
        return lista_istoric;
    }

    public List<PozeClienti> getPoze(int idClient){
        List<PozeClienti> lista_poze=new ArrayList<PozeClienti>();
        lista_poze=infoTripDatabase.infoTripDao().getPoze(idClient);
        return lista_poze;
    }



}
