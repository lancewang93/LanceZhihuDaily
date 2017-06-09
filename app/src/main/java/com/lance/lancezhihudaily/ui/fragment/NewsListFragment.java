package com.lance.lancezhihudaily.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lance.lancezhihudaily.R;
import com.lance.lancezhihudaily.asynctask.LoadNewsTask;
import com.lance.lancezhihudaily.bean.News;
import com.lance.lancezhihudaily.ui.activity.FavoriteListActivity;
import com.lance.lancezhihudaily.ui.adapter.NewsAdapter;
import com.lance.lancezhihudaily.utils.MyApp;
import com.lance.lancezhihudaily.utils.NetworkCheck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/28 0028.
 */

public class NewsListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private List<News> mNewsList;
    private NewsAdapter mNewsAdapter;
    private SwipeRefreshLayout mSwipeRefresh;

    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNewsList = new ArrayList<>();
        mNewsAdapter = new NewsAdapter(getContext(), mNewsList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.news_list_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        mSwipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefresh.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.news_list_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mNewsAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);

        if (NetworkCheck.checkNetWorkConnection(MyApp.getContext())) {
            new LoadNewsTask(mNewsAdapter).execute();
        } else {
            NetworkCheck.noNetworkAlert(getContext());
        }
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.news_list_toolbar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_bar_favourite:
                Intent intent = new Intent(getContext(), FavoriteListActivity.class);
                startActivity(intent);
                break;
            case R.id.action_settings:
                Toast.makeText(getContext(), "你点击了Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onRefresh() {
        if (NetworkCheck.checkNetWorkConnection(MyApp.getContext())) {
            new LoadNewsTask(mNewsAdapter).execute();
        } else {
            NetworkCheck.noNetworkAlert(getContext());
        }
        mSwipeRefresh.setRefreshing(false);
    }
}
