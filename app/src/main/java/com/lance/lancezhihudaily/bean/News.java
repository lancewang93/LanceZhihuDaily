package com.lance.lancezhihudaily.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

public class News implements Serializable {

    private String id;

    private String title;

    private String image;

    public News(String id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
