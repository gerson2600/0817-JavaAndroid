package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void Register(View v)
    {
        Intent i = new Intent(MainActivity.this, BookRegisterActivity.class);
        startActivity(i);
    }
    public void List(View v)
    {
        Intent i = new Intent(MainActivity.this, BookListActivity.class);
        startActivity(i);
    }
    public void Exit(View v)
    {
        MainActivity.this.finish();
    }
}