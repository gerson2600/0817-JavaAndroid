package com.example.actionbarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Menu association to activity
        getMenuInflater().inflate(R.menu.menu_entry, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();


        if(id == R.id.entry)
        {
            ShowMessage();
        }
        if (id == R.id.exit)
        {
            MainActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void ShowMessage()
    {
        AlertDialog.Builder msgbox = new AlertDialog.Builder(this);
        msgbox.setTitle("Legal Age Verification");
        msgbox.setIcon(android.R.drawable.ic_dialog_info);
        msgbox.setMessage("Are you old enough to legaly consume alcohol?");
        msgbox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent PosI = new Intent(MainActivity.this, BottlesActivity.class);
                startActivity(PosI);
            }
        });

        msgbox.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });
        msgbox.show();

    }
}