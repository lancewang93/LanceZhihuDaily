package com.lance.lancezhihudaily.asynctask;

import android.os.AsyncTask;
import android.webkit.WebView;

import com.lance.lancezhihudaily.bean.NewsDetail;
import com.lance.lancezhihudaily.http.ParseJSON;
import com.lance.lancezhihudaily.http.SendHttp;

/**
 * Created by mac on 15-2-3.
 */
public class LoadNewsDetailTask extends AsyncTask<String, Void, NewsDetail> {
    private WebView mWebView;

    public LoadNewsDetailTask(WebView mWebView) {
        this.mWebView = mWebView;
    }

    @Override
    protected NewsDetail doInBackground(String... params) {
        return ParseJSON.parseJSONToDetail(SendHttp.getNewsDetail(params[0]));
    }

    @Override
    protected void onPostExecute(NewsDetail mNewsDetail) {
        String headerImage;
        if (mNewsDetail.getImage() == null || mNewsDetail.getImage().equals("")) {
            headerImage = "file:///android_asset/news_detail_header_image.jpg";

        } else {
            headerImage = mNewsDetail.getImage();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"img-wrap\">")
                .append("<h1 class=\"headline-title\">")
                .append(mNewsDetail.getTitle()).append("</h1>")
                .append("<span class=\"img-source\">")
                .append(mNewsDetail.getImage_source()).append("</span>")
                .append("<img src=\"").append(headerImage)
                .append("\" alt=\"\">")
                .append("<div class=\"img-mask\"></div>");
        String mNewsContent = "<link rel=\"stylesheet\" type=\"text/css\" href=\"news_content_style.css\"/>"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"news_header_style.css\"/>"
                + mNewsDetail.getBody().replace("<div class=\"img-place-holder\">", sb.toString());
        mWebView.loadDataWithBaseURL("file:///android_asset/", mNewsContent, "text/html", "UTF-8", null);
    }
}
