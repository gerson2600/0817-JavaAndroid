package com.example.libraryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import org.w3c.dom.Text;

//pain is eternal
public class DB_Controller extends SQLiteOpenHelper {

    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, "Library.db", factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Books(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                "Name TEXT NOT NULL," +
                                                "Author TEXT NOT NULL," +
                                                "Editor TEXT NOT NULL," +
                                                "YearPub INTEGER NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Books");
        onCreate(sqLiteDatabase);

    }

    public void DbInsertBook(String BookName, String BookAuthor, String BookEditor, int BookYearPub)
    {
        ContentValues InsertValues = new ContentValues();
        InsertValues.put("Name", BookName);
        InsertValues.put("Author", BookAuthor);
        InsertValues.put("Editor", BookEditor);
        InsertValues.put("YearPub", BookYearPub);
        this.getWritableDatabase().insertOrThrow("Books","",InsertValues);
    }

    public void DbDeleteBook(int idBook)
    {
        this.getWritableDatabase().delete("Books", "id="+idBook, null);
    }

    public void DbUpdateBook(String BookName, String BookAuthor, String BookEditor, int BookYearPub, int IdBook)
    {
        this.getWritableDatabase().execSQL("UPDATE Books SET Name='"+BookName+"'," +
                                                            "Author='"+BookAuthor+"'," +
                                                            "Editor='"+BookEditor+"'," +
                                                            "YearPub="+BookYearPub+" WHERE id="+IdBook);

    }

    public void DbListBooks(TextView tv)
    {
        Cursor DbCursor = this.getReadableDatabase().rawQuery("SELECT * FROM Books", null);
        tv.setText("");
        while(DbCursor.moveToNext())
        {
            tv.append("\nID: "+ DbCursor.getInt(0)+
                    "\nName: "+DbCursor.getString(1)+
                    "\nAuthor: "+DbCursor.getString(2)+
                    "\nEditor: "+DbCursor.getString(3)+
                    "\nYear of Publication: "+DbCursor.getInt(4)+ "\n");
        }
    }

    public void ObtainData(TextView TxtName, TextView TxtAuthor, TextView TxtEditor, TextView TxtYearPub, int BookId)
    {
        String [] BookIdString = new String[]{BookId+""};
        Cursor DbCursor = this.getReadableDatabase().rawQuery("SELECT * FROM Books WHERE id = ?", BookIdString);

        TxtName.setText("");
        TxtAuthor.setText("");
        TxtEditor.setText("");
        TxtYearPub.setText("");
        DbCursor.moveToFirst();
        TxtName.append(DbCursor.getString(1));
        TxtAuthor.append(DbCursor.getString(2));
        TxtEditor.append(DbCursor.getString(3));
        TxtYearPub.append(DbCursor.getInt(4)+"");
    }


}














