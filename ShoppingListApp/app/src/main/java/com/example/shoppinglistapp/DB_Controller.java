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

    public void DbDeleteItemByID(int idItem)
    {
        this.getWritableDatabase().delete("ShopList", "id="+idItem, null);
    }


    public void DbUpdateList(String ItemProdName, String ItemBrand, String ListQuantity, int IdItem)
    {
        this.getWritableDatabase().execSQL("UPDATE ShopList SET ProdName='"+ItemProdName+"'," +
                "Brand='"+ItemBrand+"'," +
                "Quantity='"+ListQuantity+"'WHERE id="+IdItem);

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

    public void ObtainData(TextView TxtProdName, TextView TxtProdBrand, TextView TxtProdQuant, int ProdID)
    {
        String [] ProdIdString = new String[]{ProdID+""};
        Cursor DbCursor = this.getReadableDatabase().rawQuery("SELECT * FROM ShopList WHERE id = ?", ProdIdString);

        TxtProdName.setText("");
        TxtProdBrand.setText("");
        TxtProdQuant.setText("");

        DbCursor.moveToFirst();
        TxtProdName.append(DbCursor.getString(1));
        TxtProdBrand.append(DbCursor.getString(2));
        TxtProdQuant.append(DbCursor.getString(3));
    }






}
