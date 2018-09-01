package com.android.siwoo.androidlabforjava.ui.actionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.android.siwoo.androidlabforjava.R;

public class LabOne extends AppCompatActivity {
    private ActionBar actionBar;
    private Button showButton;
    private Button hideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_one10);

        showButton = findViewById(R.id.showButton);
        hideButton = findViewById(R.id.hideButton);
        actionBar = getSupportActionBar();

        View.OnClickListener buttonListener = (button) -> {
            actionBar.show();
        };
        showButton.setOnClickListener(buttonListener);
        buttonListener = (button) -> {
            actionBar.hide();
        };
        hideButton.setOnClickListener(buttonListener);
    }
}
