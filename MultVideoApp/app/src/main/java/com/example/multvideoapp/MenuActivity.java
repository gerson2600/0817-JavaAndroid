package com.example.multvideoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button MusicRelated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        MusicRelated = findViewById(R.id.BtnMusicVids);

    }

    public void OpenMusicVids(View v)
    {
        Intent IntentMusicVids = new Intent(MenuActivity.this, MusicVidsActivity.class);
        startActivity(IntentMusicVids);
    }

    public void OpenCarVids(View v)
    {
        Intent IntentCarVids = new Intent(MenuActivity.this, CarVidsActivity.class);
        startActivity(IntentCarVids);
    }

    public void OpenTechVids(View v)
    {
        Intent IntentTechVids = new Intent(MenuActivity.this, TechVidsActivity.class);
        startActivity(IntentTechVids);
    }
}