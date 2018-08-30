package com.android.siwoo.androidlabforjava.ui.adapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.database.StepAdapterDatabaseHelper;

import java.util.*;

public class StepTwo extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView arrayList;
    private ListView simpleList;
    private ListView cursorList;
    private Set<View> views = new HashSet<>();
    private String[] data;
    private static final String KEY_NAME = "NAME";
    private static final String KEY_CONTENT = "CONTENT";
    public static final String SQL_SELECT_PLAYER =
            "SELECT NAME, CONTENT FROM TBL_BASEBALL_PLAYER";
    private static SQLiteOpenHelper databaseSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two);

        init();

    }

    private void init() {
        initViews();
        data = getResources().getStringArray(R.array.location);
        databaseSession = new StepAdapterDatabaseHelper(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data);
        arrayList.setAdapter(arrayAdapter);

        initSimpleList();
        //initCursorList();
    }

    private void initCursorList() {
        SQLiteDatabase database = null;
        try {
            database = databaseSession.getWritableDatabase();
            Cursor cursor = database.rawQuery(SQL_SELECT_PLAYER, null);
            CursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    new String[]{StepAdapterDatabaseHelper.COL_BASEBALL_NAME, StepAdapterDatabaseHelper.COL_BASEBALL_CONTENT},
                    new int[]{android.R.id.text1, android.R.id.text2},
                    CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        }finally {
            if(database != null) {
                database.close();
            }
        }
    }

    private void initSimpleList() {
        SQLiteDatabase database = null;
        try {
            database = databaseSession.getWritableDatabase();
            List<Map<String, String>> players = new ArrayList<>();
            Cursor cursor = database.rawQuery(SQL_SELECT_PLAYER, null);
            while (cursor.moveToNext()) {
                Map<String, String> map = new HashMap();
                map.put(KEY_NAME, cursor.getString(0));
                map.put(KEY_CONTENT, cursor.getString(1));
                players.add(map);
            }
            SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                    players,
                    android.R.layout.simple_list_item_2,
                    new String[]{KEY_NAME, KEY_CONTENT},
                    new int[]{android.R.id.text1, android.R.id.text2});
            simpleList.setAdapter(simpleAdapter);
        }finally {
            if(database != null) {
                database.close();
            }
        }
    }

    private void initViews() {
        arrayList = findViewById(R.id.array_list);
        views.add(arrayList);
        arrayList.setOnItemClickListener(this);
        simpleList = findViewById(R.id.simple_list);
        views.add(simpleList);
        cursorList = findViewById(R.id.cursor_list);
        views.add(cursorList);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast toast = Toast.makeText(this, data[position], Toast.LENGTH_SHORT);
        toast.show();
    }
}
