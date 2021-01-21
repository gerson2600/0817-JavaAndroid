package com.example.multvideoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TechVidsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_vids);
    }


    public void OpenIrisVid(View v)
    {
        Intent IntentIrisVid = new Intent(TechVidsActivity.this, VideoPlayerActivity.class);
        IntentIrisVid.putExtra("VidName", "iris_window");
        startActivity(IntentIrisVid);
    }
    public void OpenCryEngineVid(View v)
    {
        Intent IntentCryEngineVid = new Intent(TechVidsActivity.this, VideoPlayerActivity.class);
        IntentCryEngineVid.putExtra("VidName", "cryengine3");
        startActivity(IntentCryEngineVid);
    }



    public void ReturnMenuTechVids(View v)
    {
        Intent IntentTechReturn = new Intent(TechVidsActivity.this, MenuActivity.class);
        startActivity(IntentTechReturn);
    }
}