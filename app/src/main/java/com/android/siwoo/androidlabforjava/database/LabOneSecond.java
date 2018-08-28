package com.android.siwoo.androidlabforjava.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.database.DatabaseHelper;

public class LabOneSecond extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    public static final String SELECT_ALL_SQL = "SELECT TITLE, CONTENT FROM TBL_MEMO ORDER BY ID DESC LIMIT 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_one_second);

        TextView titleView = findViewById(R.id.read_title);
        TextView contentView = findViewById(R.id.read_content);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase database = null;

        try {
            database = databaseHelper.getWritableDatabase();
            Cursor cursor = database.rawQuery(SELECT_ALL_SQL, null);
            while (cursor.moveToNext()) {
                titleView.setText(cursor.getString(0));
                contentView.setText(cursor.getString(1));
            }
        } finally {
            if(database != null) {
                database.close();
            }
        }
    }
}
