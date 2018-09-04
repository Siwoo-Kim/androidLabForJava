package com.android.siwoo.androidlabforjava.component.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

public class StepOne extends AppCompatActivity {
    Button visibleButton;
    Button invisibleButton;
    TextView greetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one6);

        init();
    }

    private void init() {
        visibleButton = findViewById(R.id.visible_button);
        invisibleButton = findViewById(R.id.invisible_button);
        greetingText = findViewById(R.id.greeting_text);
        visibleButton.setOnClickListener(view -> greetingText.setVisibility(View.VISIBLE));
        invisibleButton.setOnClickListener(view -> greetingText.setVisibility(View.INVISIBLE));
    }
}
