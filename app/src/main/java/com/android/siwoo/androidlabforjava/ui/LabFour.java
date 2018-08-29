package com.android.siwoo.androidlabforjava.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.siwoo.androidlabforjava.R;

public class LabFour extends AppCompatActivity implements View.OnClickListener{
    TextView clickText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_four);

        clickText = findViewById(R.id.click_text);
        clickText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(clickText)) {
            Toast toast = Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
