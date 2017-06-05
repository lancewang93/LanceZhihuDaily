package com.lance.lancezhihudaily.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lance.lancezhihudaily.R;
import com.lance.lancezhihudaily.bean.News;
import com.lance.lancezhihudaily.db.LitePalCRUD;
import com.lance.lancezhihudaily.ui.adapter.NewsAdapter;

import java.util.List;

import static com.lance.lancezhihudaily.R.id.favorite_list_recycler_view;

/**
 * Created by Administrator on 2017/6/5 0005.
 */

public class FavoriteListFragment extends Fragment {

    private List<News> FavoriteList;
    private NewsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (FavoriteList == null) {
            LitePalCRUD.createDataBase();
        }
            FavoriteList = LitePalCRUD.loadFavoriteList();
        adapter = new NewsAdapter(getContext(), FavoriteList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(favorite_list_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //
        return view;
    }
}
