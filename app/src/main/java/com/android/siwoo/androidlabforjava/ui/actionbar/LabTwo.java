package com.android.siwoo.androidlabforjava.ui.actionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.android.siwoo.androidlabforjava.R;

public class LabTwo extends AppCompatActivity{
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_two9);

        actionBar = getSupportActionBar();
        // 아이콘을 Up 이미지로 표시 설정
        actionBar.setDisplayShowHomeEnabled(true);
        // Home 아이콘 표시 설정
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.icon);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            Toast toast = Toast.makeText(this, "HOE AS UP Click", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
