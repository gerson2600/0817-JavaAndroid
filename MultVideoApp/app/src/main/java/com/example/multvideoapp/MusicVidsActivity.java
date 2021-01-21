package com.example.multvideoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicVidsActivity extends AppCompatActivity {

    Button MilesDavis;
    Button PianoDrop;
    Button ReturnBtnMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_vids);

        MilesDavis = findViewById(R.id.BtnMilesDavis);
        PianoDrop = findViewById(R.id.BtnPianoDrop);

        ReturnBtnMusic = findViewById(R.id.BtnMusicReturn);


    }

    public void OpenMilesDavisVid(View v)
    {
        Intent IntentMilesDavisVid = new Intent(MusicVidsActivity.this, VideoPlayerActivity.class);
        IntentMilesDavisVid.putExtra("VidName", "milesdavis_door_1");
        startActivity(IntentMilesDavisVid);
    }

    public void OpenPianoDrop(View v)
    {
        Intent IntentPianoDropVid = new Intent(MusicVidsActivity.this, VideoPlayerActivity.class);
        IntentPianoDropVid.putExtra("VidName", "pianodrop");
        startActivity(IntentPianoDropVid);
    }



    public void ReturnMenuMusicVids(View v)
    {
        Intent IntentMusicReturn = new Intent(MusicVidsActivity.this, MenuActivity.class);
        startActivity(IntentMusicReturn);
    }
}