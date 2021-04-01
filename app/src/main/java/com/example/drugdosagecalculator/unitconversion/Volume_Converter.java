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
import com.example.drugdosagecalculator.volume_of_liquid;

import java.text.DecimalFormat;

public class Volume_Converter extends AppCompatActivity {

    Spinner from,to;
    EditText getVolume;
    TextView getResult,errorgetUnit01,tv1,tv2,tv3;
    Button calculate,reset_btn;
    float result = 0;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.drugdosagecalculator.R.layout.activity_volume__converter);
        
        from = findViewById(R.id.tablets_unit);
        String[] unit = new String[]{"Select Unit","l","ml"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit);
        from.setAdapter(adapter);
        
        to = findViewById(R.id.result_spinner);
        String[] unit2 = new String[]{"l","ml"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit2);
        to.setAdapter(adapter2);

        getVolume = findViewById(R.id.volume);
        calculate = findViewById(R.id.calculate);
        reset_btn = findViewById(R.id.reset_btn);

        errorgetUnit01 = findViewById(R.id.volume_error);

        getResult = findViewById(R.id.VC_Result);

        tv1 = findViewById(R.id.textView3);
        tv2 = findViewById(R.id.textView4);
        tv3 = findViewById(R.id.textView6);

        back = findViewById(R.id.back_btn_VC);
        DecimalFormat num = new DecimalFormat("0.0");
        DecimalFormat num2= new DecimalFormat("0.000");

        Animation animShake = AnimationUtils.loadAnimation(Volume_Converter.this, R.anim.shake);

        calculate.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String vol = getVolume.getText().toString().trim();

                final String getUnit01 = from.getSelectedItem().toString().trim();
                final String getUnit02 = to.getSelectedItem().toString().trim();

                if(vol.isEmpty()){
                    errorgetUnit01.setVisibility(View.VISIBLE);
                    errorgetUnit01.startAnimation(animShake);
                    result = 0;
                    getResult.setText(num.format(result) + " "+getUnit02);
                }

                if(getUnit01 == "Select Unit"){
                    Toast.makeText(Volume_Converter.this, "Select Unit", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(getUnit01 != "Select Unit" && !vol.isEmpty() ){

                    float getVolume = Float.parseFloat(vol);

                    if(getUnit01 == "l" ){
                        if(getUnit02 == "l"){
                            result = getVolume * 1;
                            getResult.setText(num.format(result) + " "+getUnit02);
                        }
                        if(getUnit02 == "ml"){
                            result = getVolume * 1000;
                            getResult.setText(num.format(result) + " "+ getUnit02);
                        }
                    }

                    if(getUnit01 == "ml" ){
                        if(getUnit02 == "l"){
                            result = getVolume / 1000;
                            getResult.setText(num2.format(result) + " "+ getUnit02);
                        }
                        if(getUnit02 == "ml"){
                            result = getVolume * 1;
                            getResult.setText(num.format(result) + " "+ getUnit02);
                        }
                    }
                }

                if(result != 0){
                    errorgetUnit01.setVisibility(View.INVISIBLE);
                }
            }
        }));

        reset_btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!getVolume.getText().toString().isEmpty()){
                    getVolume.setText("");
                    getResult.setText("");
                    Toast.makeText(Volume_Converter.this, "All Cells are Reset", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(Volume_Converter.this, "Nothing To Clear", Toast.LENGTH_SHORT).show();
                }
            }
        }));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Volume_Converter.this, unit_conversion.class));
                Animatoo.animateFade(Volume_Converter.this);
                finish();
            }
        });

    }
}