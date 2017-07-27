package com.lance.lancezhihudaily.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

public class NewsList {

    private String date;
    private List<News> stories;
    private List<TopNews> top_news;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<News> getStories() {
        return stories;
    }

    public void setStories(List<News> stories) {
        this.stories = stories;
    }

    public List<TopNews> getTop_news() {
        return top_news;
    }

    public void setTop_news(List<TopNews> top_news) {
        this.top_news = top_news;
    }
}
