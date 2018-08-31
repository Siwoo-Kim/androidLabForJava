package com.android.siwoo.androidlabforjava.ui.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.android.siwoo.androidlabforjava.R;

public class LabOne extends AppCompatActivity {
    private static final String URL_DAUM = "http://m.daum.net";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_one8);

        WebView webView = findViewById(R.id.test_web);
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webView.loadUrl(URL_DAUM);
        webView.loadUrl("file:///android_asset/test.html");
    }
}
