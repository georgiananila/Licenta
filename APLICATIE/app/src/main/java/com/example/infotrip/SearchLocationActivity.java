package com.example.infotrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchLocationActivity extends AppCompatActivity {

    ImageView imagineMuntiiOcc,imagineMuntiiOri,imagineMuntiiMeri;
    TextView txtCmer,txtcarocc,txtcapori;
    Animation bottomAnim,topAnimation;
    CardView cardViewMuntiiMeri,cardViewMuntiiOcc,cardViewMuntiiOri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.botton_animation);
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_location);


        imagineMuntiiOri=(ImageView)findViewById(R.id.imgVcarpatiiOrientali);
        imagineMuntiiOcc=(ImageView)findViewById(R.id.imgVCarpatiiOccidentali);
        imagineMuntiiMeri=(ImageView)findViewById(R.id.imgVCarpatiiMeridionali);
        txtCmer=(TextView)findViewById(R.id.textViewCarMer);
        txtcarocc=(TextView)findViewById(R.id.textView41);
        txtcapori=(TextView)findViewById(R.id.textView31);
        cardViewMuntiiMeri=(CardView)findViewById(R.id.carpatiiMeridionali);
        cardViewMuntiiOcc=(CardView)findViewById(R.id.carpatiiOccidentali);
        cardViewMuntiiOri=(CardView)findViewById(R.id.MuntiiOrientali);


        cardViewMuntiiMeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(SearchLocationActivity.this,LocationActivity.class);
                startActivity(intent2);
            }
        });

        cardViewMuntiiOri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(SearchLocationActivity.this,LocationActivity.class);
                startActivity(intent2);
            }
        });
        cardViewMuntiiOcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(SearchLocationActivity.this,LocationActivity.class);
                startActivity(intent2);
            }
        });



        imagineMuntiiMeri.setImageResource(R.drawable.carpatiimeridionali);
        imagineMuntiiOcc.setImageResource(R.drawable.carpatii_occidentali);
        imagineMuntiiOri.setImageResource(R.drawable.carpatii_orientali);

        txtCmer.setAnimation(topAnimation);
        txtcapori.setAnimation(bottomAnim);
        txtcarocc.setAnimation(topAnimation);
        imagineMuntiiOri.setAnimation(bottomAnim);
        imagineMuntiiOcc.setAnimation(topAnimation);
        imagineMuntiiMeri.setAnimation(topAnimation);


    }
}
