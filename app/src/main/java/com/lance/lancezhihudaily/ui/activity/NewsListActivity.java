package com.lance.lancezhihudaily.ui.activity;

import android.support.v4.app.Fragment;

import com.lance.lancezhihudaily.ui.fragment.NewsListFragment;

public class NewsListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new NewsListFragment();
    }
}
