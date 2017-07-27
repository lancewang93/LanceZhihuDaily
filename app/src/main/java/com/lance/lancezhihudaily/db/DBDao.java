package com.lance.lancezhihudaily.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lance.lancezhihudaily.bean.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12 0012.
 */

public class DBDao {

    private DBHelper mHelper;

    public DBDao(Context context) {
        mHelper = DBHelper.getDBHelper(context);
    }

    public void insertFavorite(News news) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("newsId", news.getId());
        values.put("title", news.getTitle());
        values.put("image", news.getImages().get(0));
        db.insert("favorite", null, values);
    }

    public void deleteFavorite(News news) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.delete("favorite", "newsId = ?", new String[]{news.getId() + ""});
    }

    public boolean isFavorite(News news) {
        List<News> favoriteList = getFavoriteList();
        for (News favoriteNews :
                favoriteList) {
            if (favoriteNews.getId() == (news.getId())) {
                return true;
            }
        }
        return false;
    }

    public List<News> getFavoriteList() {
        List<News> favoriteList = new ArrayList<>();
        SQLiteDatabase db = mHelper.getWritableDatabase();
        Cursor cursor = db.query("favorite", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("newsId"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                News news = new News(id, title, image);
                favoriteList.add(news);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return favoriteList;
    }

    public void insertRead(News news) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("newsId", news.getId());
        values.put("title", news.getTitle());
        values.put("image", news.getImages().get(0));
        db.insert("read", null, values);
    }

    public List<News> getReadList() {
        List<News> readList = new ArrayList<>();
        SQLiteDatabase db = mHelper.getWritableDatabase();
        Cursor cursor = db.query("read", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("newsId"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                News news = new News(id, title, image);
                readList.add(news);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return readList;
    }

    public boolean isRead(News news) {
        List<News> readList = getReadList();
        for (News readNews :
                readList) {
            if (readNews.getId() == (news.getId())) {
                return true;
            }
        }
        return false;
    }
}
