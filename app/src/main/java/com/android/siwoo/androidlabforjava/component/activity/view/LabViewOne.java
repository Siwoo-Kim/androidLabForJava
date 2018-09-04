package com.android.siwoo.androidlabforjava.component.activity.view;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class LabViewOne extends AppCompatActivity {
    private TextView greetingText;
    private Typeface cassandraTypeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_view_one);

        greetingText = findViewById(R.id.greeting_text);
        assertNotNull(greetingText);
        String value = greetingText.getText().toString();
        String greeting = getResources().getString(R.string.greeting);
        assertEquals(value, greeting);
        Typeface cassandraTypeface = Typeface.createFromAsset(getAssets(), "cassandra.ttf");
        greetingText.getAutoLinkMask();
        greetingText.setOnClickListener(view -> {
            greetingText.setTypeface(cassandraTypeface);
        });
    }
}
