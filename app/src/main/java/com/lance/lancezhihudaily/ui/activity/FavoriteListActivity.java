package com.lance.lancezhihudaily.ui.activity;

import android.support.v4.app.Fragment;

import com.lance.lancezhihudaily.ui.fragment.FavoriteListFragment;

public class FavoriteListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FavoriteListFragment();
    }
}
