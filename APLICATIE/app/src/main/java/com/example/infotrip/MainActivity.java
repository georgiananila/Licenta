package com.example.infotrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
   public ImageView imagineLogo;
    public ImageButton imagineFacebook;
    public ImageButton imagineGoogle;
    public Button butonCreareCont;
    public Button butonLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      imagineLogo=findViewById(R.id.imageViewStartActivity);
      imagineLogo.setImageResource(R.drawable.logomainactivity);

      imagineFacebook=findViewById(R.id.imageButtonFacebookLogInMainActivity);
      imagineFacebook.setImageResource(R.drawable.fbiconmainactivity);

      imagineGoogle=findViewById(R.id.imageButtonGoogleLogInMainActivity);
      imagineGoogle.setImageResource(R.drawable.googleiconmainactivity);

      butonLogIn=findViewById(R.id.buttonMainActivityLogIn);
        butonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogInActivity();
            }
        });

      butonCreareCont=findViewById(R.id.buttonSingUpEmail);
        butonCreareCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSingUpActivity();
            }
        });


    }

    private void openLogInActivity() {
        Intent intentLegaturaMainActivityLogIn=new Intent(this,LogInActivity.class);
        startActivity(intentLegaturaMainActivityLogIn);
    }

    private void openSingUpActivity() {
        Intent intentLegaturaMainSingUp=new Intent(this,SingUpActivity.class);
        startActivity(intentLegaturaMainSingUp);
    }
}
