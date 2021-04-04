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
import com.example.drugdosagecalculator.formula_examples.example_forivdr;

public class IV_drop_rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_v_drop_rate);
    }
    public void open_example(View view) {
        startActivity(new Intent(IV_drop_rate.this, example_forivdr.class));
        Animatoo.animateFade(IV_drop_rate.this);
    }
    public void back(View view) {
        startActivity(new Intent(IV_drop_rate.this, Formula_And_Examples.class));
        Animatoo.animateFade(IV_drop_rate.this);
    }
}