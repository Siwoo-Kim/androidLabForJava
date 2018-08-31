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
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

public class LabThree extends AppCompatActivity {
    private Html.ImageGetter imageGetter = (source) -> {
        if("img1".equals(source)) {
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.img2, null);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            return drawable;
        }
        return null;
    };
    public static final String TEXT_1 = "복수초 \n img \n 이른봄 설산에서 만나는 복수초는 모든 야생화 찍사들의 로망";
    public static final String HTML_1 = "<font color='RED'>얼레지</font> <br/> <img src='img1' /> <br/> 곰배령에서 만난 봄꽃";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_three3);

        TextView spanText = findViewById(R.id.span_text);
        TextView htmlText = findViewById(R.id.html_text);
        spanText.setMovementMethod(new ScrollingMovementMethod());
        SpannableStringBuilder builder = new SpannableStringBuilder(TEXT_1);

        int start = TEXT_1.indexOf("img");
        if(start > -1) {
            int end = start + "img".length();
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.img1, null);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            ImageSpan imageSpan = new ImageSpan(drawable);
            builder.setSpan(imageSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        start = TEXT_1.indexOf("복수초");
        if(start > -1) {
            int end = start + "복수초".length() + 3;
            StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
            RelativeSizeSpan sizeSpan = new RelativeSizeSpan(2.0f);
            builder.setSpan(styleSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(sizeSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        spanText.setText(builder);

        htmlText.setText(Html.fromHtml(HTML_1, imageGetter, null));
    }
}
