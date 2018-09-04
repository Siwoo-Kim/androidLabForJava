package com.android.siwoo.androidlabforjava.ui.actionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.android.siwoo.androidlabforjava.R;

public class TryOne extends AppCompatActivity {
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_one);
        init();
    }

    private void init() {
        initActionBar();

    }

    private void initActionBar() {
        actionBar = getSupportActionBar();
        //Enable HomeAsUp (arrow icon)
        actionBar.setDisplayHomeAsUpEnabled(true);
        //Enable Home Icon
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.icon);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home) {
            toasting("HOME AS UP (ARROW) IS CLICKED");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toasting(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }
}
