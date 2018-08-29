package com.android.siwoo.androidlabforjava.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

import java.util.HashSet;
import java.util.Set;

public class LabFive extends AppCompatActivity implements View.OnClickListener{
    private TextView contentText;
    private Button trueButton;
    private Button invisibleButton;
    private Button goneButton;
    private Set<Button> buttons = new HashSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_five);
        init();

    }

    private void init() {
        contentText = findViewById(R.id.content_text);
        trueButton = findViewById(R.id.true_button);
        buttons.add(trueButton);
        invisibleButton = findViewById(R.id.invisible_button);
        buttons.add(invisibleButton);
        goneButton = findViewById(R.id.gone_button);
        buttons.add(goneButton);

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
        else if(view == goneButton)
            contentText.setVisibility(View.GONE);
    }
}
