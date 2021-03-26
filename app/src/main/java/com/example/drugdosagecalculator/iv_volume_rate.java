package com.example.drugdosagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class iv_volume_rate extends AppCompatActivity {

    Spinner unitRD,SS;
    EditText rd,ss;
    TextView dd,errorRD,tv1,tv2,errorSS;
    Button calculate,reset_btn;
    float result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iv_volume_rate);

        unitRD = findViewById(R.id.tablets_unit);
        String[] unit = new String[]{"ml"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit);
        unitRD.setAdapter(adapter);

        SS = findViewById(R.id.tablets_unit2);
        String[] unit01 = new String[]{"Select Time","hours","min"};
        ArrayAdapter<String> adapter01 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit01);
        SS.setAdapter(adapter01);

        rd = findViewById(R.id.requiredDosage);
        ss = findViewById(R.id.stockStrength);
        dd = findViewById(R.id.desiredDosage);
        calculate = findViewById(R.id.calculate);
        reset_btn = findViewById(R.id.reset_btn);

        errorRD = findViewById(R.id.requiredDosage_error);
        errorSS = findViewById(R.id.stockStrength_error);
        tv1 = findViewById(R.id.textView3);
        tv2 = findViewById(R.id.textView4);

        DecimalFormat num = new DecimalFormat(".00");

        Animation animShake = AnimationUtils.loadAnimation(iv_volume_rate.this, R.anim.shake);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rdosage = rd.getText().toString().trim();
                String ssdosage = ss.getText().toString().trim();
                final String unitrd = unitRD.getSelectedItem().toString().trim();
                final String unitss = SS.getSelectedItem().toString().trim();

                if(rdosage.isEmpty()){
                    errorRD.setVisibility(View.VISIBLE);
                    errorRD.startAnimation(animShake);
                    result = 0;
                    dd.setText(num.format(result) + " Tablet");
                }

                if(ssdosage.isEmpty()){
                    errorSS.setVisibility(View.VISIBLE);
                    errorSS.startAnimation(animShake);
                    result = 0;
                    dd.setText(num.format(result) + " Tablet");
                }

                if(unitrd == "Select Unit"){
                    Toast.makeText(iv_volume_rate.this, "Select Requried Dosage Unit", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(unitss == "Select Unit"){
                    Toast.makeText(iv_volume_rate.this, "Select Stock Strength Unit", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(unitrd != "Select Unit" && unitss != "Select Unit" && !rdosage.isEmpty() && !ssdosage.isEmpty()){

                    float getRD = Float.parseFloat(rdosage);
                    float getSS = Float.parseFloat(ssdosage);

                    if(unitss == "min"){
                        getSS = getSS / 60
                        ;
                    }

                    if(unitrd != "" && unitss != ""){
                        result = getRD/getSS;
                    }
                }
                dd.setText(num.format(result) + " Tablet");
                if(result != 0){
                    tv1.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                    errorRD.setVisibility(View.INVISIBLE);
                    errorSS.setVisibility(View.INVISIBLE);
                }

            }
        });

        reset_btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rd.getText().toString().isEmpty() || !ss.getText().toString().isEmpty()){
                    rd.setText("");
                    ss.setText("");
                    dd.setText("");
                    Toast.makeText(iv_volume_rate.this, "All Cells are Reset", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(iv_volume_rate.this, "Nothing To Clear", Toast.LENGTH_SHORT).show();
                }
            }
        }));

    }
}