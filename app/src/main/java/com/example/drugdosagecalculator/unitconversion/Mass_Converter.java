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

import java.text.DecimalFormat;

public class Mass_Converter extends AppCompatActivity {

    Spinner unitWeight,resultunitWeight;
    EditText getWeight;
    TextView resultWeight,errorWeight,tv1,tv2,tv3;
    Button calculate,reset_btn;
    float result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass__converter);
        unitWeight = findViewById(R.id.tablets_unit);
        String[] unit = new String[]{"Select Unit","kg","g","mg","mcg","Lbs"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit);
        unitWeight.setAdapter(adapter);

        resultunitWeight = findViewById(R.id.result_spinner);
        String[] unit2 = new String[]{"kg","g","mg","mcg","Lbs"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit2);
        resultunitWeight.setAdapter(adapter2);

        getWeight = findViewById(R.id.weight);

        resultWeight = findViewById(R.id.result_Weight);

        calculate = findViewById(R.id.calculate);
        reset_btn = findViewById(R.id.reset_btn);

        errorWeight = findViewById(R.id.weight_error);

        tv1 = findViewById(R.id.textView3);
        tv2 = findViewById(R.id.textView4);
        tv3 = findViewById(R.id.textView6);

        DecimalFormat num = new DecimalFormat("0.0000000000");

        Animation animShake = AnimationUtils.loadAnimation(Mass_Converter.this, R.anim.shake);

        calculate.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String weight = getWeight.getText().toString().trim();

                final String UNITweight = unitWeight.getSelectedItem().toString().trim();
                final String UNITRESULTweight = resultunitWeight.getSelectedItem().toString().trim();

                if(weight.isEmpty()){
                    errorWeight.setVisibility(View.VISIBLE);
                    errorWeight.startAnimation(animShake);
                    result = 0;
                    resultWeight.setText(num.format(result) +" " + UNITRESULTweight);
                }

                if(UNITweight == "Select Unit"){
                    Toast.makeText(Mass_Converter.this, "Select Weight Unit", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(UNITweight != "Select Unit" && !weight.isEmpty() ){

                    float getWeight = Float.parseFloat(weight);

                    if(UNITweight == "kg"){
                        if(UNITRESULTweight == "kg"){
                            result = getWeight * 1;
                        }
                        if(UNITRESULTweight == "g"){
                            result = getWeight * 1000;
                        }
                        if(UNITRESULTweight == "mg"){
                            result = getWeight * 1000000;
                        }
                        if(UNITRESULTweight == "mcg"){
                            result = getWeight * 1000000000 ;
                        }
                        if(UNITRESULTweight == "Lbs"){
                            result = (float) (getWeight * 2.205);
                        }
                    }
                    if(UNITweight == "g"){
                        if(UNITRESULTweight == "g"){
                            result = getWeight * 1;
                        }
                        if(UNITRESULTweight == "kg"){
                            result = getWeight / 1000;
                        }
                        if(UNITRESULTweight == "mg"){
                            result = getWeight * 1000;
                        }
                        if(UNITRESULTweight == "mcg"){
                            result = getWeight * 1000000 ;
                        }
                        if(UNITRESULTweight == "Lbs"){
                            result = (float) (getWeight / 454);
                        }
                    }

                    if(UNITweight == "mg"){
                        if(UNITRESULTweight == "mg"){
                            result = getWeight * 1;
                        }
                        if(UNITRESULTweight == "kg"){
                            result = getWeight / 1000000;
                        }
                        if(UNITRESULTweight == "g"){
                            result = getWeight / 1000;
                        }
                        if(UNITRESULTweight == "mcg"){
                            result = getWeight * 1000 ;
                        }
                        if(UNITRESULTweight == "Lbs"){
                            result = (float) (getWeight / 453592);
                        }
                    }
                    if(UNITweight == "mcg"){
                        if(UNITRESULTweight == "mcg"){
                            result = getWeight * 1;
                        }
                        if(UNITRESULTweight == "kg"){
                            result = getWeight / 1000000000;
                        }
                        if(UNITRESULTweight == "g"){
                            result = getWeight / 1000000;
                        }
                        if(UNITRESULTweight == "mg"){
                            result = getWeight / 1000 ;
                        }
                        if(UNITRESULTweight == "Lbs"){
                            result = (float) (getWeight / 453592370 );
                        }
                    }
                    if(UNITweight == "Lbs"){
                        if(UNITRESULTweight == "Lbs"){
                            result = getWeight * 1;
                        }
                        if(UNITRESULTweight == "kg"){
                            result = (float) (getWeight / 2.205);
                        }
                        if(UNITRESULTweight == "g"){
                            result = getWeight / 454;
                        }
                        if(UNITRESULTweight == "mg"){
                            result = getWeight / 453592 ;
                        }
                        if(UNITRESULTweight == "mcg"){
                            result = (float) (getWeight / 453592370 );
                        }
                    }
                }
                resultWeight.setText(num.format(result) +" " + UNITRESULTweight);

                if(result != 0){
                    errorWeight.setVisibility(View.INVISIBLE);
                }
            }
        }));

        reset_btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!getWeight.getText().toString().isEmpty()){
                    getWeight.setText("");
                    resultWeight.setText("");
                    Toast.makeText(Mass_Converter.this, "All Cells are Reset", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(Mass_Converter.this, "Nothing To Clear", Toast.LENGTH_SHORT).show();
                }
            }
        }));

    }
}