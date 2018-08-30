package com.android.siwoo.androidlabforjava.ui.adapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.database.AdapterDatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabFour extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] data;
    ListView arrayList;
    ListView simpleList;
    ListView cursorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_four2);

        data = getResources().getStringArray(R.array.location);
        arrayList = findViewById(R.id.array_list);
        arrayList.setOnItemClickListener(this);
        simpleList = findViewById(R.id.simple_list);
        cursorList = findViewById(R.id.cursor_list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                data);
        arrayList.setAdapter(arrayAdapter);

        List<Map<String, String>> players = new ArrayList<>();
        AdapterDatabaseHelper adapterDatabaseHelper = new AdapterDatabaseHelper(this);
        SQLiteDatabase database = adapterDatabaseHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM TBL_BASEBALL_PLAYER", null);
        while (cursor.moveToNext()) {
            Map<String, String> map = new HashMap<>();
            map.put("name", cursor.getString(1));
            map.put("content", cursor.getString(2));
            players.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                players,
                android.R.layout.simple_list_item_2,
                new String[]{"name", "content"},
                new int[]{android.R.id.text1, android.R.id.text2});
        simpleList.setAdapter(simpleAdapter);

//        cursor = database.rawQuery("SELECT NAME, CONTENT FROM TBL_BASEBALL_PLAYER", null);
//        CursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
//                android.R.layout.simple_list_item_2,
//                cursor,
//                new String[]{"name", "content"},
//                new int[]{android.R.id.text1, android.R.id.text2},
//                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
//        cursorList.setAdapter(cursorAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast toast = Toast.makeText(this, data[position], Toast.LENGTH_SHORT);
        toast.show();
    }
}
