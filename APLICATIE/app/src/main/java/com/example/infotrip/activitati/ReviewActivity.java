package com.example.infotrip.activitati;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.infotrip.R;
import com.example.infotrip.database.InfoTripRepository;
import com.example.infotrip.database.ReviewLocatie;

public class ReviewActivity extends AppCompatActivity {

    Button button;
    RatingBar ratingBar;
    EditText sugestie;

    float myRating=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        button=(Button)findViewById(R.id.buttonAddReview);
        ratingBar=(RatingBar)findViewById(R.id.ratingBarReview);
        sugestie=(EditText)findViewById(R.id.editTextSugestieLocatie);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {
                int rating=(int)v;
                String message=null;

                myRating=ratingBar.getRating();

                switch (rating){
                    case 1:
                        message="Sorry to hear that!";
                        break;
                    case 2:
                        message="You always accept suggestion!";
                        break;
                    case 3:
                        message="Good enough!";
                        break;
                    case 4:
                        message="Great!";
                        break;
                    case 5:
                        message="Awesome!You are the best!";
                        break;
                }

                Toast.makeText(ReviewActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReviewActivity.this,"Your rating is: "+String.valueOf(myRating),Toast.LENGTH_SHORT).show();
                InfoTripRepository.getInstance(getApplicationContext()).InsertReviewLocatie(createReviewLocatie());
            }
        });
    }

    ReviewLocatie createReviewLocatie(){
        ReviewLocatie retVal = new ReviewLocatie(0,
                sugestie.getText().toString(),String.valueOf(ratingBar.getRating()));

        return retVal;
    }
}
