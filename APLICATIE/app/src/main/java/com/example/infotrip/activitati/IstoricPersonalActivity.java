package com.example.infotrip.activitati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.infotrip.R;
import com.example.infotrip.utility.AdapterIstoric;
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
        List<Item> itemList=new ArrayList<>();
        //aici preluam din baza de date in functie de user si adaugam in lista
        itemList.add(new Item(R.drawable.carp_meridionali_1,"Carpatii Meridionali",R.drawable.cazareicon,3.4f));
        itemList.add(new Item(R.drawable.carp_orientali_1,"Carpatii Occidentali",R.drawable.cazareicon,3.4f));
        AdapterIstoric adapterIstoric=new AdapterIstoric(this,itemList);
        recyclerView.setAdapter(adapterIstoric);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
