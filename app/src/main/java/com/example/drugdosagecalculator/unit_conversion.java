package com.example.drugdosagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.drugdosagecalculator.unitconversion.Length_converter;
import com.example.drugdosagecalculator.unitconversion.Mass_Converter;
import com.example.drugdosagecalculator.unitconversion.Volume_Converter;

public class unit_conversion extends AppCompatActivity {

    Button volume,mass,Length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_conversion);
        volume = findViewById(R.id.open_volume);
        mass = findViewById(R.id.open_mass);
        Length = findViewById(R.id.open_lenght);

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit_conversion.this, Volume_Converter.class));
            }
        });

        mass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit_conversion.this, Mass_Converter.class));
            }
        });

        Length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit_conversion.this, Length_converter.class));
            }
        });

    }
}