package com.android.siwoo.androidlabforjava.common.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdapterDatabaseHelper extends SQLiteOpenHelper {
    public static final int VERSION = 8;
    public static final String CREATE_BASEBALL_PLAYER_SQL
                = "CREATE TABLE TBL_BASEBALL_PLAYER (" +
            " _ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NAME NOT NULL, CONTENT )";
    public static final String[] PLAYER_INSERTS = {
            "INSERT INTO TBL_BASEBALL_PLAYER (NAME, CONTENT) " +
                    "VALUES ('류현진', '제발 MLB 에서 볼 수 있기를')",
            "INSERT INTO TBL_BASEBALL_PLAYER (NAME, CONTENT) " +
                    "VALUES ('오승환', '돌직구 장난 아니구나.')"
    };
    public static final String DROP_BASEBALL_PLAYER_SQL
            = "DROP TABLE TBL_BASEBALL_PLAYER ";
    public static final String DROP_DRIVER_SQL
            = "DROP TABLE TBL_DRIVE ";

    public static final String CREATE_DRIVE_SQL
            = "CREATE TABLE TBL_DRIVE (" +
            "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "TITLE, DATE, TYPE) ";
    public static final String[] DRIVE_INSERTS = {
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

    public AdapterDatabaseHelper(Context context) {
        super(context, "datadb", null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BASEBALL_PLAYER_SQL);
        for(String insert: PLAYER_INSERTS) {
            db.execSQL(insert);
        }

        db.execSQL(CREATE_DRIVE_SQL);
        for(String insert: DRIVE_INSERTS) {
            db.execSQL(insert);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == VERSION) {
            db.execSQL(DROP_BASEBALL_PLAYER_SQL);
            db.execSQL(DROP_DRIVER_SQL);
            onCreate(db);
        }
    }
}
