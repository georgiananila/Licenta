package com.example.infotrip.activitati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.infotrip.R;
import com.example.infotrip.database.Favorite;
import com.example.infotrip.database.InfoTripRepository;
import com.example.infotrip.database.Istoric;
import com.example.infotrip.utility.AdapterIstoric;
import com.example.infotrip.utility.Email;
import com.example.infotrip.utility.Item;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        //set the statue bar background to transparent

        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        //setup recyclerview with the adapter

        recyclerView=findViewById(R.id.rv_list_fav);
        populateFavorite();

    }

    void populateFavorite(){
        List<Item> itemList=new ArrayList<>();
        //aici preluam din baza de date in functie de user si adaugam in lista
        List<Favorite> listaFavorite = InfoTripRepository.getInstance(
                getApplicationContext()).getFav(Email.idClient);

        for(Favorite fav : listaFavorite){
            itemList.add(new Item(createBitmapFromByte(fav.getImage()), fav.getDenumireLocatie(),
                    R.drawable.cazareicon, fav.getRating()));
        }
        AdapterIstoric adapterIstoric=new AdapterIstoric(this,itemList);
        recyclerView.setAdapter(adapterIstoric);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    Bitmap createBitmapFromByte(byte [] imageInfo){
        Bitmap retVal = null;

        if(imageInfo != null ){
            retVal = BitmapFactory.decodeByteArray(imageInfo, 0, imageInfo.length);
        }
        return retVal;
    }

}
