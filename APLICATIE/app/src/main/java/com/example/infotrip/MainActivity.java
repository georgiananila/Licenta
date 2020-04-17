package com.example.infotrip;

import androidx.annotation.Nullable;
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

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {



   public ImageView imagineLogo;
    public LoginButton imagineFacebook;
    public ImageView imagineGoogle;
    public Button butonCreareCont;
    public Button butonLogIn;
    TextView numeAplicatie;
    TextView txt1,txt2,txt3;

    Animation topAnimation,bottomAnim;

    CallbackManager callbackManager;
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

         callbackManager=CallbackManager.Factory.create();

        imagineFacebook.registerCallback(callbackManager,new FacebookCallback<LoginResult>(){
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent logInFacebook=new Intent(getApplicationContext(),PrincipalMeniu.class);
                startActivity(logInFacebook);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
        

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
