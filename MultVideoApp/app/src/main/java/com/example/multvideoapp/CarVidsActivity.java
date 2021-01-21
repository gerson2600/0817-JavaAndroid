package com.example.multvideoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarVidsActivity extends AppCompatActivity {

    Button HappyMiata;

    Button ReturnCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_vids);

        HappyMiata = findViewById(R.id.BtnHappyMiata);

        ReturnCars = findViewById(R.id.BtnCarReturn);

    }



    public void OpenHappyMiataVid(View v)
    {
        Intent IntentHappyMiataVid = new Intent(CarVidsActivity.this, VideoPlayerActivity.class);
        IntentHappyMiataVid.putExtra("VidName", "happy_miatas");
        startActivity(IntentHappyMiataVid);
    }

    public void OpenScaniaVid(View v)
    {
        Intent IntentScaniaBrakeVid = new Intent(CarVidsActivity.this, VideoPlayerActivity.class);
        IntentScaniaBrakeVid.putExtra("VidName", "scaniabrake");
        startActivity(IntentScaniaBrakeVid);
    }


    public void ReturnMenuCarVids(View v)
    {
        Intent IntentCarReturn = new Intent(CarVidsActivity.this, MenuActivity.class);
        startActivity(IntentCarReturn);
    }
}