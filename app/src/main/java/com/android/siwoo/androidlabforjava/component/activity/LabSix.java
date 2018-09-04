package com.android.siwoo.androidlabforjava.component.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

import static junit.framework.Assert.assertNotNull;

public class LabSix extends AppCompatActivity {

    TextView clickableText;
    ImageView startImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_six2);

        clickableText = findViewById(R.id.clickableText);
        assertNotNull(clickableText);
        clickableText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickableText.setText("Clicked");
                int toggleVisibility = startImg.getVisibility() == View.VISIBLE? View.INVISIBLE: View.VISIBLE;
                startImg.setVisibility(toggleVisibility);
            }
        });

        startImg = findViewById(R.id.starImg);

    }
}
