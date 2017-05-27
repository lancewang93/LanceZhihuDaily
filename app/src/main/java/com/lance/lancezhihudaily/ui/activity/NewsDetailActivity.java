package com.lance.lancezhihudaily.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.lance.lancezhihudaily.R;
import com.lance.lancezhihudaily.asynctask.LoadNewsDetailTask;
import com.lance.lancezhihudaily.bean.News;

public class NewsDetailActivity extends Activity {

    private WebView mWebView;
    private News news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        mWebView = (WebView) findViewById(R.id.web_view);
        setWebView(mWebView);

        news = (News) getIntent().getSerializableExtra("news");
        new LoadNewsDetailTask(mWebView).execute(news.getId());
    }

    private void setWebView(WebView webView) {
//        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
    }

    public static void startActivity(Context context, News news) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra("news", news);
        context.startActivity(intent);
    }
}
