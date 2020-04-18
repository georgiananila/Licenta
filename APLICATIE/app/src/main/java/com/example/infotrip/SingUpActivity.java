package com.example.infotrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

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
                openUserProfilActivity();
            }
        });
        spinnerTara=(Spinner)findViewById(R.id.spinnerSingUpActivityTara);



        cauta();
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
