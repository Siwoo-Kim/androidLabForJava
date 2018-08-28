package com.android.siwoo.androidlabforjava.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.vo.Memo;
import io.realm.Realm;

public class LabThreeSecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_three_second);

        TextView titleView = findViewById(R.id.realm_read_title);
        TextView contentView = findViewById(R.id.realm_read_content);

        String title = getIntent().getStringExtra("title");

        Realm realm = Realm.getDefaultInstance();
        Memo memo = realm.where(Memo.class)
                .equalTo("title", title)
                .findFirst();

        titleView.setText(memo.getTitle());
        contentView.setText(memo.getContent());
    }
}
