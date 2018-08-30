package com.android.siwoo.androidlabforjava.common.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StepAdapterDatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String CREATE_TABLE_BASEBALL_PLAYER_SQL
                = "CREATE TABLE TBL_BASEBALL_PLAYER ( " +
            "_ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME NOT NULL , CONTENT )";
    private static final String CREATE_TABLE_DRIVE_SQL
            = "CREATE TABLE TBL_DRIVE ( " +
            "_ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE, DATE, TYPE )";
    private static final String DROP_TABLE_BASEBALL_PLAYER_SQL
            = "DROP TABLE TBL_BASEBALL_PLAYER";
    private static final String DROP_TABLE_DRIVE_SQL
            = "DROP TABLE TBL_DRIVE";
    public static final String COL_BASEBALL_NAME = "NAME";
    public static final String COL_BASEBALL_CONTENT = "CONTENT";

    private static final String[] INSERT_BASEBALL_PLAYER_SQL;
    private static final String[] INSERT_DRIVE_SQL;

    static {
        INSERT_BASEBALL_PLAYER_SQL = new String[]{
                "INSERT INTO TBL_BASEBALL_PLAYER (NAME, CONTENT) " +
                        "VALUES ('류현진', 'Please, let''s see at MLB') ",
                "INSERT INTO TBL_BASEBALL_PLAYER (NAME, CONTENT) " +
                        "VALUES ('오승환', 'Wow, look his powerful straight ball') "
        };
        INSERT_DRIVE_SQL = new String[]{
                "INSERT INTO TBL_DRIVE (TITLE, DATE, TYPE) " +
                        "VALUES ('안드로이드', '최종 수정 날짜 : 2월 6일', 'doc') ",
                "INSERT INTO TBL_DRIVE (TITLE, DATE, TYPE) " +
                        "VALUES ('db.zip', '최종 수정 날짜 : 1월 16일', 'file') ",
                "INSERT INTO TBL_DRIVE (TITLE, DATE, TYPE) " +
                        "VALUES ('하이브리드', '최종 수정 날짜 : 1월 8일', 'doc') ",
                "INSERT INTO TBL_DRIVE (TITLE, DATE, TYPE) " +
                        "VALUES ('이미지1', '최종 수정 날짜 : 1월 1일', 'img') ",
                "INSERT INTO TBL_DRIVE (TITLE, DATE, TYPE) " +
                        "VALUES ('Part4', '최종 수정 날짜 : 12월 24일', 'file') ",
        };
    }

    public StepAdapterDatabaseHelper(Context context) {
        super(context, "stepadapter", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BASEBALL_PLAYER_SQL);
        db.execSQL(CREATE_TABLE_DRIVE_SQL);
        for(String INSERT_STATEMENT: INSERT_BASEBALL_PLAYER_SQL) {
            db.execSQL(INSERT_STATEMENT);
        }
        for(String INSERT_STATEMENT: INSERT_DRIVE_SQL) {
            db.execSQL(INSERT_STATEMENT);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == VERSION) {
            db.execSQL(DROP_TABLE_BASEBALL_PLAYER_SQL);
            db.execSQL(DROP_TABLE_DRIVE_SQL);
            onCreate(db);
        }
    }
}
