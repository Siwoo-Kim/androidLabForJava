package com.android.siwoo.androidlabforjava.ui;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

import java.util.HashSet;
import java.util.Set;

public class LabSix extends AppCompatActivity {
    TextView firstText;
    TextView secondText;
    Set<View> views = new HashSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_six);

        firstText = findViewById(R.id.first_text);
        views.add(firstText);
        secondText = findViewById(R.id.second_text);
        views.add(secondText);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "cassandra.ttf");
        for (View view: views) {
            if(view instanceof TextView)
                ((TextView) view).setTypeface(typeface);
        }
    }
}
