package com.android.siwoo.androidlabforjava.database;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.database.DatabaseHelper;


public class StepOne extends AppCompatActivity implements View.OnClickListener{
    private TextView title;
    private TextView content;
    private Button addButton;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one);

        title = findViewById(R.id.add_title);
        content = findViewById(R.id.add_content);
        addButton = findViewById(R.id.add_btn);
        addButton.setOnClickListener(this);
        databaseHelper = new DatabaseHelper(this);
    }

    @Override
    public void onClick(View view) {
        String titleValue = title.getText().toString();
        String contentValue = content.getText().toString();
        SQLiteDatabase database = null;

        try {
            database = databaseHelper.getWritableDatabase();
            database.execSQL("INSERT INTO TBL_MEMO (TITLE, CONTENT) VALUES (?, ?)", new String[]{titleValue, contentValue});
            Intent intent = new Intent(this, StepOneResult.class);
            startActivity(intent);
        }finally {
            if(database != null) {
                database.close();
            }
        }
    }
}
