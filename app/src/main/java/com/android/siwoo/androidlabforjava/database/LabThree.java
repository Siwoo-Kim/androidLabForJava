package com.android.siwoo.androidlabforjava.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.vo.Memo;
import io.realm.Realm;

public class LabThree extends AppCompatActivity implements View.OnClickListener {
    EditText titleView;
    EditText contentView;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_three);

        titleView = findViewById(R.id.realm_add_title);
        contentView = findViewById(R.id.realm_add_content);
        addButton = findViewById(R.id.realm_add_btn);
        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Realm.init(this);
        final Realm realm = Realm.getDefaultInstance();
        String title = titleView.getText().toString();
        String content = contentView.getText().toString();

        realm.executeTransaction((_realm) -> {
            Memo memo = _realm.createObject(Memo.class);
            memo.setTitle(title);
            memo.setContent(content);
        });

        Intent intent = new Intent(this, LabThreeSecond.class);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
