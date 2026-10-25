package com.kunal.librarymanagement;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.kunal.librarymanagement.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewBooks = findViewById(R.id.btnViewBooks);
        Button addBook = findViewById(R.id.btnAddBook);
        Button issueReturn = findViewById(R.id.btnIssueReturn);

        viewBooks.setOnClickListener(v ->
                Toast.makeText(this,
                        "Book list coming next!",
                        Toast.LENGTH_SHORT).show());

        addBook.setOnClickListener(v ->
                Toast.makeText(this,
                        "Add book screen coming next!",
                        Toast.LENGTH_SHORT).show());

        issueReturn.setOnClickListener(v ->
                Toast.makeText(this,
                        "Issue and return coming next!",
                        Toast.LENGTH_SHORT).show());
    }
}