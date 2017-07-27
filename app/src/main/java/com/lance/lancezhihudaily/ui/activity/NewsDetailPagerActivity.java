package com.lance.lancezhihudaily.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lance.lancezhihudaily.R;
import com.lance.lancezhihudaily.bean.News;
import com.lance.lancezhihudaily.ui.fragment.NewsDetailFragment;

import java.io.Serializable;
import java.util.List;

public class NewsDetailPagerActivity extends AppCompatActivity {

    public static final String EXTRA_NEWS = "com.lance.lancezhihudaily.mNews";
    public static final String EXTRA_NEWS_LIST = "com.lance.lancezhihudaily.news_list";

    private ViewPager mViewPager;
    private News mNews;
    private List<News> mNewsList;

    public static Intent newIntent(Context context, List<News> newsList, News news) {
        Intent intent = new Intent(context, NewsDetailPagerActivity.class);
        intent.putExtra(EXTRA_NEWS, news);
        intent.putExtra(EXTRA_NEWS_LIST, (Serializable) newsList);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail_pager);
        mViewPager = (ViewPager) findViewById(R.id.activity_news_detail_pager_view_pager);

        mNews = (News) getIntent().getSerializableExtra(EXTRA_NEWS);
        mNewsList = (List<News>) getIntent().getSerializableExtra(EXTRA_NEWS_LIST);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                News news = mNewsList.get(position);
                return NewsDetailFragment.newInstance(news);
            }

            @Override
            public int getCount() {
                return mNewsList.size();
            }
        };
        mViewPager.setAdapter(fragmentStatePagerAdapter);

        setCurrentItem();
    }

    private void setCurrentItem() {
        for (int i = 0; i < mNewsList.size(); i++) {
            if (mNewsList.get(i).getId() == (mNews.getId())) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
