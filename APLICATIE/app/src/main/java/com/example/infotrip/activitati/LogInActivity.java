package com.example.infotrip.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.infotrip.R;

public class LogInActivity extends AppCompatActivity {
    public ImageView imagineLogoLogIn;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        imagineLogoLogIn=(ImageView)findViewById(R.id.imageViewLogInActivityLogo);
        imagineLogoLogIn.setImageResource(R.drawable.imaginelogologin);

        login=findViewById(R.id.buttonLogInActivityLogIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrincipalActivity();
            }
        });
    }

    private void openPrincipalActivity() {
        Intent intent=new Intent(this, PrincipalMeniu.class);
        startActivity(intent);
    }

    public void onClickRegister(View view) {
        Intent intentLegaturaLogInSingUp=new Intent(this, SingUpActivity.class);
        startActivity(intentLegaturaLogInSingUp);
    }
}
