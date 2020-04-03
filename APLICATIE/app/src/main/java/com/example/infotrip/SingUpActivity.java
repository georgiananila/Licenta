package com.example.infotrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SingUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
    }

    public void onClickLogIn(View view) {
        Intent intentLegaturaLogInSingUp=new Intent(this,LogInActivity.class);
        startActivity(intentLegaturaLogInSingUp);
    }
}
