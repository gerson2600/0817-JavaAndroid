package com.example.countriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CountriesActivity extends AppCompatActivity {

    private Spinner CountriesSpinner;
    private ImageView CountriesImage;
    private TextView CountriesName;
    private TextView CountriesCapital;
    private TextView CountriesPopulation;
    private TextView CountriesArea;
    private TextView CountriesCurrency;

    private int[] CountryImages = new int[]{R.drawable.china, R.drawable.england, R.drawable.germany, R.drawable.japan, R.drawable.russia};
    private String[] CountryNames = new String[]{"China","England","Germany","Japan","Russia"};
    private String[] CountryCapitals = new String[]{"Shanghai","London","Berlin","Tokyo","Moscow"};
    private String[] CountryPopulations = new String[]{"1,400,000,000","56,000,000","83,000,000","125,000,000","146,000,000"};
    private String[] CountryAreas = new String[]{"9,596,961 km2","130,279 km2","357,022 km2","377,975 km2","17,098,246 km2"};
    private String[] CountryCurrencies = new String[]{"Renminbi (Yuan, ¥)","Pound Sterling (GBP; £)","Euro (EUR, €)","Japanese Yen (Yen, ¥)","Russian Ruble (RUB, ₽)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        CountriesSpinner = findViewById(R.id.CountriesSpinner);
        CountriesImage = findViewById(R.id.ImgViewCountries);
        CountriesName = findViewById(R.id.TxtCountryName);
        CountriesCapital = findViewById(R.id.TxtCountryCapital);
        CountriesPopulation = findViewById(R.id.TxtCountryPopulation);
        CountriesArea = findViewById(R.id.TxtCountryArea);
        CountriesCurrency = findViewById(R.id.TxtCountryCurrency);

        ArrayAdapter<String> CountriesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, CountryNames);
        CountriesSpinner.setAdapter(CountriesAdapter);
        CountriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                CountriesImage.setImageResource(CountryImages[pos]);
                CountriesName.setText(getString(R.string.CountriesNameVar) + CountryNames[pos]);
                CountriesCapital.setText(getString(R.string.CountriesCapitalVar) + CountryCapitals[pos]);
                CountriesPopulation.setText(getString(R.string.CountriesPopulationVar) + CountryPopulations[pos]);
                CountriesArea.setText(getString(R.string.CountriesAreaVar) + CountryAreas[pos]);
                CountriesCurrency.setText(getString(R.string.CountriesCurrencyVar) + CountryCurrencies[pos]);

                showInfo(view);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //When nothing is selected, i.e. sample picture or data
            }
        });


    }

    private void showInfo(View view) {
        String CountryName = (String) CountriesSpinner.getSelectedItem();
        Toast.makeText(this, "Country Selected: " + CountryName, Toast.LENGTH_SHORT).show();
    }

    public void ExitApp(View view)
    {
        finish();
    }
}