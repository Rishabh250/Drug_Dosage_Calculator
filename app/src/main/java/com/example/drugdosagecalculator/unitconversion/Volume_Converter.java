package com.example.drugdosagecalculator.unitconversion;

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

import com.example.drugdosagecalculator.R;
import com.example.drugdosagecalculator.volume_of_liquid;

import java.text.DecimalFormat;

public class Volume_Converter extends AppCompatActivity {

    Spinner unitLiter;
    EditText getLiter,ss,sv;
    TextView resultML,errorliter,tv1,tv2,tv3;
    Button calculate,reset_btn;
    float result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.drugdosagecalculator.R.layout.activity_volume__converter);
        unitLiter = findViewById(R.id.tablets_unit);
        String[] unit = new String[]{"Liter"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit);
        unitLiter.setAdapter(adapter);

        getLiter = findViewById(R.id.lenght);

        resultML = findViewById(R.id.desiredDosage);

        calculate = findViewById(R.id.calculate);
        reset_btn = findViewById(R.id.reset_btn);

        errorliter = findViewById(R.id.requiredDosage_error);

        tv1 = findViewById(R.id.textView3);
        tv2 = findViewById(R.id.textView4);
        tv3 = findViewById(R.id.textView6);

        DecimalFormat num = new DecimalFormat("0.00");

        Animation animShake = AnimationUtils.loadAnimation(Volume_Converter.this, R.anim.shake);

        calculate.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rdosage = getLiter.getText().toString().trim();

                final String liter = unitLiter.getSelectedItem().toString().trim();

                if(rdosage.isEmpty()){
                    errorliter.setVisibility(View.VISIBLE);
                    errorliter.startAnimation(animShake);
                    result = 0;
                    resultML.setText(num.format(result) + " ml");
                }

                if(liter == "Select Unit"){
                    Toast.makeText(Volume_Converter.this, "Select Requried Dosage Unit", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(liter != "Select Unit" && !rdosage.isEmpty() ){

                    float getLiter = Float.parseFloat(rdosage);

                    if(liter != "" ){
                        result = (getLiter*1000);
                    }
                }
                resultML.setText(num.format(result) + " ml");

                if(result != 0){
                    errorliter.setVisibility(View.INVISIBLE);
                }
            }
        }));

        reset_btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!getLiter.getText().toString().isEmpty()){
                    getLiter.setText("");
                    resultML.setText("");
                    Toast.makeText(Volume_Converter.this, "All Cells are Reset", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(Volume_Converter.this, "Nothing To Clear", Toast.LENGTH_SHORT).show();
                }
            }
        }));

    }
}