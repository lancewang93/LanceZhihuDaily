package com.lance.lancezhihudaily.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

public class News implements Serializable {

    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    private List<String> images;

    public News() {
    }

    public News(int id, String title, String images) {
        this.id = id;
        this.title = title;
        List<String> temp = new ArrayList<>();
        temp.add(images);
        this.images = temp;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
