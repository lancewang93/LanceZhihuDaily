package com.lance.lancezhihudaily.http;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

public class SendHttp {

    private static final String LATESTNEWS = "http://news-at.zhihu.com/api/4/news/latest";

    private static final String NEWSDETAIL = "http://news-at.zhihu.com/api/4/news/";

    private static String sendRequestWithOkHttp(String address) {

        String responseData = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        try {
            Response response = client.newCall(request).execute();
            responseData = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseData;
    }

    public static String getLastNewsList() {
        return sendRequestWithOkHttp(LATESTNEWS);
    }

    public static String getNewsDetail(String newsDetailId) {
        return sendRequestWithOkHttp(NEWSDETAIL + newsDetailId);
    }
}
