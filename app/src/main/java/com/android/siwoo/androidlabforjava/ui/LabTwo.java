package com.android.siwoo.androidlabforjava.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

public class LabTwo extends AppCompatActivity {
    private TextView simpleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_two4);

        simpleText = findViewById(R.id.simple_text);
        simpleText.setText(simpleText.getText().toString() + " Android!");
    }
}
