package com.example.conversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CurrenciesActivity extends AppCompatActivity {

    EditText CurrencyEuro;
    TextView CurrencyDollar;
    TextView CurrencyReal;
    TextView CurrencyPound;
    TextView CurrencyFranc;

    Button ConvertCurrencies;
    Button ReturnCurrencies;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currencies);

        ConvertCurrencies = findViewById(R.id.BtnCurrenciesConvert);
        ReturnCurrencies = findViewById(R.id.BtnCurrenciesReturn);

    }

    public void CurrenciesConvert(View V)
    {

        CurrencyEuro = findViewById(R.id.TxtCurrenciesEuro);
        CurrencyDollar = findViewById(R.id.TxtCurrenciesDollars);
        CurrencyReal = findViewById(R.id.TxtCurrenciesReals);
        CurrencyPound = findViewById(R.id.TxtCurrenciesPounds);
        CurrencyFranc = findViewById(R.id.TxtCurrenciesFrancs);

        double ResultCurrencyEuro = Double.parseDouble(CurrencyEuro.getText().toString());
        CurrencyDollar.setText(ResultCurrencyEuro + "€ equals: " + ResultCurrencyEuro*1.23 + "$.");
        CurrencyReal.setText(ResultCurrencyEuro + "€ equals: " + ResultCurrencyEuro*6.52 + "R$.");
        CurrencyPound.setText(ResultCurrencyEuro + "€ equals: " + ResultCurrencyEuro*0.90 + "£.");
        CurrencyFranc.setText(ResultCurrencyEuro + "€ equals: " + ResultCurrencyEuro*1.08 + "Fr.");



    }




    public void CurrenciesReturn(View v)
    {
        Intent i = new Intent(CurrenciesActivity.this, MenuActivity.class);
        startActivity(i);
    }
}