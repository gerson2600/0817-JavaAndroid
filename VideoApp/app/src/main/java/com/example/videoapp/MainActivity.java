package com.example.videoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import static android.media.MediaPlayer.*;

public class MainActivity extends AppCompatActivity {

    private VideoView Vid1;
    private int TimePos = 0;
    private MediaController VidControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Vid1 = findViewById(R.id.videoView);
        if (VidControl == null)
        {
            VidControl = new MediaController(MainActivity.this);
            VidControl.setAnchorView(Vid1); //Linking controllers
            Vid1.setMediaController(VidControl); //associates controller to video (play, pause, rewind, forward)
        }
        int VidId = this.GetRawResIdByName("tom_jerry"); //Function call to get video id from resources
        Vid1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + VidId));
        Vid1.requestFocus();


        Vid1.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Vid1.seekTo(TimePos);
                if(TimePos == 0){
                    Vid1.start();
                }
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        VidControl.setAnchorView(Vid1);
                    }
                });
            }
        });

    }





    public int GetRawResIdByName(String VidName)
    {
        String FileURL = this.getPackageName();
        int ResId = this.getResources().getIdentifier(VidName, "raw", FileURL);
        return ResId;
    }
}