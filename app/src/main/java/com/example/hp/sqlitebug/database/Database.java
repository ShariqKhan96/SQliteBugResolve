package com.example.hp.sqlitebug.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 7/26/2018.username
 */

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "demo.db";
    private static final int VERSION = 1;
    private static String tableName = "demotable";
    private static String columnOne = "username";
    private static String columnTwo = "userphone";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, userphone TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

    public boolean insertUser(String username, String userphone) {

        SQLiteDatabase sq = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(columnOne, username);
        contentValues.put(columnTwo, userphone);

        long inserted = sq.insert(tableName, null, contentValues);

        return inserted != -1;
    }

    public boolean userExists(String userphone) {
        SQLiteDatabase database = this.getReadableDatabase();
        //String query = "Select * from " + tableName + " where userphone=" + userphone;
        String Query = String.format("Select * FROM demotable WHERE userphone='%s'", userphone);

        Cursor cursor = database.rawQuery(Query, null);

        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        } else {
            cursor.close();
            return true;
        }

    }
}
