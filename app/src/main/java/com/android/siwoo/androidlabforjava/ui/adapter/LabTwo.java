package com.android.siwoo.androidlabforjava.ui.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.android.siwoo.androidlabforjava.R;

public class LabTwo extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_two5);

        ListView itemList = findViewById(R.id.item_list);
        String[] data = { "Seoul", "Busan", "Toronto", "Vancubur" };
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.item_list, R.id.item_name, data);
        itemList.setAdapter(arrayAdapter);

        itemList.setOnItemClickListener(this);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast toast = Toast.makeText(this, view.getId() +":"+position+":"+id +" clicked", Toast.LENGTH_SHORT);
        toast.show();
    }

}
