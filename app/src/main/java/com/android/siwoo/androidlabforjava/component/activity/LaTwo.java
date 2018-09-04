package com.android.siwoo.androidlabforjava.component.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import com.android.siwoo.androidlabforjava.R;

public class LaTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        Button button = getButton("Button 1");
        linearLayout.addView(button);
        button = getButton("Button 2");
        linearLayout.addView(button);
        setContentView(linearLayout);
    }

    private Button getButton(String text) {
        Button button = new Button(this);
        button.setText(text);
        return button;
    }


}
