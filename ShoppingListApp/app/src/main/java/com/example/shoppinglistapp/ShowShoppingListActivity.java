package com.example.shoppinglistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class ShowShoppingListActivity extends AppCompatActivity {

    TextView TVShoppingList;
    DB_Controller ShopListDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_shopping_list);
        TVShoppingList = findViewById(R.id.TxtShoppingOutput);
        ShopListDataBase = new DB_Controller(this, "", null, 1);
        FillShoppingListInfo();


    }

    public void FillShoppingListInfo()
    {
        ShopListDataBase.DbListItems(TVShoppingList);
    }

    //Menu onCreate and menu onOptionsSelected


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int OptionID = item.getItemId();
        if (OptionID == R.id.BtnMenuDelete)
        {
            DeleteItemById();
            FillShoppingListInfo();
        }
        return super.onOptionsItemSelected(item);
    }

    public void DeleteItemById()
    {
        AlertDialog.Builder DeleteMsgBox = new AlertDialog.Builder(ShowShoppingListActivity.this);
        DeleteMsgBox.setTitle("Delete Item");
        DeleteMsgBox.setIcon(android.R.drawable.ic_input_delete);
        DeleteMsgBox.setMessage("Enter the id of the item to delete");
        final EditText ItemCode = new EditText(this);
        DeleteMsgBox.setView(ItemCode);
        DeleteMsgBox.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                ShopListDataBase.DbDeleteItemByID(Integer.parseInt(ItemCode.getText().toString()));
                finish();
                startActivity(getIntent());
            }
        });
        DeleteMsgBox.show();
    }


}