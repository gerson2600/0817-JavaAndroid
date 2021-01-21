package com.example.multvideoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {

    private VideoView Vid1;
    private int TimePos = 0;
    private MediaController VidControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);


        Vid1 = findViewById(R.id.videoView);
        if (VidControl == null) {
            VidControl = new MediaController(VideoPlayerActivity.this);
            VidControl.setAnchorView(Vid1); //Linking controllers
            Vid1.setMediaController(VidControl); //associates controller to video (play, pause, rewind, forward)
        }

        //get video name from other activity
        Bundle extras = getIntent().getExtras();
        String VidNameImport = null;
        if (extras != null) {
            VidNameImport = extras.getString("VidName");
        }

        //Change input to string gotten from other activities
        int VidId = this.GetRawResIdByName(VidNameImport); //Function call to get video id from resources
        Vid1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + VidId));
        Vid1.requestFocus();


        Vid1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Vid1.seekTo(TimePos);
                if (TimePos == 0) {
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

    //Function to get resource ID for target video
    public int GetRawResIdByName(String VidName)
    {
        String FileURL = this.getPackageName();
        int ResId = this.getResources().getIdentifier(VidName, "raw", FileURL);
        return ResId;
    }

    //Video/Screen Rotation
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        
        //Stores current position
        savedInstanceState.putInt("CurrentPosition", Vid1.getCurrentPosition());
        Vid1.pause();
    }
    
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        
        //Get saved position
        int position = savedInstanceState.getInt("CurrentPosition");
        Vid1.seekTo(position);
    }


}