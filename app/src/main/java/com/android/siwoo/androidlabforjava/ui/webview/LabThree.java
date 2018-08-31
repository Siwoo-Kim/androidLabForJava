package com.android.siwoo.androidlabforjava.ui.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.android.siwoo.androidlabforjava.R;

public class LabThree extends AppCompatActivity {
    private static final String[] autoCompletion = {
            "Monday",
            "Tueseday"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_three4);

        AutoCompleteTextView autoCompleteText = findViewById(R.id.auto_complete_text);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line,
                autoCompletion);
        autoCompleteText.setAdapter(arrayAdapter);
    }
}
