package com.lance.lancezhihudaily.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/6/12 0012.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String CREATE_TABLE_READ = "create table read (newsId text, title text, image text)";
    private static final String CREATE_TABLE_FAVORITE = "create table favorite (newsId text, title text, image text)";

    private static DBHelper sDBHelper;

    private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static DBHelper getDBHelper(Context context) {
        if (sDBHelper == null) {
            synchronized (DBHelper.class) {
                if (sDBHelper == null) {
                    sDBHelper = new DBHelper(context, "NewRF.db", null, 1);
                }
            }
        }
        return sDBHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_READ);
        db.execSQL(CREATE_TABLE_FAVORITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
