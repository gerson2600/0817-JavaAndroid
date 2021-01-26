package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void OpenShowShoppingList(View V)
    {
        Intent i = new Intent(MenuActivity.this, AddShoppingItemActivity.class);
        startActivity(i);
    }

    public void OpenAddShoppingItemsList(View V)
    {
        Intent i = new Intent(MenuActivity.this, ShowShoppingListActivity.class);
        startActivity(i);
    }




}