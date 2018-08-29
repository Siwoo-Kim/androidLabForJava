package com.android.siwoo.androidlabforjava.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

import java.util.HashSet;
import java.util.Set;

public class StepOne extends AppCompatActivity implements View.OnClickListener{
    TextView contentText;
    Button trueButton;
    Button invisibleButton;
    Set<Button> buttons = new HashSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one2);

        init();
    }

    private void init() {
        trueButton = findViewById(R.id.true_button);
        buttons.add(trueButton);
        invisibleButton = findViewById(R.id.invisible_button);
        buttons.add(invisibleButton);
        contentText = findViewById(R.id.content_text);

        for(Button button: buttons) {
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == trueButton)
            contentText.setVisibility(View.VISIBLE);
        else if(view == invisibleButton)
            contentText.setVisibility(View.INVISIBLE);
    }
}
