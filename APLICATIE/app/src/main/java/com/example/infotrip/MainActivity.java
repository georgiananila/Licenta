package com.example.infotrip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imagineLogo;
    ImageButton imagineFacebook;
    ImageButton imagineGoogle;
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


    }
}
