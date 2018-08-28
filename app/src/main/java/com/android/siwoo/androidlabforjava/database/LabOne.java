package com.android.siwoo.androidlabforjava.database;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.database.DatabaseHelper;

public class LabOne extends AppCompatActivity implements View.OnClickListener{

    private EditText titleView;
    private EditText contentView;
    private Button addButton;
    private static DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_one3);

        titleView = findViewById(R.id.add_title);
        contentView = findViewById(R.id.add_content);
        addButton = findViewById(R.id.add_btn);

        addButton.setOnClickListener(this);
        databaseHelper = new DatabaseHelper(this);
    }

    private static final String INSERT_MEMO_SQL
             = "INSERT INTO TBL_MEMO (TITLE, CONTENT) VALUES (?, ?)";
    @Override
    public void onClick(View view) {
        String title = titleView.getText().toString();
        String content = contentView.getText().toString();
        SQLiteDatabase database = null;
        try{
            database = new DatabaseHelper(this).getWritableDatabase();
            database.execSQL(INSERT_MEMO_SQL, new String[]{title, content});
            Intent intent = new Intent(this, LabOneSecond.class);
            startActivity(intent);
        }finally {
            if(database!=null) {
                database.close();
            }
        }
    }
}
