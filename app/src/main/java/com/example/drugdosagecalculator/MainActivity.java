package com.example.drugdosagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.drugdosagecalculator.formula.Number_of_Tablet;
import com.example.drugdosagecalculator.formula_examples.example_for_NT;

public class MainActivity extends AppCompatActivity {

    Button tablets,vl,ivR,ivDrop,uc,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablets = findViewById(R.id.number_of_tablets);
        vl = findViewById(R.id.volume_of_liquid);
        ivR = findViewById(R.id.iv_volume_rate);
        ivDrop = findViewById(R.id.iv_drop_rate);
        uc = findViewById(R.id.unit_conversion);
        about = findViewById(R.id.aboutANDexamples);

        tablets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, number_of_tablets.class));
                Animatoo.animateFade(MainActivity.this);
                finish();
            }
        });

        vl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,volume_of_liquid.class));
                Animatoo.animateFade(MainActivity.this);
                finish();
            }
        });

        ivR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,iv_volume_rate.class));
                Animatoo.animateFade(MainActivity.this);
                finish();
            }
        });

        ivDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, iv_volume_drop_rate.class));
                Animatoo.animateFade(MainActivity.this);
                finish();
            }
        });

        uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,unit_conversion.class));
                Animatoo.animateFade(MainActivity.this);
                finish();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Formula_And_Examples.class));
                Animatoo.animateFade(MainActivity.this);
                finish();
            }
        });
    }
}