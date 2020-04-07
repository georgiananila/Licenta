package com.example.infotrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SingUpActivity extends AppCompatActivity {

    Button singUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        singUp=(Button)findViewById(R.id.buttonSingUpActivitySingUp);
        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserProfilActivity();
            }
        });
    }

    private void openUserProfilActivity() {
        Intent intent=new Intent(this,UserProfileActivity.class);
        startActivity(intent);
    }

    public void onClickLogIn(View view) {
        Intent intentLegaturaLogInSingUp=new Intent(this,LogInActivity.class);
        startActivity(intentLegaturaLogInSingUp);
    }
}
