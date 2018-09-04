package com.android.siwoo.androidlabforjava.component.activity.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import com.android.siwoo.androidlabforjava.R;

import static junit.framework.Assert.assertNotNull;

public class LabViewFour extends AppCompatActivity {
    EditText userInput;
    EditText limitedUserInput;
    EditText phoneInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_view_four);
        userInput = findViewById(R.id.user_input);
        limitedUserInput = findViewById(R.id.limited_user_input);
        phoneInput = findViewById(R.id.phone_input);
        assertNotNull(limitedUserInput);
        assertNotNull(userInput);
        assertNotNull(phoneInput);
    }
}
