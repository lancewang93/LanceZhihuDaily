package com.lance.lancezhihudaily.utils;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

/**
 * Created by Administrator on 2017/5/24 0024.
 */

public class MyApp extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        LitePal.initialize(sContext);
    }

    public static Context getContext() {
        return sContext;
    }
}
