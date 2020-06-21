package com.example.infotrip.activitati;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.infotrip.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class SingUpActivity extends AppCompatActivity {



    Button singUp;
    Spinner spinnerTara;
    EditText editTextnume,editTextprenume,editTextdata,editTextemail,editTextpass,editTextpass2;
String nume,prenume,data,tara,email,pass,pass2;
    private ProgressBar progressDialog;
    private FirebaseAuth firebaseAuth;


    //JSON RETEA
    public class  Info extends AsyncTask<String,Void,String>
    {
        String rez;
        @Override
        protected String doInBackground(String... strings) {
            URL url=null;
            HttpURLConnection connection=null;
            StringBuilder stringBuilder=new StringBuilder();

            try {
                url=new URL(strings[0]);
                connection=(HttpURLConnection)url.openConnection();
                StringBuilder rezultat=new StringBuilder();

                InputStream is=connection.getInputStream();
                InputStreamReader isr=new InputStreamReader(is);
                BufferedReader reader=new BufferedReader(isr);

                String linie="";
                while((linie=reader.readLine())!=null){
                    stringBuilder.append(linie);
                }
                // Log.e("Test",stringBuilder.toString() );

                JSONObject jsonObject=new JSONObject(stringBuilder.toString());
                //JSONObject code=jsonObject.getJSONObject("code");
                JSONArray result = jsonObject.getJSONArray("result");


                for(int i=0;i<result.length();i++){
                    JSONObject obj=(JSONObject)result.get(i);
                    rezultat.append("\n");
                    rezultat.append("#");
                    rezultat.append(obj.getString("name"));
                    //Log.e("REzultat", rezultat.toString());
                }

                rez = rezultat.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return rez;
        }
    }

    public void cauta(){
        Info info=new Info(){
            @Override
            protected void onPostExecute(String s) {
                // Log.e("DupaExec", s);
                String[] valori=s.split("#");
                ArrayList<String> list = new ArrayList<String>(Arrays.asList(valori));
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                        R.layout.spinner, R.id.txt, list);
                spinnerTara.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        };
        info.execute("https://api.printful.com/countries");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        singUp=(Button)findViewById(R.id.buttonSingUpActivitySingUp);
        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
                openUserProfilActivity();
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=(ProgressBar)findViewById(R.id.progressBar);
        spinnerTara=(Spinner)findViewById(R.id.spinnerSingUpActivityTara);
        editTextnume=(EditText)findViewById(R.id.editTextSingUpActivityFirstName);
        editTextprenume=(EditText)findViewById(R.id.editTextSingUpActivityLastName);
        editTextdata=(EditText)findViewById(R.id.editTextSingUpActivityBirthDate);
        editTextemail=(EditText)findViewById(R.id.editTextSingUpActivityEmail);
        editTextpass=(EditText)findViewById(R.id.editTextSingUpActivityParola);
        editTextpass2=(EditText)findViewById(R.id.editTextSingUpActivityCheckPass);


        cauta();
    }

    private void registerUser() {


        if(editTextnume.getText().toString().isEmpty()||
                editTextprenume.getText().toString().isEmpty()||
                editTextdata.getText().toString().isEmpty()||
                editTextpass.getText().toString().isEmpty()||
                editTextpass2.getText().toString().isEmpty()||
                editTextemail.getText().toString().isEmpty()||
                spinnerTara.getSelectedItem().toString().isEmpty()){

            Toast.makeText(getApplicationContext(),"Fill Detail",Toast.LENGTH_LONG).show();
        }else{
             nume=editTextnume.getText().toString().trim();
             prenume=editTextprenume.getText().toString().trim();
             data=editTextdata.getText().toString().trim();
             email=editTextemail.getText().toString().trim();
             pass=editTextpass.getText().toString().trim();
             pass2=editTextpass2.getText().toString().trim();
             tara = spinnerTara.getSelectedItem().toString();
        }

        //if validation are ok
        //progress bar
        progressDialog.setVisibility(View.VISIBLE);



        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //aici verificari email daca exista si verificare match password si salvare in room a celorlalte detalii in functie de email
                if(task.isSuccessful()){
                    Toast.makeText(SingUpActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(SingUpActivity.this,"Could not register, please try again",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void openUserProfilActivity() {
        Intent intent=new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }

    public void onClickLogIn(View view) {
        Intent intentLegaturaLogInSingUp=new Intent(this, LogInActivity.class);
        startActivity(intentLegaturaLogInSingUp);
    }
}
