package com.example.drugdosagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button tablets,vl,ivR,ivDrop,uc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablets = findViewById(R.id.number_of_tablets);
        vl = findViewById(R.id.volume_of_liquid);
        ivR = findViewById(R.id.iv_volume_rate);
        ivDrop = findViewById(R.id.iv_drop_rate);
        uc = findViewById(R.id.unit_conversion);

        tablets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,number_of_tablets.class));
            }
        });

        vl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,volume_of_liquid.class));
            }
        });

        ivR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,iv_volume_rate.class));
            }
        });

        ivDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,iv_volume_drop_rate.class));
            }
        });

        uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,unit_conversion.class));
            }
        });
    }
}