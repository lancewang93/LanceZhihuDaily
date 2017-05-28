package com.lance.lancezhihudaily.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.lance.lancezhihudaily.R;
import com.lance.lancezhihudaily.asynctask.LoadNewsDetailTask;
import com.lance.lancezhihudaily.bean.News;

/**
 * Created by Administrator on 2017/5/28 0028.
 */

public class NewsDetailFragment extends Fragment {

    private static final String ARG_NEWS = "news";

    private WebView mWebView;
    public News news;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        news = (News) getArguments().getSerializable(ARG_NEWS);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        mWebView = (WebView) view.findViewById(R.id.web_view);
        setWebView(mWebView);

        new LoadNewsDetailTask(mWebView).execute(news.getId());
        return view;
    }

    private void setWebView(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
//      webView.getSettings().setSupportZoom(true);
    }

    public static NewsDetailFragment newInstance(News news) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_NEWS, news);

        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        newsDetailFragment.setArguments(args);
        return newsDetailFragment;
    }
}

