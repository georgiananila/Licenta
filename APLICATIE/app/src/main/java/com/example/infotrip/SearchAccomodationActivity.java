package com.example.infotrip;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infotrip.utility.InfoLocalitati;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;


public class SearchAccomodationActivity extends AppCompatActivity {

    private static final String TAG="SearchAccomodationActivity";
    Spinner locatie,sate;
    private TextView textView1DataIntrare,textView2DataIesire;
    private DatePickerDialog.OnDateSetListener dateSetListener1, dateSetListener2;

    int numR = 0;
    int numA=0;
    int numC=0;
    TextView textViewRooms,textViewAdults,textViewChildren;
    Button minusRoom,plusRoom,minusAdult,plusAdult,minusChild,plusChild,butonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_accomodation);

        init();

        butonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sate.getSelectedItem()==null){
                    Toast.makeText(SearchAccomodationActivity.this,"Choose a village...",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent1=new Intent(getApplicationContext(),AccomodationListActivity.class);
                    startActivity(intent1);
                }

            }
        });

        textView1DataIntrare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(SearchAccomodationActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener1,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener1=new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                Log.d(TAG,"onDateSet : date:" + year +"/"+month+"/"+dayOfMonth);

                String date=month+"/"+dayOfMonth+"/"+year;
                textView1DataIntrare.setText(date);
            }
        };

        textView2DataIesire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(SearchAccomodationActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener2,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener2=new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                Log.d(TAG,"onDateSet : mm/dd/yyyy:" + month +"/"+dayOfMonth+"/"+year);
                String date=month+"/"+dayOfMonth+"/"+year;
                textView2DataIesire.setText(date);
            }
        };

        locatie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String localitati = locatie.getSelectedItem().toString();
                if(localitati.length() > 0) {
                    searchByCounty(localitati);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    public void searchByCounty(String county){
        InfoLocalitati info=new InfoLocalitati(){
            @Override
            protected void onPostExecute(String s) {
                Log.e("DupaExec", s);
                String[] valori=s.split("#");
                ArrayList<String> list = new ArrayList<String>(Arrays.asList(valori));
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                        R.layout.spinner, R.id.txt, list);
                sate.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        };
        info.execute("https://raw.githubusercontent.com/rennokki/romania.json/master/json/regions.json", county);
    }

    public void init()
    {
        locatie=(Spinner)findViewById(R.id.spinnerforChooseAccomSearchActivity);
        sate=(Spinner)findViewById(R.id.spinner2SearchActivity);
        textView1DataIntrare=(TextView) findViewById(R.id.textViewDataInceputSearch);
        textView2DataIesire=(TextView)findViewById(R.id.textViewDataSfarsitSearch);
        textViewRooms=(TextView)findViewById(R.id.textViewnrCamere);
        textViewAdults=(TextView)findViewById(R.id.textViewnrAdulti);
        textViewChildren=(TextView)findViewById(R.id.textViewNrCopii);

        minusRoom=(Button)findViewById(R.id.buttonMINUScamere);
        minusAdult=(Button)findViewById(R.id.buttonMinusAdulti);
        minusChild=(Button)findViewById(R.id.buttonMinusNrCopii);
        plusRoom=(Button)findViewById(R.id.buttonPlusCamere);
        plusAdult=(Button)findViewById(R.id.buttonAdaugaNrAdulti);
        plusChild=(Button)findViewById(R.id.buttonPlusCopii);
        butonSearch=(Button)findViewById(R.id.buttonCautaSearchActivity);
    }

    public void addoneRooom(View v){
        numR+=1;
        TextView t = (TextView) findViewById(R.id.textViewnrCamere);
        t.setText(numR+"");
    }

    public void addoneAdult(View v){
        numA+=1;
        TextView t = (TextView) findViewById(R.id.textViewnrAdulti);
        t.setText(numA+"");
    }

    public void addoneChild(View v){
        numC+=1;
        TextView t = (TextView) findViewById(R.id.textViewNrCopii);
        t.setText(numC+"");
    }

    public void minusOneRoom(View v){
        numR-=1;
        TextView t = (TextView) findViewById(R.id.textViewnrCamere);
        t.setText(numR+"");
    }

    public void minusOneAdult(View v){
        numA-=1;
        TextView t = (TextView) findViewById(R.id.textViewnrAdulti);
        t.setText(numA+"");
    }

    public void minusOneChild(View v){
        numC-=1;
        TextView t = (TextView) findViewById(R.id.textViewNrCopii);
        t.setText(numC+"");
    }


}
