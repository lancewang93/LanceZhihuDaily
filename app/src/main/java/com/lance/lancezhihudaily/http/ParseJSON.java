package com.lance.lancezhihudaily.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lance.lancezhihudaily.bean.News;
import com.lance.lancezhihudaily.bean.NewsDetail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public class ParseJSON {

    public static List<News> parseJSONToList(String jsonData) {
        List<News> newsList = new ArrayList<>();
        try {
            JSONObject newsContent = new JSONObject(jsonData);
            JSONArray newsArray = newsContent.getJSONArray("stories");
            for (int i = 0; i < newsArray.length(); i++) {
                JSONObject newsInJson = newsArray.getJSONObject(i);
                String id = newsInJson.optString("id");
                String title = newsInJson.optString("title");
                String image = "";
                if (newsInJson.has("images")) {
                    image = (String) newsInJson.getJSONArray("images").get(0);
                }
                News news = new News(id, title, image);
                newsList.add(news);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    public static NewsDetail parseJSONToDetail(String jsonData) {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, new TypeToken<NewsDetail>() {
        }.getType());
    }
}
