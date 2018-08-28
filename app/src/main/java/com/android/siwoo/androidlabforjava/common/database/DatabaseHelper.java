package com.android.siwoo.androidlabforjava.common.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String CREATE_DDL = "CREATE TABLE TBL_MEMO (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE, CONTENT)";
    private static final String DROP_DDL = "DROP TABLE TBL_MEMO";

    public DatabaseHelper(Context context) {
        super(context, "memodb", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DDL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == VERSION) {
            db.execSQL(DROP_DDL);
            onCreate(db);
        }
    }
}
