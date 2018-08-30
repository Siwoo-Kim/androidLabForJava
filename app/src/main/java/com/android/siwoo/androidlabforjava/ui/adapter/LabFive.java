package com.android.siwoo.androidlabforjava.ui.adapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.database.AdapterDatabaseHelper;
import com.android.siwoo.androidlabforjava.common.database.DatabaseHelper;
import com.android.siwoo.androidlabforjava.common.view.adapter.DriveAdapter;
import com.android.siwoo.androidlabforjava.common.vo.Drive;

import java.util.ArrayList;
import java.util.List;

public class LabFive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_five2);
        ListView listView = findViewById(R.id.drive_list);

        SQLiteDatabase database = null;
        try {
            AdapterDatabaseHelper databaseHelper = new AdapterDatabaseHelper(this);
            database = databaseHelper.getWritableDatabase();
            Cursor cursor = database.rawQuery(" SELECT * FROM TBL_DRIVE ", null);

            List<Drive> data = new ArrayList<>();
            while (cursor.moveToNext()) {
                Drive drive = new Drive();
                drive.setType(cursor.getString(3));
                drive.setDate(cursor.getString(2));
                drive.setTitle(cursor.getString(1));
                data.add(drive);
            }
            DriveAdapter driveAdapter = new DriveAdapter(this, R.layout.drive_item, data);
            listView.setAdapter(driveAdapter);
        }finally {
            if(database != null) {
                database.close();
            }
        }

    }
}
