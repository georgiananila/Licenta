package com.example.infotrip.activitati;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.infotrip.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {
    public ImageView imagineLogoLogIn;
    Button login;
    EditText mEmail,mpass;

    FirebaseAuth auth;
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
                loginUser();
               // openPrincipalActivity();
            }


        });
        mEmail=findViewById(R.id.editTextLogInActivityEmail);
        mpass=findViewById(R.id.editTextLogInActivityPass);

        auth=FirebaseAuth.getInstance();


    }

    private void openPrincipalActivity() {
        Intent intent=new Intent(this, PrincipalMeniu.class);
        startActivity(intent);
    }

    public void onClickRegister(View view) {
        Intent intentLegaturaLogInSingUp=new Intent(this, SingUpActivity.class);
        startActivity(intentLegaturaLogInSingUp);
    }

    private void loginUser() {
        String email=mEmail.getText().toString().trim();
        String pass=mpass.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            mEmail.setError("Email is required");
            return;
        }

        if(TextUtils.isEmpty(pass)){
            mpass.setError("Password is required");
            return;
        }
        if(pass.length()<6){
            mpass.setError("Password must be>=6 characters");
            return;
        }



        //authenticate the user

        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LogInActivity.this,"Logged is Successfully",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),PrincipalMeniu.class));
                }else{
                    Toast.makeText(LogInActivity.this,"Could not register, please try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClickForgot(View view) {
        showRecoverPasswordDialog();
    }

    private void showRecoverPasswordDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Recover Password");

        LinearLayout linearLayout=new LinearLayout(this);

        final EditText emailEt=new EditText(this);
        emailEt.setHint("Email");
        emailEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);


        emailEt.setMinEms(10);
        linearLayout.addView(emailEt);
        linearLayout.setPadding(10,10,10,10);

        builder.setView(linearLayout);


        builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email=emailEt.getText().toString().trim();
                beginRecovery(email);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();

    }

    private void beginRecovery(String email) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LogInActivity.this,"Email sent",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(LogInActivity.this,"Failed...",Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LogInActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
