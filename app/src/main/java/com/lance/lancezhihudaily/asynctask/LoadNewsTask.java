package com.lance.lancezhihudaily.asynctask;

import android.os.AsyncTask;

import com.lance.lancezhihudaily.adapter.NewsAdapter;
import com.lance.lancezhihudaily.bean.News;
import com.lance.lancezhihudaily.http.ParseJSON;
import com.lance.lancezhihudaily.http.SendHttp;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

public class LoadNewsTask extends AsyncTask<Void, Void, List<News>> {

    private NewsAdapter mAdapter;

    public LoadNewsTask(NewsAdapter adapter) {
        mAdapter = adapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<News> doInBackground(Void... params) {
        List<News> newsList;
        newsList = ParseJSON.parseJSONToList(SendHttp.getLastNewsList());
        return newsList;
    }

    @Override
    protected void onPostExecute(List<News> newsList) {
        mAdapter.refreshNewsList(newsList);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
