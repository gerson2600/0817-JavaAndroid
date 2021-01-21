package com.example.actionbarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BottlesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottles);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Menu association to activity
        getMenuInflater().inflate(R.menu.menu_wine, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.redwine)
        {
            Intent RedWineIntent = new Intent(BottlesActivity.this, RedWineActivity.class);
            startActivity(RedWineIntent);
        }
        if (id == R.id.whitewine)
        {
            Intent WhiteWineIntent = new Intent(BottlesActivity.this, WhiteWineActivity.class);
            startActivity(WhiteWineIntent);
        }
        if (id == R.id.exitwines)
        {
            BottlesActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


}