package com.example.infotrip.activitati;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infotrip.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;

public class MainActivity extends AppCompatActivity {


    private static final int RC_SIGN_IN = 0;
    public ImageView imagineLogo;
    public LoginButton imagineFacebook;
    public SignInButton imagineGoogle;
    public Button butonCreareCont;
    public Button butonLogIn;
    TextView numeAplicatie;
    TextView txt1,txt2,txt3;
    GoogleSignInClient googleSignInClient;

    Animation topAnimation,bottomAnim;

    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topAnimation= AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.botton_animation);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      imagineLogo=findViewById(R.id.imageViewStartActivity);
      imagineLogo.setImageResource(R.drawable.mountaigne2);

      imagineFacebook=findViewById(R.id.imageButtonFacebookLogInMainActivity);


      imagineGoogle=findViewById(R.id.imageButtonGoogleLogInMainActivity);


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

        txt3=findViewById(R.id.textViewEmailLogInMainActivity);


        //sing in with google
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        googleSignInClient= GoogleSignIn.getClient(this,gso);
        imagineGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        //LogIn with fb
         callbackManager=CallbackManager.Factory.create();

        imagineFacebook.registerCallback(callbackManager,new FacebookCallback<LoginResult>(){
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent logInFacebook=new Intent(getApplicationContext(), PrincipalMeniu.class);
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

    private void signIn() {
        Intent signInIntent=googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }

    private void openLogInActivity() {
        Intent intentLegaturaMainActivityLogIn=new Intent(this, LogInActivity.class);
        startActivity(intentLegaturaMainActivityLogIn);
    }

    private void openSingUpActivity() {
        Intent intentLegaturaMainSingUp=new Intent(this, SingUpActivity.class);
        startActivity(intentLegaturaMainSingUp);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            com.google.android.gms.tasks.Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSingInResult(task);
        }
        callbackManager.onActivityResult(requestCode,resultCode,data);


    }

    private void handleSingInResult(com.google.android.gms.tasks.Task<GoogleSignInAccount> task) {
        try{
            GoogleSignInAccount account=task.getResult(ApiException.class);

            startActivity(new Intent(MainActivity.this, UserProfileActivity.class));


        }catch (ApiException e){
            Log.w("GoogleError","signInResult: failed code= "+e.getStatusCode());
            Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onStart() {
        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(this);

        if(account!=null){
            startActivity(new Intent(MainActivity.this,UserProfileActivity.class));
        }
        super.onStart();
    }
}
