package com.lance.lancezhihudaily.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.lance.lancezhihudaily.bean.News;
import com.lance.lancezhihudaily.ui.fragment.NewsDetailFragment;

public class NewsDetailActivity extends SingleFragmentActivity {

    private static final String EXTRA_NEWS = "com.lance.lancezhihudaily.news";

    @Override
    protected Fragment createFragment() {
        News news = (News) getIntent().getSerializableExtra(EXTRA_NEWS);
        return NewsDetailFragment.newInstance(news);
    }

    public static Intent newIntent(Context context, News news) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(EXTRA_NEWS, news);
        return intent;
    }
}
