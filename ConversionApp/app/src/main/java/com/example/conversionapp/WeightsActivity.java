package com.example.conversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import javax.xml.transform.Result;

public class WeightsActivity extends AppCompatActivity {


    EditText Kg;
    TextView Grams;
    TextView Tonnes;
    TextView Ounces;
    TextView Pounds;
    Button ConvertWeights;
    Button ReturnWeights;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weights);



        ConvertWeights = findViewById(R.id.BtnConvertWeight);
        ReturnWeights = findViewById(R.id.BtnWeightsReturn);

    }



    public void WeightsConverter(View v)
    {
        Kg = findViewById(R.id.TxtWeightKg);
        Grams = findViewById(R.id.TxtWeightGrams);
        Tonnes = findViewById(R.id.TxtWeightTonnes);
        Ounces = findViewById(R.id.TxtWeightsOunces);
        Pounds = findViewById(R.id.TxtWeightsPounds);

        Double ResultWeights = Double.parseDouble(Kg.getText().toString());
        Grams.setText(ResultWeights + " Kg equals: " + ResultWeights*1000 + " Grams.");
        Tonnes.setText(ResultWeights + " Kg equals: " + ResultWeights/1000 + " Tonnes.");
        Ounces.setText(ResultWeights + " Kg equals: " + ResultWeights*35.274 + " Ounces.");
        Pounds.setText(ResultWeights + " Kg equals: " + ResultWeights*2.205 + " Pounds.");

    }




    public void Return(View v)
    {
        Intent i = new Intent(WeightsActivity.this, MenuActivity.class);
        startActivity(i);
    }
}