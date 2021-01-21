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

public class RelationshipsActivity extends AppCompatActivity {

    private Spinner SpRelationships;
    private ImageView ImageVRelationships;
    private TextView RelationshipName;
    private Button PlaySound;
    private Button ReturnRelationships;

    private String RelationshipData[] = new String[]{"Mother", "Father", "Brother", "Sister"};
    private int RelationshipImages[] = new int[]{R.drawable.mother, R.drawable.father, R.drawable.brother, R.drawable.sister};
    private int RelationshipSounds[] = new int[]{R.raw.mother, R.raw.father, R.raw.brother, R.raw.sister};
    private String RelationshipTranslation[] = new String[]{"Mãe", "Pai", "Irmão", "Irmã"};
    private int SelectedRelationship = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relationships);
        SpRelationships = findViewById(R.id.SpinnerRelationships);
        ImageVRelationships = findViewById(R.id.ImageViewRelationships);
        RelationshipName = findViewById(R.id.TxtRelationshipsName);
        PlaySound = findViewById(R.id.BtnPlayRelationships);
        ReturnRelationships = findViewById(R.id.BtnReturnRelationships);

        ArrayAdapter RelationshipsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, RelationshipData);
        SpRelationships.setAdapter(RelationshipsAdapter);
        SpRelationships.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                SelectedRelationship = pos;
                RelationshipName.setText(RelationshipTranslation[pos]);
                ImageVRelationships.setImageResource(RelationshipImages[pos]);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void PlaySoundRelationships(View v)
    {
        MediaPlayer AudioPlayer = MediaPlayer.create(this, RelationshipSounds[SelectedRelationship]);
        AudioPlayer.start();
    }

    public void ReturnMenuRelationships(View v)
    {
        Intent RelationshipIntent = new Intent(RelationshipsActivity.this, MenuActivity.class);
        startActivity(RelationshipIntent);
    }

}