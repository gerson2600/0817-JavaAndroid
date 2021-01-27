package com.example.shoppinglistapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class DB_Controller extends SQLiteOpenHelper {

    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, "ShoppingList.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDbShopping)
    {
        sqlDbShopping.execSQL("CREATE TABLE ShopList(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                    "ProdName TEXT NOT NULL," +
                                                    "Brand TEXT NOT NULL," +
                                                    "Quantity TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDbShopping, int oldVersion, int newVersion)
    {
        sqlDbShopping.execSQL("DROP TABLE IF EXISTS ShopList");
        onCreate(sqlDbShopping);
    }

    public void DbInsertItemToList(String ItemProdName, String ItemBrand, String ListQuantity)
    {
        ContentValues InsertValues = new ContentValues();
        InsertValues.put("ProdName", ItemProdName);
        InsertValues.put("Brand", ItemBrand);
        InsertValues.put("Quantity", ListQuantity);
        this.getWritableDatabase().insertOrThrow("ShopList", "", InsertValues);
    }

    public void DbDeleteItemFromList(int idItem)
    {
        this.getWritableDatabase().delete("ShopList", "id="+idItem, null);
    }


    public void DbUpdateList(String ItemProdName, String ItemBrand, String ListQuantity)
    {

    }

    public void DbListItems(TextView tv)
    {
        Cursor DbCursor = this.getReadableDatabase().rawQuery( "SELECT * FROM ShopList", null);
        tv.setText("");
        while (DbCursor.moveToNext())
        {
            tv.append("ID: "+DbCursor.getInt(0)+
                    "\nItem Name: "+ DbCursor.getString(1)+
                    "\nProduct Brand: "+ DbCursor.getString(2)+
                    "\nQuantity: "+ DbCursor.getString(3)+"\n");
        }
    }






}
