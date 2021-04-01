package com.example.drugdosagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.text.DecimalFormat;

public class number_of_tablets extends AppCompatActivity {

    Spinner unitRD,SS;
    EditText rd,ss;
    TextView dd,errorRD,tv1,tv2,errorSS;
    Button calculate,reset_btn;
    float result = 0;
    String text;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_of_tablets);

        unitRD = findViewById(R.id.tablets_unit);
        String[] unit = new String[]{"Select Unit", "mg", "g", "mcg"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit);
        unitRD.setAdapter(adapter);

        SS = findViewById(R.id.tablets_unit2);
        String[] unit01 = new String[]{"Select Unit", "mg", "g", "mcg"};
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
        back = findViewById(R.id.back_btn_NT);


        DecimalFormat num = new DecimalFormat("0.0");

        Animation animShake = AnimationUtils.loadAnimation(number_of_tablets.this, R.anim.shake);



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rdosage = rd.getText().toString().trim();
                String ssdosage = ss.getText().toString().trim();
                final String unitrd = unitRD.getSelectedItem().toString().trim();
                final String unitss = SS.getSelectedItem().toString().trim();

                if(rdosage.isEmpty() || ssdosage.isEmpty()) {
                    if (rdosage.isEmpty()) {
                        errorRD.setVisibility(View.VISIBLE);
                        errorRD.startAnimation(animShake);
                        result = 0;
                        dd.setText(num.format(result) + " Tablet");
                    }

                    if (ssdosage.isEmpty()) {
                        errorSS.setVisibility(View.VISIBLE);
                        errorSS.startAnimation(animShake);
                        result = 0;
                        dd.setText(num.format(result) + " Tablet");
                    }
                    return;
                }


                if(unitrd == "Select Unit"){
                    Toast.makeText(number_of_tablets.this, "Select Requried Dosage Unit", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(unitss == "Select Unit"){
                    Toast.makeText(number_of_tablets.this, "Select Stock Strength Unit", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(unitrd != "Select Unit" && unitss != "Select Unit" && !rdosage.isEmpty() && !ssdosage.isEmpty()){

                    float getRD = Float.parseFloat(rdosage);
                    float getSS = Float.parseFloat(ssdosage);

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
                        result = getRD/getSS;
                    }

                    if(result > 1){
                        text = "Tablets";
                    }
                    else{
                        text = "Tablet";
                    }
                }
                dd.setText(num.format(result) + " "+ text);

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
                    Toast.makeText(number_of_tablets.this, "All Cells are Reset", Toast.LENGTH_SHORT).show();
                }
                
                else{
                    Toast.makeText(number_of_tablets.this, "Nothing To Clear", Toast.LENGTH_SHORT).show();
                }
            }
        }));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(number_of_tablets.this,MainActivity.class));
                Animatoo.animateFade(number_of_tablets.this);
                finish();
            }
        });

    }
}