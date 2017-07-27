package com.lance.lancezhihudaily.network;

import com.lance.lancezhihudaily.bean.NewsDetail;
import com.lance.lancezhihudaily.bean.NewsList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/6/16 0016.
 */

public class RetrofitManager {

    private static final String BASE_ZHIHU_URL = "http://news-at.zhihu.com/api/4/";

    private final ZhihuDailyService mService;

    public static RetrofitManager builder() {
        return new RetrofitManager();
    }

    private RetrofitManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_ZHIHU_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = retrofit.create(ZhihuDailyService.class);
    }

    public Call<NewsList> getLatestNews() {
        return mService.getLatestNews();
    }

    public Call<NewsList> getBeforeNews(String date) {
        return mService.getBeforeNews(date);
    }

    public Call<NewsDetail> getNewsDetail(int id) {
        return mService.getNewsDetail(id);
    }

}
