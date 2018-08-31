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

public class StepOne extends AppCompatActivity implements View.OnClickListener{

    private Set<View> views = new HashSet<>();
    private WebView chartWeb;
    private Button lineButton;
    private Button barButton;
    private static final String HTML_LOCATION = "file:///android_asset/test.html";
    private final class JavascriptHelper {
        @JavascriptInterface
        public String getChartData() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for(int i=0; i<14; i++) {
                builder.append("[" + i + "," + Math.sin(i) + "]");
                Log.d(this.getClass().getName(), "[" + i + "," + Math.sin(i) + "]");
                if(i<13) builder.append(",");
            }
            return builder.toString();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one4);

        init();
    }

    private void init() {
        chartWeb = findViewById(R.id.chart_web);
        views.add(chartWeb);
        lineButton = findViewById(R.id.line_button);
        views.add(lineButton);
        barButton = findViewById(R.id.bar_button);
        views.add(barButton);

        for(View view: views) {
            if(view instanceof Button) {
                view.setOnClickListener(this);
            }
        }

        WebSettings settings = chartWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        chartWeb.loadUrl(HTML_LOCATION);
        chartWeb.addJavascriptInterface(new JavascriptHelper(), "android");
        chartWeb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Toast toast = Toast.makeText(StepOne.this, url, Toast.LENGTH_SHORT);
                toast.show();
                return true;
            };
        });
        chartWeb.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                Toast toast = Toast.makeText(StepOne.this, message, Toast.LENGTH_SHORT);
                toast.show();
                result.confirm();
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view == lineButton) {
            chartWeb.loadUrl("javascript:lineChart()");
        } else if(view == barButton) {
            chartWeb.loadUrl("javascript:barChart()");
        }
    }
}
