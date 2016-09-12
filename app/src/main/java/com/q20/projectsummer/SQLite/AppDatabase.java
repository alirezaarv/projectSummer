package com.q20.projectsummer.SQLite;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class AppDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "data.db";
    private static final int DATABASE_VERSION = 1;

    public AppDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}
