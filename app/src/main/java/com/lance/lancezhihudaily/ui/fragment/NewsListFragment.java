package com.lance.lancezhihudaily.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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
import com.lance.lancezhihudaily.adapter.NewsAdapter;
import com.lance.lancezhihudaily.asynctask.LoadNewsTask;
import com.lance.lancezhihudaily.bean.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/28 0028.
 */

public class NewsListFragment extends Fragment {

    private List<News> newsList = new ArrayList<>();
    private NewsAdapter adapter;
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsList = new ArrayList<>();
        adapter = new NewsAdapter(getContext(), newsList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        new LoadNewsTask(adapter).execute();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.toolbar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_bar_favourite:
                Toast.makeText(getContext(), "你点击了Favourite", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(getContext(), "你点击了Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
