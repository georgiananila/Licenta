package com.example.infotrip.nefolosite;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.infotrip.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AccomodationListActivity extends AppCompatActivity {

    FloatingActionButton butonFiltre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation_list);

        butonFiltre=(FloatingActionButton)findViewById(R.id.ButtonFiltreListaAcc);
        butonFiltre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AccomodationListActivity.this, FilterAccomodationActivity.class);
                startActivityForResult(intent,101);
            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101){

            Toast.makeText(AccomodationListActivity.this,"filtrele s-au aplicat",Toast.LENGTH_LONG).show();
            //getStringExtra("data")
        }
    }






}
