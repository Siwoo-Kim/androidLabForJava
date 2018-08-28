package com.android.siwoo.androidlabforjava.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.database.DatabaseHelper;

public class StepOneResult extends AppCompatActivity {
    private DatabaseHelper databaseHelper = new DatabaseHelper(this);
    private TextView title;
    private TextView content;
    private static final int TITLE_COL = 0;
    public static final int CONTENT_COL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one_result);
        title = findViewById(R.id.read_title);
        content = findViewById(R.id.read_content);

        SQLiteDatabase database = null;
        try {
            database = databaseHelper.getWritableDatabase();
            Cursor cursor = database.rawQuery("SELECT TITLE, CONTENT FROM TBL_MEMO ORDER BY ID DESC LIMIT 1", null);
            while (cursor.moveToNext()) {
                title.setText(cursor.getString(TITLE_COL));
                content.setText(cursor.getString(CONTENT_COL));
            }
        }finally {
            if(database != null) {
                database.close();
            }
        }
    }
}
