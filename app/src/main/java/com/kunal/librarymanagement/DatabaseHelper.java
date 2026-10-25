package com.kunal.librarymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "library.db";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE books (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "title TEXT NOT NULL, " +
                        "author TEXT NOT NULL, " +
                        "available INTEGER DEFAULT 1)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {
        // Add database migration code here when needed.
    }

    public boolean addBook(String title, String author) {
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("author", author);
        values.put("available", 1);

        SQLiteDatabase db = getWritableDatabase();
        return db.insert("books", null, values) != -1;
    }

    public Cursor getAllBooks() {
        return getReadableDatabase().rawQuery(
                "SELECT * FROM books ORDER BY title",
                null
        );
    }

    public Cursor searchBooks(String query) {
        return getReadableDatabase().rawQuery(
                "SELECT * FROM books WHERE title LIKE ? " +
                        "OR author LIKE ? ORDER BY title",
                new String[]{"%" + query + "%", "%" + query + "%"}
        );
    }

    public boolean toggleAvailability(int id, int available) {
        ContentValues values = new ContentValues();
        values.put("available", available == 1 ? 0 : 1);

        return getWritableDatabase().update(
                "books", values, "id = ?",
                new String[]{String.valueOf(id)}
        ) > 0;
    }
}
