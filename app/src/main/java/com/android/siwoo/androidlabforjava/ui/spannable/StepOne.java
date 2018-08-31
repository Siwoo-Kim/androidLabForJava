package com.android.siwoo.androidlabforjava.ui.spannable;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

public class StepOne extends AppCompatActivity {
    private ScrollView mainScroll;
    private TextView simpleText;
    private TextView htmlText;
    private static final String SIMPLE_TEXT
            = "The title\n img \n I took the picture when I was in vacation";
    private static final String IMG_FLAG = "img";
    private static final String TITLE_FLAG = "The title";
    public static final String HTML_TEXT
            = "<font color='RED'>Flower</font> <br/> <img src='img2' /> <br/> I got this one, too!";
    Html.ImageGetter imageGetter = source -> {
        if(source.equals("img2")) {
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.img2, null);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            return drawable;
        }
        return null;
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one3);

        init();
        simpleText = findViewById(R.id.simple_text);
        simpleText.setMovementMethod(new ScrollingMovementMethod());

        SpannableStringBuilder builder = new SpannableStringBuilder(SIMPLE_TEXT);
        int start = SIMPLE_TEXT.indexOf(IMG_FLAG);
        if(start > -1) {
            int end = start + IMG_FLAG.length();
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.img1 , null);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            ImageSpan imageSpan = new ImageSpan(drawable);
            builder.setSpan(imageSpan, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }

        start = SIMPLE_TEXT.indexOf(TITLE_FLAG);
        if(start > -1) {
            int end = start + TITLE_FLAG.length() + 2;
            StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
            RelativeSizeSpan sizeSpan = new RelativeSizeSpan(2.f);
            builder.setSpan(styleSpan, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            builder.setSpan(sizeSpan, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }
        simpleText.setText(builder);

        htmlText = findViewById(R.id.html_text);
        htmlText.setText(Html.fromHtml(HTML_TEXT, imageGetter, null));
    }

    private void init() {
        initSimpleText();
    }

    private void initSimpleText() {

    }
}
