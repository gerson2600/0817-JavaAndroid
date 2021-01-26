package com.example.stopwatchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer Stopwatch;
    private long TimePaused = 0;
    private boolean Running;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stopwatch = findViewById(R.id.StopWatchChronometer);
        Stopwatch.setFormat("Time: %s");



    }


    public void StartStopwatch(View v)
    {
        if (!Running)
        {
            Stopwatch.setBase(SystemClock.elapsedRealtime()-TimePaused);
            Stopwatch.start();
            Running = true;
        }

    }
    public void PauseStopwatch(View v)
    {
        if (Running)
        {
            Stopwatch.stop();
            TimePaused = SystemClock.elapsedRealtime() - Stopwatch.getBase();
            Running = false;
        }

    }
    public void ResetStopwatch(View v)
    {
        Stopwatch.setBase(SystemClock.elapsedRealtime());
        TimePaused = 0;
    }
}