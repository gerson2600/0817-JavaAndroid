package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddShoppingItemActivity extends AppCompatActivity {

    EditText ETProdName;
    EditText ETProdBrand;
    EditText ETProdQuant;
    DB_Controller DBShoppingList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shopping_item);
        ETProdName = findViewById(R.id.TxtProdName);
        ETProdBrand = findViewById(R.id.TxtProdBrand);
        ETProdQuant = findViewById(R.id.TxtProdQuantity);

        DBShoppingList = new DB_Controller(this, "", null, 1);


    }

    public void SubmitItem(View v)
    {
        if (ETProdName != null && ETProdBrand != null && ETProdQuant != null)
        {
            DBShoppingList.DbInsertItemToList(ETProdName.getText().toString(),
                                              ETProdBrand.getText().toString(),
                                              ETProdQuant.getText().toString()
            );
            Toast.makeText(AddShoppingItemActivity.this, "New Item inserted into Shopping List.", Toast.LENGTH_LONG).show();
            ETProdName.setText("");
            ETProdBrand.setText("");
            ETProdQuant.setText("");
        }else{
            Toast.makeText(AddShoppingItemActivity.this, "Fill in all fields before submitting.", Toast.LENGTH_LONG).show();
        }
    }
}

