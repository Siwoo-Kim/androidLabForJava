package com.android.siwoo.androidlabforjava.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import com.android.siwoo.androidlabforjava.R;

public class LabOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lab_one5);

        LinearLayout linearLayout = new LinearLayout(this);
        Button button = new Button(this);
        button.setText("Button 1");
        linearLayout.addView(button);
        button = new Button(this);
        button.setText("Button 2");
        linearLayout.addView(button);
        setContentView(linearLayout);
    }
}
