package com.example.libraryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class BookListActivity extends AppCompatActivity {

    TextView BookRegister;
    ListView BookList;
    DB_Controller BooksDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        FillBookInfo();

    }
    public void FillBookInfo()
    {
        BooksDataBase = new DB_Controller(this, "", null, 1);
        BookRegister = findViewById(R.id.TxtViewBookList);
        BooksDataBase.DbListBooks(BookRegister);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int OptionId = item.getItemId();
        if (OptionId == R.id.BtnDeleteBookMenuOption)
        {
            DeleteBookById();
            BookRegister.setText("");

            FillBookInfo();
        }
        return super.onOptionsItemSelected(item);
    }

    public void DeleteBookById()
    {
        AlertDialog.Builder DeleteMsgBox = new AlertDialog.Builder(BookListActivity.this);
        DeleteMsgBox.setTitle("Delete Book");
        DeleteMsgBox.setIcon(android.R.drawable.ic_input_delete);
        DeleteMsgBox.setMessage("Enter the id of the book to delete");
        final EditText BookCode = new EditText(this);
        DeleteMsgBox.setView(BookCode);
        DeleteMsgBox.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                BooksDataBase.DbDeleteBook(Integer.parseInt(BookCode.getText().toString()));
                finish();
                startActivity(getIntent());
            }
        });
        DeleteMsgBox.show();
    }

}