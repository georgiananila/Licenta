package com.example.infotrip.nefolosite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.example.infotrip.R;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class FilterAccomodationActivity extends AppCompatActivity {


    private Chip chipTrending,chipAlphabetic;
    private Chip chipLtoH,chipHtoL;

    private Button btnApply;
    private ArrayList<String>selectedChipData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_accomodation);

        chipTrending=(Chip)findViewById(R.id.chipTranding);
        chipAlphabetic=(Chip)findViewById(R.id.chipAlphabetic);
        chipLtoH=(Chip)findViewById(R.id.chipLowToHigh);
        chipHtoL=(Chip)findViewById(R.id.chipHightoLow);

        btnApply=(Button)findViewById(R.id.buttonAplicaFiltre);


        selectedChipData=new ArrayList<>();
        CompoundButton.OnCheckedChangeListener checkedChangeListener=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    selectedChipData.add(buttonView.getText().toString());

                }else{
                    selectedChipData.remove(buttonView.getText().toString());
                }
            }
        };

        chipTrending.setOnCheckedChangeListener(checkedChangeListener);
        chipAlphabetic.setOnCheckedChangeListener(checkedChangeListener);
        chipLtoH.setOnCheckedChangeListener(checkedChangeListener);
        chipHtoL.setOnCheckedChangeListener(checkedChangeListener);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent=new Intent();
                resultIntent.putExtra("data",selectedChipData.toString());
                setResult(101,resultIntent);
                finish();
            }
        });


    }
}
