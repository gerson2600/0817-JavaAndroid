package com.example.learnenglishgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button Fruits;
    Button Colours;
    Button Animals;
    Button Relationships;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Fruits = findViewById(R.id.BtnFruits);
        Colours = findViewById(R.id.BtnColours);
        Animals = findViewById(R.id.BtnAnimals);
        Relationships = findViewById(R.id.BtnRelationships);
    }
        public void LearnFruits(View v)
        {
            Intent IntentLearnFruits = new Intent(MenuActivity.this, FruitsActivity.class);
            startActivity(IntentLearnFruits);
        }
        public void LearnColours(View v)
        {
            Intent IntentLearnColours = new Intent(MenuActivity.this, ColoursActivity.class);
            startActivity(IntentLearnColours);
        }
        public void LearnAnimals(View v)
        {
            Intent IntentLearnAnimals = new Intent(MenuActivity.this, AnimalsActivity.class);
            startActivity(IntentLearnAnimals);
        }
        public void LearnRelationships(View v)
        {
            Intent IntentLearnRelationships = new Intent(MenuActivity.this, RelationshipsActivity.class);
            startActivity(IntentLearnRelationships);
        }


    }
