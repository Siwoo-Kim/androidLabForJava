package com.android.siwoo.androidlabforjava.component.activity;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

public class LabFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_four3);

        TextView textView = findViewById(R.id.greetingText);
        assertNotNull("greetingText must be not null", textView);
        String greeting = textView.getText().toString();
        assertTrue("Hello Android".equalsIgnoreCase(greeting));
    }
}
