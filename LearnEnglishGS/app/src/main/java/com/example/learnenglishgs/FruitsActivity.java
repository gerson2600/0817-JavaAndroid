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

public class FruitsActivity extends AppCompatActivity {

    private Spinner SpFruits;
    private ImageView ImageVFruits;
    private TextView FruitName;
    private Button PlaySound;
    private Button ReturnFruits;

    private String FruitData[] = new String[]{"Orange", "Apple", "Strawberry", "Peach"};
    private int FruitImages[] = new int[]{R.drawable.laranja2, R.drawable.maca2, R.drawable.morango2, R.drawable.pessego2};
    private int FruitSounds[] = new int[]{R.raw.laranja, R.raw.maca, R.raw.morango, R.raw.pessego};
    private String FruitTranslation[] = new String[]{"Laranja", "Maça", "Morango", "Pessego"};
    private int SelectedFruit = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        SpFruits = findViewById(R.id.SpinnerFruits);
        ImageVFruits = findViewById(R.id.ImageViewFruits);
        FruitName = findViewById(R.id.TxtFruitName);
        PlaySound = findViewById(R.id.BtnPlayFruits);
        ReturnFruits = findViewById(R.id.BtnReturnFruits);

        ArrayAdapter FruitsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, FruitData);
        SpFruits.setAdapter(FruitsAdapter);
        SpFruits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                SelectedFruit = pos;
                FruitName.setText(FruitTranslation[pos]);
                ImageVFruits.setImageResource(FruitImages[pos]);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void PlaySoundFruits(View v)
    {
        MediaPlayer AudioPlayer = MediaPlayer.create(this, FruitSounds[SelectedFruit]);
        AudioPlayer.start();
    }

    public void ReturnMenuFruits(View v)
    {
        Intent FruitIntent = new Intent(FruitsActivity.this, MenuActivity.class);
        startActivity(FruitIntent);
    }

}