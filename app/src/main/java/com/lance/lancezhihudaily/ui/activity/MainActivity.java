package com.lance.lancezhihudaily.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lance.lancezhihudaily.R;
import com.lance.lancezhihudaily.adapter.NewsAdapter;
import com.lance.lancezhihudaily.asynctask.LoadNewsTask;
import com.lance.lancezhihudaily.bean.News;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<News> newsList = new ArrayList<>();
    private NewsAdapter adapter = new NewsAdapter(this, newsList);
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        new LoadNewsTask(adapter).execute();

    }

}
