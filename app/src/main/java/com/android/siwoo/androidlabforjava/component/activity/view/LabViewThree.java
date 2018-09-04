package com.android.siwoo.androidlabforjava.component.activity.view;

import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.android.siwoo.androidlabforjava.R;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class LabViewThree extends AppCompatActivity {
    ImageView menuImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_view_three);

        menuImg = findViewById(R.id.menu_img);
        assertNotNull(menuImg);
        Log.d("menuImg.maxHeight", menuImg.getMaxHeight()+"");
    }
}
