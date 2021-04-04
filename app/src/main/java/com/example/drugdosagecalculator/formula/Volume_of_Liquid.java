package com.example.drugdosagecalculator.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.drugdosagecalculator.Formula_And_Examples;
import com.example.drugdosagecalculator.MainActivity;
import com.example.drugdosagecalculator.R;
import com.example.drugdosagecalculator.formula_examples.example_for_VL;
import com.example.drugdosagecalculator.formula_examples.example_for_VR;

public class Volume_of_Liquid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_of__liquid);
    }
    public void open_example(View view) {
        startActivity(new Intent(Volume_of_Liquid.this, example_for_VL.class));
        Animatoo.animateFade(Volume_of_Liquid.this);
    }

    public void back(View view) {
        startActivity(new Intent(Volume_of_Liquid.this, Formula_And_Examples.class));
        Animatoo.animateFade(Volume_of_Liquid.this);
    }
}