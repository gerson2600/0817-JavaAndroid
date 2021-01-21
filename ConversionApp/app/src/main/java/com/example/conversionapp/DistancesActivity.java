package com.example.conversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DistancesActivity extends AppCompatActivity {

    EditText Meters;
    TextView Km;
    TextView Cm;
    TextView Feet;
    TextView Miles;
    Button Convert;
    Button Return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distances);

        Convert = findViewById(R.id.BtnDistancesConvert);
        Return = findViewById(R.id.BtnDistancesReturn);


    }

    public void Converter(View v)
    {
        Meters = findViewById(R.id.TxtMeters);
        Km = findViewById(R.id.TxtKM);
        Cm = findViewById(R.id.TxtCM);
        Feet = findViewById(R.id.TxtFeet);
        Miles = findViewById(R.id.TxtMiles);

        double ValueM = Double.parseDouble(Meters.getText().toString());
        Km.setText(ValueM+ " Meters equals: " + ValueM/1000 + " Kms");
        Cm.setText(ValueM+ " Meters equals: " + ValueM*100 + " Cms");
        Feet.setText(ValueM+ " Meters equals: " + ValueM*3.2808 + " Feet");
        Miles.setText(ValueM+ " Meters equals: " + ValueM*0.00062137 + " Miles");
    }

    public void Return(View v)
    {
        Intent i = new Intent(DistancesActivity.this, MenuActivity.class);
        startActivity(i);
    }

}