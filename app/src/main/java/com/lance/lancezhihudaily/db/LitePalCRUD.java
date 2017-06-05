package com.lance.lancezhihudaily.db;

import com.lance.lancezhihudaily.bean.News;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

public class LitePalCRUD {

    public static void createDataBase() {
        Connector.getDatabase();
    }

    public static void saveFavorite(String newsId) {
        News news = new News();
        news.setId(newsId);
        news.save();
    }

    public static void deleteFavorite(String newsId) {
        DataSupport.deleteAll(News.class, "newsId = ?", newsId);
    }

    public static List<News> loadFavoriteList() {
        return DataSupport.findAll(News.class);
    }

    public static Boolean isFavorite(News news) {
        List<News> isFavorite = DataSupport.where("newsId = ?", news.getId()).find(News.class);
        return isFavorite != null;
    }
}
