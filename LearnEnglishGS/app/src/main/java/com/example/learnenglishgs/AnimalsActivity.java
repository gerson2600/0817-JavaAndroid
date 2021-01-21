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

public class AnimalsActivity extends AppCompatActivity {

    private Spinner SpAnimals;
    private ImageView ImageVAnimals;
    private TextView AnimalName;
    private Button PlaySound;
    private Button ReturnAnimals;

    private String AnimalData[] = new String[]{"Dog", "Cat", "Fox", "Hamster"};
    private int AnimalImages[] = new int[]{R.drawable.dog, R.drawable.cat, R.drawable.fox, R.drawable.hamster};
    private int AnimalSounds[] = new int[]{R.raw.dog, R.raw.cat, R.raw.fox, R.raw.hamster};
    private String AnimalTranslation[] = new String[]{"Cão", "Gato", "Raposa", "Hamster"};
    private int SelectedAnimal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        SpAnimals = findViewById(R.id.SpinnerAnimals);
        ImageVAnimals = findViewById(R.id.ImageViewAnimals);
        AnimalName = findViewById(R.id.TxtAnimalsName);
        PlaySound = findViewById(R.id.BtnPlayAnimals);
        ReturnAnimals = findViewById(R.id.BtnReturnAnimals);

        ArrayAdapter AnimalsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, AnimalData);
        SpAnimals.setAdapter(AnimalsAdapter);
        SpAnimals.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                SelectedAnimal = pos;
                AnimalName.setText(AnimalTranslation[pos]);
                ImageVAnimals.setImageResource(AnimalImages[pos]);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void PlaySoundAnimals(View v)
    {
        MediaPlayer AudioPlayer = MediaPlayer.create(this, AnimalSounds[SelectedAnimal]);
        AudioPlayer.start();
    }

    public void ReturnMenuAnimals(View v)
    {
        Intent AnimalIntent = new Intent(AnimalsActivity.this, MenuActivity.class);
        startActivity(AnimalIntent);
    }

}