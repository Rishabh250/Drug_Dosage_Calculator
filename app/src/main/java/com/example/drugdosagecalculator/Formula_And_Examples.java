package com.example.drugdosagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.drugdosagecalculator.formula.IV_Volume_Rate;
import com.example.drugdosagecalculator.formula.IV_drop_rate;
import com.example.drugdosagecalculator.formula.Number_of_Tablet;
import com.example.drugdosagecalculator.formula.Unit_Conversion;
import com.example.drugdosagecalculator.formula.Volume_of_Liquid;

public class Formula_And_Examples extends AppCompatActivity {

    Button tablets,vl,ivR,ivDrop,uc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula__and__examples);

        tablets = findViewById(R.id.ex_number_of_tablets);
        vl = findViewById(R.id.ex_volume_of_liquid);
        ivR = findViewById(R.id.ex_iv_volume_rate);
        ivDrop = findViewById(R.id.ex_iv_drop_rate);
        uc = findViewById(R.id.ex_unit_conversion);
        tablets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Formula_And_Examples.this, Number_of_Tablet.class));
                Animatoo.animateFade(Formula_And_Examples.this);
                finish();
            }
        });

        vl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Formula_And_Examples.this, Volume_of_Liquid.class));
                Animatoo.animateFade(Formula_And_Examples.this);
                finish();
            }
        });

        ivR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Formula_And_Examples.this, IV_Volume_Rate.class));
                Animatoo.animateFade(Formula_And_Examples.this);
                finish();
            }
        });

        ivDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Formula_And_Examples.this, IV_drop_rate.class));
                Animatoo.animateFade(Formula_And_Examples.this);
                finish();
            }
        });

        uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Formula_And_Examples.this, Unit_Conversion.class));
                Animatoo.animateFade(Formula_And_Examples.this);
                finish();
            }
        });
    }

    public void back(View view) {
        startActivity(new Intent(Formula_And_Examples.this,MainActivity.class));
    }
}