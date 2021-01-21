package com.example.appcars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CarsDisplayActivity extends AppCompatActivity {

    private Spinner CarSpinner;
    private ImageView CarImage;
    private TextView CarText;

    private String[] CarData = new String[]{"BMW", "Ferrari", "Mercedes", "Porsche"};
    private int[] CarPictures = new int[]{R.drawable.bmw2, R.drawable.ferrari2, R.drawable.mercedes2, R.drawable.porche2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_display);

        CarSpinner = findViewById(R.id.SpinnerCars);
        CarImage = findViewById(R.id.ImgViewCars);
        CarText = findViewById(R.id.TxtCarName);


        ArrayAdapter<String> CarAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, CarData);
        CarSpinner.setAdapter(CarAdapter);
        CarSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                CarImage.setImageResource(CarPictures[pos]);
                CarText.setText(CarData[pos]);
                showInfo(view);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Event when nothing is selected, for example a standard picture
            }
        });





    }

    private void showInfo(View view)
    {
        String Name = (String) CarSpinner.getSelectedItem();
        Toast.makeText(this,"Brand: " + Name, Toast.LENGTH_SHORT).show();
    }
}