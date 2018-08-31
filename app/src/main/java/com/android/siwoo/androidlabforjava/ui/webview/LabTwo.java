package com.android.siwoo.androidlabforjava.ui.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.*;
import android.widget.Button;
import android.widget.Toast;
import com.android.siwoo.androidlabforjava.R;

import java.util.HashSet;
import java.util.Set;

public class LabTwo extends AppCompatActivity implements View.OnClickListener {
    private Set<View> views = new HashSet<>();
    private WebView textWeb;
    private Button lineButton;
    private Button barButton;

    private class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Toast toast = Toast.makeText(LabTwo.this, url, Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
    }

    private class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Toast toast = Toast.makeText(LabTwo.this, message, Toast.LENGTH_SHORT);
            toast.show();
            result.confirm();
            return true;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_two7);

        textWeb = findViewById(R.id.test_web);
        views.add(textWeb);
        lineButton = findViewById(R.id.line_button);
        barButton = findViewById(R.id.bar_button);

        for(View view: views) {
            if(view instanceof Button) {
                view.setOnClickListener(this);
            }
        }

        WebSettings webSettings = textWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        textWeb.loadUrl("file:///android_asset/test.html");
        textWeb.setWebViewClient(new WebViewClient());
        textWeb.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onClick(View view) {
        if(view == lineButton) {
            textWeb.loadUrl("javascript:lineChart()");
        }else if(view == barButton) {
            textWeb.loadUrl("javascript:barChart()");
        }
    }

    private class JavascriptTest {
        @JavascriptInterface
        public String getChartData() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for(int i=0; i<14; i++) {
                stringBuilder.append("[" + i +"," +Math.sin(i)+"]");
                Log.d("Siwoo", i + "," + Math.sin(i) );
                if(i<13) stringBuilder.append(",");
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }


}
