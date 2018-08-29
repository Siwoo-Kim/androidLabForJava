package com.android.siwoo.androidlabforjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;

import java.util.HashSet;
import java.util.Set;

public class LabOne extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private TextView bellText;
    private TextView labelText;
    private CheckBox repeatCheckbox;
    private CheckBox vibrateCheckbox;
    private Switch onOffSwitch;
    private Set<View> views = new HashSet<>();
    private float initX;
    private long initTime;
    private static final long THREE_SECONDS = 3000;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            initX = event.getRawX();
        } else if(event.getAction() == MotionEvent.ACTION_UP) {
            float diff = event.getRawX() - initX;
            if(diff>30) {
                toasting("Sliding to Right side");
            } else if(diff<-30) {
                toasting("Sliding to Left side");
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if(System.currentTimeMillis() - initTime > THREE_SECONDS) {
                toasting("Confirm to terminate the program, press BACK again.");
                initTime = System.currentTimeMillis();
            } else {
                finish();
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_one);
        
        init();
    }

    private void init() {
        bellText = findViewById(R.id.bell_name);
        views.add(bellText);
        labelText = findViewById(R.id.label);
        views.add(labelText);
        repeatCheckbox = findViewById(R.id.repeatCheck);
        views.add(repeatCheckbox);
        vibrateCheckbox = findViewById(R.id.vibrate);
        views.add(vibrateCheckbox);
        onOffSwitch = findViewById(R.id.onOff);
        views.add(onOffSwitch);

        for(View view: views) {
            if(view instanceof TextView) {
                view.setOnClickListener(this);
            }
            if(view instanceof CompoundButton) {
                ((CompoundButton) view).setOnCheckedChangeListener(this);
            }
        }
    }

    @Override
    public void onClick(View view) {
        if(view == bellText) {
            toasting("Bell is clicked");
        } else if(view == labelText){
            toasting("Label is clicked");
        }
    }

    private void toasting(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {
        if(button == repeatCheckbox) {
            toasting("Repeat : " + isChecked);
        } else if (button == vibrateCheckbox) {
            toasting("Vibrate : " + isChecked);
        } else if(button == onOffSwitch) {
            toasting("on or off : " + isChecked);
        }
    }
}
