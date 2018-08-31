package com.android.siwoo.androidlabforjava.ui.spannable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.view.html.SimpleImageGetter;

public class LabTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_two6);

        String html = "<font color='RED'>얼레지</font> <br/> <img src='" +R.drawable.bell +"' />  <br/> 곰배령에서 만난 불꽃";

        TextView htmlText = findViewById(R.id.html_text);
        htmlText.setText(Html.fromHtml(html, new SimpleImageGetter(this), null));

    }
}
