package com.lance.lancezhihudaily.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.lance.lancezhihudaily.bean.NewsDetail;
import com.lance.lancezhihudaily.http.ParseJSON;
import com.lance.lancezhihudaily.http.SendHttp;

/**
 * Created by mac on 15-2-3.
 */
public class LoadNewsDetailTask extends AsyncTask<String, Void, NewsDetail> {

    private NewsDetailTaskResponse mResponse = null;

    public void setResponse(NewsDetailTaskResponse response) {
       this.mResponse = response;
    }

    @Override
    protected NewsDetail doInBackground(String... params) {
        return ParseJSON.parseJSONToDetail(SendHttp.getNewsDetail(params[0]));
    }

    @Override
    protected void onPostExecute(NewsDetail newsDetail) {
        super.onPostExecute(newsDetail);
        if (mResponse != null) {
            mResponse.processFinish(newsDetail);
        } else {
            Log.d("tag", "onPostExecute-test");
        }
    }
}
