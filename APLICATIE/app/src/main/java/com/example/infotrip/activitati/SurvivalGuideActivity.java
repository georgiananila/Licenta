package com.example.infotrip.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.infotrip.R;

public class SurvivalGuideActivity extends AppCompatActivity {

    ImageView imgBack,imgMunti,imgCort,imgGo;
    TextView vreme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survival_guide);

        imgBack=(ImageView)findViewById(R.id.imgBackPack);
        imgMunti=(ImageView)findViewById(R.id.imgMunti);
        imgCort=(ImageView)findViewById(R.id.imgCort);
        imgGo=(ImageView)findViewById(R.id.imgGo);
        vreme=(TextView)findViewById(R.id.txtvreme);

        Glide.with(this).load(R.raw.back2).into(imgBack);
        Glide.with(this).load(R.raw.source).into(imgMunti);
        Glide.with(this).load(R.raw.tent2).into(imgCort);
        Glide.with(this).load(R.raw.go).into(imgGo);


        vreme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),VremeActivity.class);
                startActivity(intent);
            }
        });



    }
}
