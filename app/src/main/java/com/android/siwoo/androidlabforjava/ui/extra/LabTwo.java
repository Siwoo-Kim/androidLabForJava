package com.android.siwoo.androidlabforjava.ui.extra;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import com.android.siwoo.androidlabforjava.R;

public class LabTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_two8);

        ProgressBar progressBar = findViewById(R.id.stick_progress);

        Runnable progressThread = () -> {
            for(int i=0;i<10;i++) {
                SystemClock.sleep(1000);
                progressBar.incrementSecondaryProgressBy(10);
                if(i == 0) continue;
                progressBar.incrementProgressBy(10);
            }
            progressBar.incrementProgressBy(10);
        };
        new Thread(progressThread).start();
    }
}
