package com.example.conversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button Weights;
    private Button Distances;
    private Button Currencies;
    private Button Informatics;
    private Button Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Weights = findViewById(R.id.BtnWeights);
        Distances = findViewById(R.id.BtnDistances);
        Currencies = findViewById(R.id.BtnCurrencies);
        Informatics = findViewById(R.id.BtnInformatics);
        Exit = findViewById(R.id.BtnExit);

        Weights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentWeight = new Intent(MenuActivity.this, WeightsActivity.class);
                startActivity(IntentWeight);
            }
        });
        Distances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentDist = new Intent(MenuActivity.this, DistancesActivity.class);
                startActivity(IntentDist);
            }
        });
        Currencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentCurrencies = new Intent(MenuActivity.this, CurrenciesActivity.class);
                startActivity(IntentCurrencies);
            }
        });
        Informatics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentInformatics = new Intent(MenuActivity.this, InformaticsActivity.class);
                startActivity(IntentInformatics);
            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}