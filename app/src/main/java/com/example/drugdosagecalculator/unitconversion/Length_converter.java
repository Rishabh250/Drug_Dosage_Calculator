package com.example.drugdosagecalculator.unitconversion;

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
import com.example.drugdosagecalculator.MainActivity;
import com.example.drugdosagecalculator.R;
import com.example.drugdosagecalculator.number_of_tablets;
import com.example.drugdosagecalculator.unit_conversion;

import java.text.DecimalFormat;

public class Length_converter extends AppCompatActivity {

    Spinner unitLength,resultunitLength;
    EditText getLength;
    TextView resultLength,errorLength,tv1,tv2,tv3;
    Button calculate,reset_btn;
    float result = 0;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_converter);
        unitLength = findViewById(R.id.tablets_unit);
        String[] unit = new String[]{"Select Unit","m","cm","inches"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit);
        unitLength.setAdapter(adapter);

        resultunitLength = findViewById(R.id.result_spinner);
        String[] unit2 = new String[]{"m","cm","inches"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit2);
        resultunitLength.setAdapter(adapter2);

        getLength = findViewById(R.id.length);

        resultLength = findViewById(R.id.result_Length);

        calculate = findViewById(R.id.calculate);
        reset_btn = findViewById(R.id.reset_btn);

        errorLength = findViewById(R.id.length_error);

        tv1 = findViewById(R.id.textView3);
        tv2 = findViewById(R.id.textView4);
        tv3 = findViewById(R.id.textView6);

        back = findViewById(R.id.back_btn_LC);

        DecimalFormat num = new DecimalFormat("0.00");

        Animation animShake = AnimationUtils.loadAnimation(Length_converter.this, R.anim.shake);

        calculate.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String length = getLength.getText().toString().trim();

                final String UNITlength = unitLength.getSelectedItem().toString().trim();
                final String UNITresultLength = resultunitLength.getSelectedItem().toString().trim();

                if(length.isEmpty()){
                    errorLength.setVisibility(View.VISIBLE);
                    errorLength.startAnimation(animShake);
                    result = 0;
                    resultLength.setText(num.format(result) +" " + UNITresultLength);
                    return;
                }

                if(UNITlength == "Select Unit"){
                    Toast.makeText(Length_converter.this, "Select length Unit", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(UNITlength != "Select Unit" && !length.isEmpty() ){

                    float getLength = Float.parseFloat(length);

                    if(UNITlength == "m"){
                        if(UNITresultLength == "m"){
                            result = getLength * 1;
                        }
                        if(UNITresultLength == "cm"){
                            result = getLength * 100;
                        }
                        if(UNITresultLength == "inches"){
                            result = (float) (getLength * 39.37);
                        }
                    }
                    if(UNITlength == "cm"){
                        if(UNITresultLength == "cm"){
                            result = getLength * 1;
                        }
                        if(UNITresultLength == "m"){
                            result = getLength / 100;
                        }
                        if(UNITresultLength == "inches"){
                            result = (float) (getLength / 2.54);
                        }
                    }
                    if(UNITlength == "inches"){
                        if(UNITresultLength == "inches"){
                            result = getLength * 1;
                        }
                        if(UNITresultLength == "cm"){
                            result = (float) (getLength * 2.54);
                        }
                        if(UNITresultLength == "m"){
                            result = (float) (getLength / 39.37);
                        }
                    }
                }
                resultLength.setText(num.format(result) +" " + UNITresultLength);

                if(result != 0){
                    errorLength.setVisibility(View.INVISIBLE);
                }
            }
        }));

        reset_btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!getLength.getText().toString().isEmpty()){
                    getLength.setText("");
                    resultLength.setText("");
                    Toast.makeText(Length_converter.this, "All Cells are Reset", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(Length_converter.this, "Nothing To Clear", Toast.LENGTH_SHORT).show();
                }
            }
        }));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Length_converter.this, unit_conversion.class));
                Animatoo.animateFade(Length_converter.this);
                finish();
            }
        });

    }
}