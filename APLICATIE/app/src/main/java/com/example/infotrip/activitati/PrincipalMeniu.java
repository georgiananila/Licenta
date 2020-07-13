package com.example.infotrip.activitati;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.infotrip.R;
import com.example.infotrip.nefolosite.SearchAccomodationActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class PrincipalMeniu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView imagineAventura;
    ImageView imagineCautaLocatie;
    ImageView imagineCazare;
    ImageView imagineGhid;
    ImageView imaginePersonalizeaza;

    CardView searchAcc,searchLoc,ghid,personalizare;
FirebaseAuth auth;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_meniu);
        configNavigation();

        imagineAventura=(ImageView)findViewById(R.id.imageViewMeniuPrincipal);
        imagineAventura.setImageResource(R.drawable.adventure_icon);

        imagineCautaLocatie=(ImageView)findViewById(R.id.imageViewCautaLocatieMeniuPrincipal);
        imagineCautaLocatie.setImageResource(R.drawable.cauta_locatie_icon2);

        imagineCazare=(ImageView)findViewById(R.id.imageViewAccomodationMeniuPrincipal);
        imagineCazare.setImageResource(R.drawable.cazareicon);

        imagineGhid=(ImageView)findViewById(R.id.imageViewGhidSupravietuireMeniuPrincipal);
        imagineGhid.setImageResource(R.drawable.ghid);

        imaginePersonalizeaza=(ImageView)findViewById(R.id.imageViewPersonalizeazaMeniuPrincipal);
        imaginePersonalizeaza.setImageResource(R.drawable.personalizeazaicon);

        auth=FirebaseAuth.getInstance();
        searchAcc=(CardView)findViewById(R.id.cardViewMeniuPrincipalCautaCazare);
        searchLoc=(CardView)findViewById(R.id.cardViewMeniuPrincipalAlegeLocatie);
        ghid=(CardView)findViewById(R.id.cardViewMeniuPrincipalGhidSupravietuire);
        personalizare=(CardView)findViewById(R.id.cardViewMeniuPrincipalPersonalizeaza);


        searchAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(PrincipalMeniu.this, AccomodationGoogleMapsActivity.class);
                startActivity(intent1);

            }
        });

        searchLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(PrincipalMeniu.this, SearchGoogleLocationActivity.class);
                startActivity(intent2);

            }
        });

        ghid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(PrincipalMeniu.this, PreSurvivalGuideActivity.class);
                startActivity(intent3);
            }
        });


    }


    private void configNavigation() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navi_open,R.string.navi_close);
        navigationView.bringToFront();
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {





            case R.id.profile:
                Toast.makeText(this, "Your profile selected", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(getApplicationContext(), UserProfileActivity.class);
                startActivity(intent2);
                return true;

            case R.id.ratingApp:
                Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
                Intent intent3=new Intent(getApplicationContext(), RateApplicationActivity.class);
                startActivity(intent3);
                return true;

            case R.id.logout:
                //signout


            case R.id.changePass:
                showRecoverPasswordDialog();






            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }


    public void OnClickCautaCazare(View view) {
        Intent cautaCazare=new Intent(this,SearchAccomodationActivity.class);
        startActivity(cautaCazare);
    }
    public void OnClickCautaLocatie(View view) {
        Intent cautaLocatie=new Intent(this,SearchGoogleLocationActivity.class);
        startActivity(cautaLocatie);
    }

    private void showRecoverPasswordDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Recover Password");

        LinearLayout linearLayout=new LinearLayout(this);

        final EditText emailEt=new EditText(this);
        emailEt.setHint("Email");
        emailEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);


        emailEt.setMinEms(10);
        linearLayout.addView(emailEt);
        linearLayout.setPadding(10,10,10,10);

        builder.setView(linearLayout);


        builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email=emailEt.getText().toString().trim();
                beginRecovery(email);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();

    }

    private void beginRecovery(String email) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(PrincipalMeniu.this,"Email sent",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(PrincipalMeniu.this,"Failed...",Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PrincipalMeniu.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

}
