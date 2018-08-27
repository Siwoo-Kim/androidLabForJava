package com.android.siwoo.androidlabforjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LabTwo extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_two);

        imageView = findViewById(R.id.img);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.in);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                /*Ignore*/
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation _animation = AnimationUtils.loadAnimation(LabTwo.this, R.anim.move);
                //_animation.setFillAfter(true);
                imageView.startAnimation(_animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                /*Ignore*/
            }
        });

        imageView.startAnimation(animation);
    }
}
