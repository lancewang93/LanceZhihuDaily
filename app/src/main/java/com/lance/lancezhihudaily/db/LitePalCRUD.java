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

    public static void saveFavorite(News news) {
        News newsData = new News();
        newsData.setNewsId(news.getNewsId());
        newsData.setImage(news.getImage());
        newsData.setTitle(news.getTitle());
        newsData.setRead(news.isRead());
        newsData.save();
    }

    public static void deleteFavorite(News news) {
        DataSupport.deleteAll(News.class, "newsId = ?", news.getNewsId());
    }

    public static List<News> loadFavoriteList() {
        return DataSupport.findAll(News.class);
    }

    public static Boolean isFavorite(News news) {
        List<News> FavoriteList = DataSupport.where("newsId = ?", news.getNewsId()).find(News.class);
        return FavoriteList.size() != 0;
    }
}
