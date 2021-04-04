package com.example.drugdosagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class iv_volume_rate extends AppCompatActivity {

    Spinner unitRD,unitTime;
    EditText rd,time;
    TextView dd,errorRD,tv1,tv2,errortime;
    Button calculate,reset_btn;
    float result = 0;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iv_volume_rate);

        unitRD = findViewById(R.id.tablets_unit);
        String[] unit = new String[]{"ml","l"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit);
        unitRD.setAdapter(adapter);

        unitTime = findViewById(R.id.tablets_unit2);
        String[] unit01 = new String[]{"Select Time","hours","min"};
        ArrayAdapter<String> adapter01 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit01);
        unitTime.setAdapter(adapter01);

        rd = findViewById(R.id.VR_Infusion);
        time = findViewById(R.id.VR_Time);
        dd = findViewById(R.id.desiredDosage);
        calculate = findViewById(R.id.calculate);
        reset_btn = findViewById(R.id.reset_btn);

        errorRD = findViewById(R.id.VR_Infusion_error);
        errortime = findViewById(R.id.VR_Time_error);
        tv1 = findViewById(R.id.textView3);
        tv2 = findViewById(R.id.textView4);

        back = findViewById(R.id.back_btn_vr);

        DecimalFormat num = new DecimalFormat("0.00");

        Animation animShake = AnimationUtils.loadAnimation(iv_volume_rate.this, R.anim.shake);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rdosage = rd.getText().toString().trim();
                String timedosage = time.getText().toString().trim();
                final String unitrd = unitRD.getSelectedItem().toString().trim();
                final String unitunitTime = unitTime.getSelectedItem().toString().trim();

                if(rdosage.isEmpty()||timedosage.isEmpty()) {
                    if (rdosage.isEmpty()) {
                        errorRD.setVisibility(View.VISIBLE);
                        errorRD.startAnimation(animShake);
                        result = 0;
                        dd.setText(num.format(result) + " ml/hour");
                    }

                    if (timedosage.isEmpty()) {
                        errortime.setVisibility(View.VISIBLE);
                        errortime.startAnimation(animShake);
                        result = 0;
                        dd.setText(num.format(result) + " ml/hour");
                    }
                    return;
                }
                if(unitunitTime == "Select Time"){
                    Toast.makeText(iv_volume_rate.this, "Select Time", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(unitunitTime != "Select Time" || !rdosage.isEmpty() || !timedosage.isEmpty()){

                    float getRD = Float.parseFloat(rdosage);
                    float getTime = Float.parseFloat(timedosage);

                    if(unitunitTime == "min"){
                        getTime = getTime / 60
                        ;
                    }

                    if(unitrd == "l"){
                        getRD = getRD * 1000;
                    }

                    if(unitrd != "" && unitunitTime != ""){
                        result = getRD/getTime;
                    }
                }
                dd.setText(num.format(result) + " ml/hour");
                if(result != 0){
                    tv1.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                    errorRD.setVisibility(View.INVISIBLE);
                    errortime.setVisibility(View.INVISIBLE);
                }

            }
        });

        reset_btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rd.getText().toString().isEmpty() || !time.getText().toString().isEmpty()){
                    rd.setText("");
                    time.setText("");
                    dd.setText("");
                    Toast.makeText(iv_volume_rate.this, "All Cells are Reset", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(iv_volume_rate.this, "Nothing To Clear", Toast.LENGTH_SHORT).show();
                }
            }
        }));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(iv_volume_rate.this,MainActivity.class));
                Animatoo.animateFade(iv_volume_rate.this);
                finish();
            }
        });

    }
}