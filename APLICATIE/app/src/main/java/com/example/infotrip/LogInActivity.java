package com.example.infotrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LogInActivity extends AppCompatActivity {
    public ImageView imagineLogoLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        imagineLogoLogIn=(ImageView)findViewById(R.id.imageViewLogInActivityLogo);
        imagineLogoLogIn.setImageResource(R.drawable.logomainactivity);
    }

    public void onClickRegister(View view) {
        Intent intentLegaturaLogInSingUp=new Intent(this,SingUpActivity.class);
        startActivity(intentLegaturaLogInSingUp);
    }
}
