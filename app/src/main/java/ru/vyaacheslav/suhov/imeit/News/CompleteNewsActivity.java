package ru.vyaacheslav.suhov.imeit.News;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import ru.vyaacheslav.suhov.imeit.R;


public class CompleteNewsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_news);

        String newsUrl= getIntent().getStringExtra("newsURL");
        WebView webView= (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(newsUrl);
    }

}

