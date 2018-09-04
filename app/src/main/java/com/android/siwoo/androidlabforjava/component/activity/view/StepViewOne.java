package com.android.siwoo.androidlabforjava.component.activity.view;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

import static junit.framework.Assert.assertNotNull;

public class StepViewOne extends AppCompatActivity {
    private CheckBox simpleCheckbox;
    private TextView typefaceText;
    private Typeface typeface;
    public static final String TTF_CASSANDRA = "cassandra.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_view_one);
        typeface = Typeface.createFromAsset(getAssets(), TTF_CASSANDRA);
        assertNotNull(typeface);

        typefaceText = findViewById(R.id.typeface_text);
        assertNotNull(typefaceText);
        typefaceText.setTypeface(typeface);

        simpleCheckbox = findViewById(R.id.simple_checkbox);
        assertNotNull(simpleCheckbox);
        simpleCheckbox.setOnCheckedChangeListener((button, checked) -> {
            String result = button.isChecked()? "CHECKED": "UNCHECKED";
            button.setText(result);
        });
    }
}
