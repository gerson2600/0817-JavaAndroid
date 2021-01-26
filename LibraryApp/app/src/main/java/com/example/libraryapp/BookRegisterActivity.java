package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BookRegisterActivity extends AppCompatActivity {

    EditText ETBookName;
    EditText ETBookAuthor;
    EditText ETBookEditor;
    EditText ETBookYearPub;
    DB_Controller BooksDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_register);

        ETBookName = findViewById(R.id.TxtBookName);
        ETBookAuthor = findViewById(R.id.TxtAuthorName);
        ETBookEditor = findViewById(R.id.TxtEditorName);
        ETBookYearPub = findViewById(R.id.TxtYearPub);

        BooksDataBase = new DB_Controller(this, "", null, 1);
    }

    public void SubmitBook(View v)
    {

        if (ETBookName != null && ETBookAuthor != null && ETBookAuthor != null && ETBookEditor != null && ETBookYearPub != null)
        {
            BooksDataBase.DbInsertBook(ETBookName.getText().toString(),
                    ETBookAuthor.getText().toString(),
                    ETBookEditor.getText().toString(),
                    Integer.parseInt(ETBookYearPub.getText().toString()));
            Toast.makeText(BookRegisterActivity.this, "Book Inserted",Toast.LENGTH_LONG).show();
            ETBookName.setText("");
            ETBookAuthor.setText("");
            ETBookEditor.setText("");
            ETBookYearPub.setText("");
        }else{
            Toast.makeText(BookRegisterActivity.this, "Fill in all fields before submitting.", Toast.LENGTH_LONG).show();
        }


    }
}