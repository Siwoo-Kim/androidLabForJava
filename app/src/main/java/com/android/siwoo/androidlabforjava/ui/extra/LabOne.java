package com.android.siwoo.androidlabforjava.ui.extra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.android.siwoo.androidlabforjava.R;

public class LabOne extends AppCompatActivity {
    public static final String[] data = {
            "Korean",
            "Spanish",
            "English",
            "French",
            "Chinese"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_one9);

        Spinner simpleList = findViewById(R.id.simple_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, data);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        simpleList.setAdapter(arrayAdapter);

//        Spinner simpleSecondList = findViewById(R.id.simple_second_list);
//        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, data);
//        simpleSecondList.setAdapter(arrayAdapter);
    }
}
