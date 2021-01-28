package com.example.shoppinglistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddShoppingItemActivity extends AppCompatActivity {

    EditText ETProdName;
    EditText ETProdBrand;
    EditText ETProdQuant;
    DB_Controller DBShoppingList;
    Button BtnSubmit;
    int IdEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shopping_item);
        ETProdName = findViewById(R.id.TxtProdName);
        ETProdBrand = findViewById(R.id.TxtProdBrand);
        ETProdQuant = findViewById(R.id.TxtProdQuantity);
        BtnSubmit = findViewById(R.id.BtnItemSubmit);

        DBShoppingList = new DB_Controller(this, "", null, 1);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int OptionId = item.getItemId();
        if (OptionId == R.id.BtnMenuEdit)
        {
            EditItemById();
        }
        return super.onOptionsItemSelected(item);
    }

    public void EditItemById()
    {
        AlertDialog.Builder EditMsgBox = new AlertDialog.Builder(AddShoppingItemActivity.this);
        EditMsgBox.setTitle("Edit Item");
        EditMsgBox.setIcon(android.R.drawable.ic_menu_info_details);
        EditMsgBox.setMessage("Insert the ID of the Item you want to edit.");
        final EditText ItemCode = new EditText(this);
        EditMsgBox.setView(ItemCode);
        EditMsgBox.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                IdEdit = Integer.parseInt(ItemCode.getText().toString());
                DBShoppingList.ObtainData(ETProdName, ETProdBrand, ETProdQuant, IdEdit);
                BtnSubmit.setText("Update Item");

            }
        });
        EditMsgBox.show();
    }

    public void SubmitItem(View v)
    {
        if (BtnSubmit.getText().equals("Submit Item"))
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
        }else if (BtnSubmit.getText().equals("Update Item"))
        {
            if (ETProdName != null && ETProdBrand != null && ETProdQuant != null)
            {
                DBShoppingList.DbUpdateList(ETProdName.getText().toString(),
                        ETProdBrand.getText().toString(),
                        ETProdQuant.getText().toString(),
                        IdEdit);
                Toast.makeText(AddShoppingItemActivity.this, "Item updated in Shopping List.", Toast.LENGTH_LONG).show();
                ETProdName.setText("");
                ETProdBrand.setText("");
                ETProdQuant.setText("");
                BtnSubmit.setText("Submit Item");
            }else{
                Toast.makeText(AddShoppingItemActivity.this, "Fill in all fields before submitting.", Toast.LENGTH_LONG).show();
            }
        }

    }
}

