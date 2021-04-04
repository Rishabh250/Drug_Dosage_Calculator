package com.example.drugdosagecalculator.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.drugdosagecalculator.Formula_And_Examples;
import com.example.drugdosagecalculator.MainActivity;
import com.example.drugdosagecalculator.R;
import com.example.drugdosagecalculator.formula_examples.example_for_UC;
import com.example.drugdosagecalculator.formula_examples.example_for_VL;

public class Unit_Conversion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit__conversion);
    }
    public void open_example(View view) {
        startActivity(new Intent(Unit_Conversion.this, example_for_UC.class));
        Animatoo.animateFade(Unit_Conversion.this);
    }
    public void back(View view) {
        startActivity(new Intent(Unit_Conversion.this, Formula_And_Examples.class));
        Animatoo.animateFade(Unit_Conversion.this);
    }
}