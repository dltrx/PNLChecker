package com.example.pnlchecker.utils;

import com.example.pnlchecker.MainActivity;
import com.example.pnlchecker.models.MyData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_database";
    private static final int DATABASE_VERSION = 1;

    // Define the table and column names
    private static final String TABLE_NAME = "my_table";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME1 = "symbol";
    private static final String COLUMN_NAME2 = "buyExchange";
    private static final String COLUMN_NAME3 = "sellExchange";
    private static final String COLUMN_NAME4 = "time";
    private static final String COLUMN_NAME5 = "PNL";

    // SQL query to create the table
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME1 + " TEXT, " +
            COLUMN_NAME2 + " TEXT, " +
            COLUMN_NAME3 + " TEXT, " +
            COLUMN_NAME4 + " REAL, " +
            COLUMN_NAME5 + " REAL);";

    public MyDatabaseHelper(MainActivity mainActivity) {
        super(mainActivity, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the table
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Perform upgrade operations if needed
        // This method is called when the database version is increased
    }

    public List<MyData> getLocalData() {

        return null;
    }

    public String getCreateTableQuery() {
        return CREATE_TABLE_QUERY;
    }
}
