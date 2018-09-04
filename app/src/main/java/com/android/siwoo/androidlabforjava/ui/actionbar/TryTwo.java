package com.android.siwoo.androidlabforjava.ui.actionbar;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.*;
import android.widget.ImageView;
import android.support.v7.widget.SearchView;
import android.widget.Toast;
import com.android.siwoo.androidlabforjava.R;

public class TryTwo extends AppCompatActivity {
    private SearchView menuSearch;
    private ImageView mainImg;
    private SearchView.OnQueryTextListener searchViewListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            if(query != null && !"".equals(query)) {
                menuSearch.setQuery("", false);
                menuSearch.setIconified(true);
                toasting(query);
            }
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_two);
        init();
    }

    private void init() {
        mainImg = findViewById(R.id.main_img);
        registerForContextMenu(mainImg);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.try_menu, menu);
        if(menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }
        menuSearch = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        String hint = getResources().getString(R.string.query_hint);
        menuSearch.setQueryHint(hint);
        menuSearch.setOnQueryTextListener(searchViewListener);
        return super.onCreateOptionsMenu(menu);
    }

    private static final String SEND_TO_SERVER = "Send To Server";
    private static final String SAVE_TO_LOCAL = "Save to local storage";
    private static final String DELETE_FROM_LOCAL = "Delete the image";
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        menu.add(0, 1, 0, SEND_TO_SERVER);
        menu.add(0, 2, 0, SAVE_TO_LOCAL);
        menu.add(0, 3, 0, DELETE_FROM_LOCAL);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int resourceId = item.getItemId();
        switch (resourceId) {
            case 1: toasting(SEND_TO_SERVER); break;
            case 2: toasting(SAVE_TO_LOCAL); break;
            case 3: toasting(DELETE_FROM_LOCAL);
        }
        return true;
    }

    private void toasting(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
