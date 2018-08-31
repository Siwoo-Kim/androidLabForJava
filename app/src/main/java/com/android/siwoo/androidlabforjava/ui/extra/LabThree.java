package com.android.siwoo.androidlabforjava.ui.extra;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import com.android.siwoo.androidlabforjava.R;

public class LabThree extends AppCompatActivity {
    private Spinner simpleText;
    private static String[] simpleTextData;
    private AutoCompleteTextView autoCompleteText;
    private static String[] autoCompleteData;
    private ProgressBar progressBar;
    private Runnable incrementProgress = () -> {
        for(int i=0;i<10;i++) {
            SystemClock.sleep(1000);
            progressBar.incrementProgressBy(10);
            progressBar.incrementSecondaryProgressBy(15);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_three5);

        simpleText = findViewById(R.id.simple_list);
        autoCompleteText = findViewById(R.id.auto_complete_text);

        simpleTextData = getResources().getStringArray(R.array.languages);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line,
                simpleTextData);
        simpleText.setAdapter(arrayAdapter);

        autoCompleteData = getResources().getStringArray(R.array.players);
        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line,
                autoCompleteData);
        autoCompleteText.setAdapter(arrayAdapter);

        progressBar = findViewById(R.id.stick_progress);
        new Thread(incrementProgress).start();
    }
}
