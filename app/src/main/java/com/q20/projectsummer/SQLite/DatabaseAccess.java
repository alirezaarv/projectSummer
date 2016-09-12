package com.q20.projectsummer.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.q20.projectsummer.helpers.PackHelper;

import java.util.ArrayList;
import java.util.List;

/*
        usage in other classes:

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.openDb();
        String name = databaseAccess.getPlayerName();
        databaseAccess.closeDb();
*/


public class DatabaseAccess {
    private static DatabaseAccess instance;
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

    private DatabaseAccess(Context context) {
        this.openHelper = new AppDatabase(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }


    public void openDb() {
        this.database = openHelper.getWritableDatabase();
    }

    public void closeDb() {
        if (database != null) {
            this.database.close();
        }
    }

    //get a table in database and get data
    //get player name
    public String getPlayerName() {
        Cursor cursor = database.rawQuery("SELECT * FROM player", null);
        cursor.moveToFirst();
        String name = cursor.getString(1);
        cursor.close();
        return name;
    }

    //get player coins number
    public int getPlayerCoins() {
        Cursor cursor = database.rawQuery("SELECT * FROM player", null);
        cursor.moveToFirst();
        int coins = cursor.getInt(2);
        cursor.close();
        return coins;
    }

    //get player score
    public int getPlayerScore() {
        Cursor cursor = database.rawQuery("SELECT * FROM player", null);
        cursor.moveToFirst();
        int score = cursor.getInt(3);
        cursor.close();
        return score;
    }

    //get pack name by id
    public String getPackName(int id) {
        Cursor cursor = database.rawQuery("SELECT * FROM pack", null);
        cursor.moveToFirst();
        String name = cursor.getString(1);
        cursor.close();
        return name;
    }

    //get pack all words number by id
    public int getPackWordsNumber(int id){
        Cursor cursor = database.rawQuery("SELECT * FROM pack", null);
        cursor.moveToFirst();
        int number = cursor.getInt(2);
        cursor.close();
        return number;
    }

    //get pack passed words number by id
    public int getPackWordsPassed(int id){
        Cursor cursor = database.rawQuery("SELECT * FROM pack", null);
        cursor.moveToFirst();
        int number = cursor.getInt(3);
        cursor.close();
        return number;
    }

}
