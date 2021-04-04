package com.example.drugdosagecalculator.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.drugdosagecalculator.Formula_And_Examples;
import com.example.drugdosagecalculator.MainActivity;
import com.example.drugdosagecalculator.R;
import com.example.drugdosagecalculator.formula_examples.example_for_VR;

public class IV_Volume_Rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_v__volume__rate);
    }

    public void open_example(View view) {
        startActivity(new Intent(IV_Volume_Rate.this, example_for_VR.class));
        Animatoo.animateFade(IV_Volume_Rate.this);
    }
    public void back(View view) {
        startActivity(new Intent(IV_Volume_Rate.this, Formula_And_Examples.class));
        Animatoo.animateFade(IV_Volume_Rate.this);
    }
}