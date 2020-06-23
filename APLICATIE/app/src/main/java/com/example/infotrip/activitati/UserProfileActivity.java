package com.example.infotrip.activitati;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.infotrip.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;



public class UserProfileActivity extends AppCompatActivity {

    GoogleSignInClient googleSignInClient;
    TextView numeMare;
    TextInputEditText firstname,email,lastname;
    ImageView imgprofil ,imgFav;
    Button signOUT;
    CardView istoric,fav;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        numeMare=(TextView)findViewById(R.id.textViewUserProfileActivityNumePrenumeUser);
        firstname=(TextInputEditText)findViewById(R.id.fullnameTextInputUserProfilActivity);
        email=(TextInputEditText)findViewById(R.id.emailTextInputUserProfilActivity);
       lastname=(TextInputEditText)findViewById(R.id.BirthDayTextInputUserProfilActivity);
        imgprofil=(ImageView)findViewById(R.id.imageViewProfileUserProfileActivity);
        signOUT=(Button)findViewById(R.id.buttonSignOutUserProfile);
        imgFav=(ImageView)findViewById(R.id.imageViewFav);

        Glide.with(this).load(R.raw.heart).into(imgFav);




        signOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case  R.id.buttonSignOutUserProfile:
                        signout();
                        break;
                }
            }
        });
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient= GoogleSignIn.getClient(this,gso);
        GoogleSignInAccount acct=GoogleSignIn.getLastSignedInAccount(UserProfileActivity.this);
        if(acct!=null){
            String personName=acct.getDisplayName();
            String personFirstName=acct.getGivenName();
            String personEmail=acct.getEmail();
            String personLastName=acct.getFamilyName();
            Uri personPhoto=acct.getPhotoUrl();

            numeMare.setText( personName);

            firstname.setText(personFirstName);
            lastname.setText(personLastName);
            email.setText(personEmail);
            Glide.with(this).load(personPhoto).into(imgprofil);


        }
        istoric=(CardView)findViewById(R.id.cardViewIstoric);
        istoric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(UserProfileActivity.this, IstoricPersonalActivity.class);
                startActivity(intent1);

            }
        });

        fav=(CardView)findViewById(R.id.cardViewFav);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(UserProfileActivity.this, AddPhotoActivity.class);
                startActivity(intent2);

            }
        });

    }

    private void signout(){
        googleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(UserProfileActivity.this,"Signed out successfully",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    public void onClickAddPhoto(View view) {

    }

    public void onClickHistory(View view) {
    }

    public void vizualizareFavorite(View view) {
        Intent intent=new Intent(UserProfileActivity.this,FavoriteActivity.class);
        startActivity(intent);
    }
}
