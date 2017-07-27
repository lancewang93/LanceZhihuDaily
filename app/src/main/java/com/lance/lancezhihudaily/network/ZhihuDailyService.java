package com.lance.lancezhihudaily.network;

import com.lance.lancezhihudaily.bean.NewsDetail;
import com.lance.lancezhihudaily.bean.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/6/12 0012.
 */

public interface ZhihuDailyService {

    @GET("news/latest")
    Call<NewsList> getLatestNews();

    @GET("news/before/{date}")
    Call<NewsList> getBeforeNews(@Path("date") String date);

    @GET("news/{id}")
    Call<NewsDetail> getNewsDetail(@Path("id") int id);
}
