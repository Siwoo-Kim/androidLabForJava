package com.android.siwoo.androidlabforjava.ui.adapter;

import android.support.v4.util.SimpleArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.android.siwoo.androidlabforjava.R;
import android.widget.ArrayAdapter;

public class LabOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_one6);

        ListView listView = findViewById(R.id.main_list);
        String[] data = {
                "Seoul",
                "Toronto",
                "Markcham",
                "Busan"
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(arrayAdapter);
    }
}
