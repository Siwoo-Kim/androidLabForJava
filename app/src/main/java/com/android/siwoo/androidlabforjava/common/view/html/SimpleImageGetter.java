package com.android.siwoo.androidlabforjava.common.view.html;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Html;
import android.util.Log;

public class SimpleImageGetter implements Html.ImageGetter {
    private final Context context;

    public SimpleImageGetter(Context context) {
        this.context = context;
    }

    @Override
    public Drawable getDrawable(String source) {
        Log.d(this.getClass().toString(), "Debug resourceId: " + source);
        try {
            Integer resourceId = Integer.parseInt(source);
            Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), resourceId, null);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            return drawable;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
