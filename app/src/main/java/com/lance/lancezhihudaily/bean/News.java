package com.lance.lancezhihudaily.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

public class News extends DataSupport implements Serializable {

    private String newsId;

    private String title;

    private String image;

    public News() {
    }

    public News(String newsId, String title, String image) {
        this.newsId = newsId;
        this.title = title;
        this.image = image;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
