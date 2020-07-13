package com.example.infotrip.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.infotrip.R;

import java.io.InputStreamReader;

public class PreSurvivalGuideActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    ImageView img1,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_survival_guide);
        int images[]={R.drawable.hikings1,R.drawable.hikings2,R.drawable.hikings3,R.drawable.hikings4,R.drawable.hikings5,R.drawable.hikings6};
        viewFlipper=(ViewFlipper)findViewById(R.id.v_flipperGuide);
        img1=(ImageView)findViewById(R.id.imageView1Guide) ;
        img2=(ImageView)findViewById(R.id.imageView2Guide) ;
        Glide.with(this).load(R.raw.arr1).into(img1);
        Glide.with(this).load(R.raw.arr2).into(img2);

        for(int i=0;i<images.length;i++){
            flipperImages(images[i]);
        }

        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),SurvivalGuideActivity.class);
                startActivity(intent1);

            }
        });
    }

    private void flipperImages(int image) {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
