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

public class volume_of_liquid extends AppCompatActivity {

    Spinner unitRD,SS,SV;
    EditText rd,ss,sv;
    TextView dd,errorRD,tv1,tv2,tv3,errorSS,errorSV;
    Button calculate,reset_btn;
    float result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_of_liquid);
        unitRD = findViewById(R.id.tablets_unit);
        String[] unit = new String[]{"Select Unit", "mg", "g", "mcg"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit);
        unitRD.setAdapter(adapter);

        SV = findViewById(R.id.tablets_unit3);
        String[] unit02 = new String[]{"ml"};
        ArrayAdapter<String> adapter02 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit02);
        SV.setAdapter(adapter02);

        SS = findViewById(R.id.tablets_unit2);
        String[] unit01 = new String[]{"Select Unit", "mg", "g", "mcg"};
        ArrayAdapter<String> adapter01 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit01);
        SS.setAdapter(adapter01);

        rd = findViewById(R.id.requiredDosage);
        ss = findViewById(R.id.stockStrength);
        dd = findViewById(R.id.desiredDosage);
        sv = findViewById(R.id.stockVolume);
        calculate = findViewById(R.id.calculate);
        reset_btn = findViewById(R.id.reset_btn);

        errorRD = findViewById(R.id.requiredDosage_error);
        errorSS = findViewById(R.id.stockStrength_error);
        errorSV = findViewById(R.id.stockVolume_error);
        tv1 = findViewById(R.id.textView3);
        tv2 = findViewById(R.id.textView4);
        tv3 = findViewById(R.id.textView6);
        Animation animShake = AnimationUtils.loadAnimation(volume_of_liquid.this, R.anim.shake);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rdosage = rd.getText().toString().trim();
                String ssdosage = ss.getText().toString().trim();
                String svolume = sv.getText().toString().trim();
                final String unitrd = unitRD.getSelectedItem().toString().trim();
                final String unitss = SS.getSelectedItem().toString().trim();

                if(rdosage.isEmpty()){
                    errorRD.setVisibility(View.VISIBLE);
                    errorRD.startAnimation(animShake);
                    result = 0;
                    dd.setText(result + " ml");
                }

                if(ssdosage.isEmpty()){
                    errorSS.setVisibility(View.VISIBLE);
                    errorSS.startAnimation(animShake);
                    result = 0;
                    dd.setText(result + " ml");
                }

                if(svolume.isEmpty()){
                    errorSV.setVisibility(View.VISIBLE);
                    errorSV.startAnimation(animShake);
                    result = 0;
                    dd.setText(result + " ml");
                }

                if(unitrd == "Select Unit"){
                    Toast.makeText(volume_of_liquid.this, "Select Requried Dosage Unit", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(unitss == "Select Unit"){
                    Toast.makeText(volume_of_liquid.this, "Select Stock Strength Unit", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(unitrd != "Select Unit" && unitss != "Select Unit" && !rdosage.isEmpty() && !ssdosage.isEmpty() && !svolume.isEmpty()){

                    float getRD = Float.parseFloat(rdosage);
                    float getSS = Float.parseFloat(ssdosage);
                    float getSV = Float.parseFloat(svolume);

                    if(unitrd == "g"){
                        getRD = getRD * 1000;
                    }
                    if(unitrd == "mcg"){
                        getRD = getRD / 1000;
                    }

                    if(unitss == "g"){
                        getSS = getSS * 1000;
                    }
                    if(unitss == "mcg"){
                        getSS = getSS / 1000;
                    }

                    if(unitrd != "" && unitss != ""){
                        result = (getRD/getSS)*getSV;
                    }
                }
                dd.setText(result + " ml");

                if(result != 0){
                    errorRD.setVisibility(View.INVISIBLE);
                    errorSS.setVisibility(View.INVISIBLE);
                    errorSV.setVisibility(View.INVISIBLE);
                }

            }
        });

        reset_btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rd.getText().toString().isEmpty() || !ss.getText().toString().isEmpty() || !sv.getText().toString().isEmpty()){
                    rd.setText("");
                    ss.setText("");
                    sv.setText("");
                    dd.setText("");
                    Toast.makeText(volume_of_liquid.this, "All Cells are Reset", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(volume_of_liquid.this, "Nothing To Clear", Toast.LENGTH_SHORT).show();
                }
            }
        }));

    }
}