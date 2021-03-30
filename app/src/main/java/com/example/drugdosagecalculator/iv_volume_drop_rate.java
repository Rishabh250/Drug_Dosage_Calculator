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

public class iv_volume_drop_rate extends AppCompatActivity{
        Spinner unit_volume,unit_time,unit_DropFactor;
        EditText rd,time,df;
        TextView dd,errorRD,tv1,tv2,tv3,errorunit_time,errorunit_DropFactor;
        Button calculate,reset_btn;
        float result = 0;

        @Override

        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iv_volume_drop_rate);

            unit_volume = findViewById(R.id.DR_tablets_unit);
            String[] unit = new String[]{"ml"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit);
            unit_volume.setAdapter(adapter);

            unit_DropFactor = findViewById(R.id.DR_tablets_unit3);
            String[] unit02 = new String[]{"drops/ml"};
            ArrayAdapter<String> adapter02 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit02);
            unit_DropFactor.setAdapter(adapter02);

            unit_time = findViewById(R.id.DR_tablets_unit2);
            String[] unit01 = new String[]{"Select Time","min","hour"};
            ArrayAdapter<String> adapter01 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit01);
            unit_time.setAdapter(adapter01);

            rd = findViewById(R.id.DR_volume);
            time = findViewById(R.id.DR_time);
            dd = findViewById(R.id.desiredDosage);
            df = findViewById(R.id.DR_dropFactor);
            calculate = findViewById(R.id.calculate);
            reset_btn = findViewById(R.id.reset_btn);

            errorRD = findViewById(R.id.DR_volume_error);
            errorunit_time = findViewById(R.id.DR_time_error);
            errorunit_DropFactor = findViewById(R.id.DR_dropFactor_error);
            tv1 = findViewById(R.id.textView3);
            tv2 = findViewById(R.id.textView4);
            tv3 = findViewById(R.id.textView6);

            DecimalFormat num = new DecimalFormat("0.00");

            Animation animShake = AnimationUtils.loadAnimation(iv_volume_drop_rate.this, R.anim.shake);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rdosage = rd.getText().toString().trim();
                String taketime = time.getText().toString().trim();
                String getDF = df.getText().toString().trim();
                String unitTime = unit_time.getSelectedItem().toString().trim();


                if(rdosage.isEmpty() || taketime.isEmpty() || getDF.isEmpty()){

                    if(rdosage.isEmpty()){
                        errorRD.setVisibility(View.VISIBLE);
                        errorRD.startAnimation(animShake);
                        result = 0;
                        dd.setText(num.format(result) + " drop/min");
                    }

                    if(taketime.isEmpty()){
                        errorunit_time.setVisibility(View.VISIBLE);
                        errorunit_time.startAnimation(animShake);
                        result = 0;
                        dd.setText(num.format(result) + " drop/min");
                    }
                    if(getDF.isEmpty()){
                        errorunit_DropFactor.setVisibility(View.VISIBLE);
                        errorunit_DropFactor.startAnimation(animShake);
                        result = 0;
                        dd.setText(num.format(result) + " drop/min");
                    }
                    return;
                }

                if(unitTime == "Select Time"){
                    Toast.makeText(iv_volume_drop_rate.this, "Select Time", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(unitTime != "Select Unit" && !rdosage.isEmpty() && !taketime.isEmpty() && !getDF.isEmpty()){
                    float getRD = Float.parseFloat(rdosage);
                    float getTime = Float.parseFloat(taketime);
                    float getDrop = Float.parseFloat(getDF);

                    if(unitTime == "hour"){
                        getTime = getTime * 60;
                    }

                    if(unitTime != ""){
                        result = (getRD*getDrop)/getTime;
                    }
                }
                dd.setText(num.format(result) + " drop/min");

                if(result != 0){
                    errorRD.setVisibility(View.INVISIBLE);
                    errorunit_time.setVisibility(View.INVISIBLE);
                    errorunit_DropFactor.setVisibility(View.INVISIBLE);
                }

            }
        });

        reset_btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rd.getText().toString().isEmpty() || !time.getText().toString().isEmpty() || !df.getText().toString().isEmpty()){
                    rd.setText("");
                    time.setText("");
                    df.setText("");
                    dd.setText("");
                    Toast.makeText(iv_volume_drop_rate.this, "All Cells are Reset", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(iv_volume_drop_rate.this, "Nothing To Clear", Toast.LENGTH_SHORT).show();
                }
            }
        }));

    }
    }