package com.example.drugdosagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.drugdosagecalculator.unitconversion.Length_converter;
import com.example.drugdosagecalculator.unitconversion.Mass_Converter;
import com.example.drugdosagecalculator.unitconversion.Volume_Converter;

public class unit_conversion extends AppCompatActivity {

    Button volume,mass,Length;
    ImageButton back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_conversion);
        volume = findViewById(R.id.open_volume);
        mass = findViewById(R.id.open_mass);
        Length = findViewById(R.id.open_lenght);
        back = findViewById(R.id.imageButtonIN_UC);

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit_conversion.this, Volume_Converter.class));
                Animatoo.animateFade(unit_conversion.this);
                finish();
            }
        });

        mass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit_conversion.this, Mass_Converter.class));
                Animatoo.animateFade(unit_conversion.this);
                finish();
            }
        });

        Length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit_conversion.this, Length_converter.class));
                Animatoo.animateFade(unit_conversion.this);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit_conversion.this,MainActivity.class));
                Animatoo.animateFade(unit_conversion.this);
                finish();
            }
        });

    }
}