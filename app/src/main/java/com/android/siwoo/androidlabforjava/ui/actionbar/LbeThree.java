package com.android.siwoo.androidlabforjava.ui.actionbar;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.Toast;
import com.android.siwoo.androidlabforjava.R;

public class LbeThree extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lbe_three);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add(0, 0, 0, "Slide show");
//        menu.add(0, 1, 0, "Add to Album");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.labmenu, menu);
        if(menu instanceof MenuBuilder) {
            MenuBuilder builder = (MenuBuilder) menu;
            builder.setOptionalIconsVisible(true);
        }

        MenuItem menuItem = menu.findItem(R.id.menu_search);
        Log.d("Siwoo", menuItem.getActionView().getClass().toString());
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Hint 1");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast toast = Toast.makeText(LbeThree.this, query, Toast.LENGTH_SHORT);
                toast.show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast toast = Toast.makeText(LbeThree.this, newText, Toast.LENGTH_SHORT);
                toast.show();
                return false;
            }
        });
        return false;
    }

}
