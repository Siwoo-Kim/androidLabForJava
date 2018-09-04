package com.android.siwoo.androidlabforjava.component.activity.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.android.siwoo.androidlabforjava.R;

import static org.junit.Assert.assertEquals;

public class LabViewFive extends AppCompatActivity {
    CheckBox simpleCheckbox;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_view_five);
        simpleCheckbox = findViewById(R.id.simple_checkbox);
        radioGroup = findViewById(R.id.radio_group);

        simpleCheckbox.setOnClickListener(v -> {
            String text = simpleCheckbox.isChecked()? "Checked": "Unchecked";
            simpleCheckbox.setText(text);
        });

        radioGroup.check(R.id.radio_button1);
        assertEquals(radioGroup.getCheckedRadioButtonId(), R.id.radio_button1);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast toast = Toast.makeText(LabViewFive.this, checkedId + " is clicked", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
