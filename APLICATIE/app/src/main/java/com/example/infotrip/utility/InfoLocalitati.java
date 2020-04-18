package com.example.infotrip.utility;

import android.os.AsyncTask;
import android.util.Log;

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

public class  InfoLocalitati extends AsyncTask<String,Void,String>
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

            JSONObject jsonObject=new JSONObject(stringBuilder.toString());
            JSONArray result = jsonObject.getJSONArray(strings[1]);

            for(int i=0;i<result.length();i++){
                JSONObject obj=(JSONObject)result.get(i);
                rezultat.append("\n");
                rezultat.append("#");
                rezultat.append(obj.getString("name"));
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


