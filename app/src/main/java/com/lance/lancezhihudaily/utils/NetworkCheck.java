package com.lance.lancezhihudaily.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/25 0025.
 */

public class NetworkCheck {

    public static boolean checkNetWorkConnection(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            return true;
        }
        return false;
    }

    public static void noNetworkAlert(Context context) {
        Toast.makeText(context, "网络不可用", Toast.LENGTH_SHORT).show();
    }
}
