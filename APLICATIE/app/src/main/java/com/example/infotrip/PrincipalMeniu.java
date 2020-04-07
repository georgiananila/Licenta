package com.example.infotrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class PrincipalMeniu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView imagineAventura;
    ImageView imagineCautaLocatie;
    ImageView imagineCazare;
    ImageView imagineGhid;
    ImageView imaginePersonalizeaza;

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
        return true;
    }


}
