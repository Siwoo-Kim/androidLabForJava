package com.android.siwoo.androidlabforjava.ui.actionbar;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.SearchView;
import android.view.*;
import android.widget.ImageView;
import android.widget.Toast;
import com.android.siwoo.androidlabforjava.R;

public class StepTwo extends AppCompatActivity {

    private SearchView menuSearch;
    private ImageView actionImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two2);

        actionImg = findViewById(R.id.action_img);
        registerForContextMenu(actionImg);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_lab2, menu);
        if(menu instanceof MenuBuilder) {
            MenuBuilder builder = (MenuBuilder) menu;
            builder.setOptionalIconsVisible(true);
        }

        menuSearch = (SearchView) menu.findItem(R.id.menu_search)
                .getActionView();
        menuSearch.setQueryHint(getResources().getString(R.string.query_hint));
        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                menuSearch.setQuery("", false);
                menuSearch.setIconified(true);
                toasting(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        };
        menuSearch.setOnQueryTextListener(queryTextListener);
        return true;
    }

    private void toasting(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Send to Server");
        menu.add(0, 1, 0, "Save to local storage");
        menu.add(0, 2, 0, "Delete the image");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                toasting("Sending to server was successful"); break;
            case 1:
                toasting("Saving the image was successful"); break;
            case 2:
                toasting("Deleting the image was successful"); break;
        }
        return true;
    }

}
