package com.example.infotrip.activitati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.infotrip.R;
import com.example.infotrip.database.InfoTripRepository;
import com.example.infotrip.database.Istoric;
import com.example.infotrip.utility.AdapterIstoric;
import com.example.infotrip.utility.Email;
import com.example.infotrip.utility.Item;

import java.util.ArrayList;
import java.util.List;

public class IstoricPersonalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istoric_personal);


        //set the statue bar background to transparent

        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        //setup recyclerview with the adapter

         recyclerView=findViewById(R.id.rv_list_istoric);
        populateIstoric();


    }

    void populateIstoric(){
        List<Item> itemList=new ArrayList<>();
        //aici preluam din baza de date in functie de user si adaugam in lista
        List<Istoric> listaIstoric = InfoTripRepository.getInstance(
                getApplicationContext()).getIstoric(Email.idClient);

        for(Istoric is : listaIstoric){
            itemList.add(new Item(createBitmapFromByte(is.getImage()), is.getDenumireLocatie(),
                    R.drawable.correct, is.getRating()));
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
