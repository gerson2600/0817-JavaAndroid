package com.example.learnenglishgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ColoursActivity extends AppCompatActivity {

    private Spinner SpColours;
    private ImageView ImageVColours;
    private TextView ColourName;
    private Button PlaySound;
    private Button ReturnColours;

    private String ColourData[] = new String[]{"Blue", "Red", "Orange", "Yellow"};
    private int ColourImages[] = new int[]{R.drawable.blue, R.drawable.red, R.drawable.orange, R.drawable.yellow};
    private int ColourSounds[] = new int[]{R.raw.blue, R.raw.red, R.raw.orange, R.raw.yellow};
    private String ColourTranslation[] = new String[]{"Azul", "Vermelho", "Cor-de-Laranja", "Amarelo"};
    private int SelectedColour = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);

        SpColours = findViewById(R.id.SpinnerColours);
        ImageVColours = findViewById(R.id.ImageViewColours);
        ColourName = findViewById(R.id.TxtColourName);
        PlaySound = findViewById(R.id.BtnPlayColours);
        ReturnColours = findViewById(R.id.BtnReturnColours);

        ArrayAdapter ColoursAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ColourData);
        SpColours.setAdapter(ColoursAdapter);
        SpColours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                SelectedColour = pos;
                ColourName.setText(ColourTranslation[pos]);
                ImageVColours.setImageResource(ColourImages[pos]);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void PlaySoundColours(View v)
    {
        MediaPlayer AudioPlayer = MediaPlayer.create(this, ColourSounds[SelectedColour]);
        AudioPlayer.start();
    }

    public void ReturnMenuColours(View v)
    {
        Intent ColourIntent = new Intent(ColoursActivity.this, MenuActivity.class);
        startActivity(ColourIntent);
    }

}