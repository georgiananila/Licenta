package com.example.infotrip.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.infotrip.R;
import com.example.infotrip.nefolosite.SearchAccomodationActivity;

public class LocationActivity extends AppCompatActivity {

    ViewFlipper viewFlipper,viewFlipper2;
    TextView txtDescrire;
    Animation bottomAnim,topAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottomAnim= AnimationUtils.loadAnimation(this, R.anim.botton_animation);
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        txtDescrire=(TextView)findViewById(R.id.textViewDescrire);

        txtDescrire.setAnimation(bottomAnim);

        int images2[]={R.drawable.view,R.drawable.stress,R.drawable.healty};
        int images[]={R.drawable.carpatiimeridionali,R.drawable.carp_meridionali_1,R.drawable.carp_meridionali_2,R.drawable.carp_meri_3};

        viewFlipper=(ViewFlipper)findViewById(R.id.v_flipper);
        viewFlipper2=(ViewFlipper)findViewById(R.id.v_flipper2);

        for(int i=0;i<images.length;i++){
            flipperImages(images[i]);
        }

        for(int i=0;i<images2.length;i++){
            flipperImages2(images2[i]);
        }
    }

    public void flipperImages(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);


    }

    public void flipperImages2(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper2.addView(imageView);
        viewFlipper2.setFlipInterval(2000);
        viewFlipper2.setAutoStart(true);

        viewFlipper2.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper2.setOutAnimation(this,android.R.anim.slide_out_right);


    }

    public void openSearchAccom(View view) {
        Intent intent1=new Intent(LocationActivity.this, SearchAccomodationActivity.class);
        startActivity(intent1);
    }
}
