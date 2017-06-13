package com.lance.lancezhihudaily.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lance.lancezhihudaily.R;
import com.lance.lancezhihudaily.bean.News;
import com.lance.lancezhihudaily.db.DBDao;
import com.lance.lancezhihudaily.ui.adapter.NewsAdapter;

import java.util.List;

import static com.lance.lancezhihudaily.R.id.favorite_list_recycler_view;

/**
 * Created by Administrator on 2017/6/5 0005.
 */

public class FavoriteListFragment extends Fragment {

    private List<News> mFavoriteList;
    private NewsAdapter mFavoriteAdapter;
    private Toolbar mFavoriteToolbar;
    private RecyclerView mFavoriteRecyclerView;

    private DBDao mDBDao;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDBDao = new DBDao(getActivity());
        mFavoriteList = mDBDao.getFavoriteList();
        mFavoriteAdapter = new NewsAdapter(getContext(), mFavoriteList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_list, container, false);
        //加载收藏页面的ToolBar
        mFavoriteToolbar = (Toolbar) view.findViewById(R.id.favorite_list_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mFavoriteToolbar);

        mFavoriteRecyclerView = (RecyclerView) view.findViewById(favorite_list_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mFavoriteRecyclerView.setLayoutManager(layoutManager);
        mFavoriteRecyclerView.setAdapter(mFavoriteAdapter);
        mFavoriteRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFavoriteRecyclerView.setHasFixedSize(true);
        return view;
    }
}
