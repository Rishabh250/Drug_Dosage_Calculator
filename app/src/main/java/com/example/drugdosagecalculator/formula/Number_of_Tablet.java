package com.example.drugdosagecalculator.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.drugdosagecalculator.Formula_And_Examples;
import com.example.drugdosagecalculator.MainActivity;
import com.example.drugdosagecalculator.R;
import com.example.drugdosagecalculator.formula_examples.example_for_NT;

public class Number_of_Tablet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_of__tablet);
    }

    public void open_example(View view) {
        startActivity(new Intent(Number_of_Tablet.this, example_for_NT.class));
        Animatoo.animateFade(Number_of_Tablet.this);
    }

    public void back(View view) {
            startActivity(new Intent(Number_of_Tablet.this, Formula_And_Examples.class));
        Animatoo.animateFade(Number_of_Tablet.this);
    }
}