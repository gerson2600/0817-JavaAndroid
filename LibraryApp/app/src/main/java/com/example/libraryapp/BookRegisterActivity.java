package com.example.libraryapp;

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

public class BookRegisterActivity extends AppCompatActivity {

    EditText ETBookName;
    EditText ETBookAuthor;
    EditText ETBookEditor;
    EditText ETBookYearPub;
    Button BtnSubmit;
    int IDEdit;

    DB_Controller BooksDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_register);

        ETBookName = findViewById(R.id.TxtBookName);
        ETBookAuthor = findViewById(R.id.TxtAuthorName);
        ETBookEditor = findViewById(R.id.TxtEditorName);
        ETBookYearPub = findViewById(R.id.TxtYearPub);
        BtnSubmit = findViewById(R.id.BtnRegisterSubmit);

        BooksDataBase = new DB_Controller(this, "", null, 1);
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
        int OptionID = item.getItemId();
        if (OptionID == R.id.BtnEditBookMenuOption)
        {
            EditBookByID();
        }
        return super.onOptionsItemSelected(item);
    }

    public void EditBookByID()
    {
        AlertDialog.Builder EditMsgBox = new AlertDialog.Builder(BookRegisterActivity.this);
        EditMsgBox.setTitle("Edit Book");
        EditMsgBox.setIcon(android.R.drawable.ic_menu_info_details);
        EditMsgBox.setMessage("Insert the ID of the book you want to edit.");
        final EditText BookCode = new EditText(this);
        EditMsgBox.setView(BookCode);
        EditMsgBox.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                IDEdit = Integer.parseInt(BookCode.getText().toString());
                BooksDataBase.ObtainData(ETBookName, ETBookAuthor, ETBookEditor, ETBookYearPub, IDEdit);
                BtnSubmit.setText("Update Book");

            }
        });
        EditMsgBox.show();
    }

    public void SubmitBook(View v)
    {
        if (BtnSubmit.getText().equals("Submit Book"))
        {
            if (ETBookName != null && ETBookAuthor != null && ETBookEditor != null && ETBookYearPub != null)
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
        }else if (BtnSubmit.getText().equals("Update Book"))
        {
            if (ETBookName != null && ETBookAuthor != null && ETBookEditor != null && ETBookYearPub != null)
            {
                BooksDataBase.DbUpdateBook(ETBookName.getText().toString(),
                        ETBookAuthor.getText().toString(),
                        ETBookEditor.getText().toString(),
                        Integer.parseInt(ETBookYearPub.getText().toString()),
                        IDEdit);

                Toast.makeText(BookRegisterActivity.this, "Book Updated",Toast.LENGTH_LONG).show();
                ETBookName.setText("");
                ETBookAuthor.setText("");
                ETBookEditor.setText("");
                ETBookYearPub.setText("");
                BtnSubmit.setText("Submit Book");
            }else{
                Toast.makeText(BookRegisterActivity.this, "Fill in all fields before submitting.", Toast.LENGTH_LONG).show();
            }
        }

    }




}