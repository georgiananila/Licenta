package com.example.infotrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



   public ImageView imagineLogo;
    public ImageView imagineFacebook;
    public ImageView imagineGoogle;
    public Button butonCreareCont;
    public Button butonLogIn;
    TextView numeAplicatie;
    TextView txt1,txt2,txt3;

    Animation topAnimation,bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.botton_animation);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      imagineLogo=findViewById(R.id.imageViewStartActivity);
      imagineLogo.setImageResource(R.drawable.mountaigne2);

      imagineFacebook=findViewById(R.id.imageButtonFacebookLogInMainActivity);
      imagineFacebook.setImageResource(R.drawable.facebooklogocirclenew);

      imagineGoogle=findViewById(R.id.imageButtonGoogleLogInMainActivity);
      imagineGoogle.setImageResource(R.drawable.googlephoto2);

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

        numeAplicatie=findViewById(R.id.textViewNumeAplicatie);
        txt1=findViewById(R.id.textViewAlreadyhaveAccount);
        txt2=findViewById(R.id.textViewContinueMainActivity);
        txt3=findViewById(R.id.textViewEmailLogInMainActivity);






        txt3.setAnimation(bottomAnim);
        txt1.setAnimation(bottomAnim);
        butonLogIn.setAnimation(bottomAnim);
        butonCreareCont.setAnimation(bottomAnim);



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
