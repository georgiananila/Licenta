package com.example.infotrip.activitati;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.infotrip.R;
import com.example.infotrip.utility.UrlCreator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class DetaliiLocatiiAccomodationActivity extends AppCompatActivity {

    String mTitle;
    List<HashMap<String, String >> mInterogrationDetails = null;
    UrlCreator urlCreator;
    FloatingActionButton fab_add,fab_am_fost,fab_heart,fab_review;
    Animation fabOpen,fabClose,fabRclockWise;
    boolean isOpen=false;
    TextView textViewDenumire,textViewVicinity,textViewLatLong,textViewUserRatingTotal,textViewRating,textOpen;
    ImageView imagineIcon,imageViewGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalii_locatii_accomodation);
        mTitle = getIntent().getStringExtra("title");
        mInterogrationDetails = (List<HashMap<String, String>>) getIntent().getSerializableExtra("Array");
        urlCreator=new UrlCreator();
        Log.d("Title", mTitle);

        for(int i = 0; i < mInterogrationDetails.size(); i++){
            Log.d("Lista", mInterogrationDetails.get(i).toString());
        }

        textViewDenumire=(TextView)findViewById(R.id.textViewDenumireLocatie) ;
       // textViewType=(TextView)findViewById(R.id.textType);
        textViewLatLong=(TextView)findViewById(R.id.textlatlong);
        textViewVicinity=(TextView)findViewById(R.id.textVicinity);
        textViewUserRatingTotal=(TextView)findViewById(R.id.testUserRatingTotal);
        textViewRating=(TextView)findViewById(R.id.textRating);
        textOpen=(TextView)findViewById(R.id.textOpen);

        imagineIcon=(ImageView)findViewById(R.id.imageViewIcon);
        imageViewGif=(ImageView)findViewById(R.id.imageViewGif);

        populateListByTitle();

        fab_add=(FloatingActionButton)findViewById(R.id.fab_plus);
        fab_am_fost=(FloatingActionButton)findViewById(R.id.fab_amfost);
        fab_heart=(FloatingActionButton)findViewById(R.id.fab_fav);
        fab_review=(FloatingActionButton)findViewById(R.id.fab_review);
        fabOpen= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fabClose= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fabRclockWise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotete_clockwise);



        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    fab_am_fost.startAnimation(fabClose);
                    fab_heart.startAnimation(fabClose);
                    fab_review.startAnimation(fabClose);
                    fab_add.startAnimation(fabRclockWise);
                    fab_am_fost.setClickable(false);
                    fab_review.setClickable(false);
                    fab_heart.setClickable(false);
                    isOpen=false;

                }else{
                    fab_am_fost.startAnimation(fabOpen);
                    fab_heart.startAnimation(fabOpen);
                    fab_review.startAnimation(fabOpen);
                    fab_add.startAnimation(fabRclockWise);
                    fab_am_fost.setClickable(true);
                    fab_review.setClickable(true);
                    fab_heart.setClickable(true);
                    isOpen=true;

                }
            }
        });
    }

    private void populateListByTitle(){
        final int listSize = mInterogrationDetails.size();
        for(int i = 0; i < listSize; i++){
            HashMap<String, String> currentLocation = mInterogrationDetails.get(i);
            Log.e("Compare1", mTitle);
            String nameOfLocation = currentLocation.get("place_name") + " : " + currentLocation.get("vicinity");
            Log.e("Compare2", nameOfLocation);

            Log.e("BOOLEAN = ", String.valueOf(0 == mTitle.compareTo(nameOfLocation) ));
            if(0 == mTitle.compareTo(nameOfLocation) ){
                Log.d("place_name",currentLocation.get("place_name"));
                Log.d("vicinity",currentLocation.get("vicinity"));
                Log.d("latitude",currentLocation.get("latitude"));
                Log.d("longitude",currentLocation.get("longitude"));
                Log.d("reference",currentLocation.get("reference"));
                Log.d("types", currentLocation.get("types"));
                Log.d("icon", currentLocation.get("icon"));
                Log.d("user_ratings_total", String.valueOf(currentLocation.get("user_ratings_total")));
                Log.d("rating", String.valueOf(currentLocation.get("rating")));
                Log.d("isOpen", String.valueOf(currentLocation.get("isOpen")));
                String imageURL = urlCreator.getUrlForPhoto(400,400,currentLocation.get("photo_reference"));

                new DownloadImageTask((ImageView) findViewById(R.id.imageViewIcon)).execute(imageURL);
                String rating=String.valueOf(currentLocation.get("rating"));
                textViewDenumire.setText(currentLocation.get("place_name"));
                //textViewType.setText(currentLocation.get("types"));
                textViewLatLong.setText("Latitude:"+currentLocation.get("latitude")+" and Longitude:"+currentLocation.get("longitude"));
                textViewVicinity.setText("Adress:"+currentLocation.get("vicinity"));
                textViewUserRatingTotal.setText("Total number of ratings:"+ String.valueOf(currentLocation.get("user_ratings_total")));
                textViewRating.setText("Rating:"+rating );
                String open=String.valueOf(currentLocation.get("isOpen"));
                if(open=="true"){
                    open="Yes";

                }else{
                    open="No";
                }
                textOpen.setText("Open now:"+open);
                if(Float.parseFloat(rating)>=4.0){
                    Glide.with(this).load(R.raw.like).into(imageViewGif);
                }else if(Float.parseFloat(rating)<4.0&&Float.parseFloat(rating)>0){
                    Glide.with(this).load(R.raw.bad).into(imageViewGif);
                }else if(Float.parseFloat(rating)==0){
                    Glide.with(this).load(R.raw.review).into(imageViewGif);
                }


            }
        }
    }

    public void addReview(View view) {
        Intent intent=new Intent(getApplicationContext(),ReviewActivity.class);
        startActivity(intent);
    }

    public void addHistory(View view) {
        //save in database
    }

    public void addFav(View view) {
        //save in database
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
