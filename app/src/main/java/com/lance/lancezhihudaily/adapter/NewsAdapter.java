package com.lance.lancezhihudaily.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lance.lancezhihudaily.R;
import com.lance.lancezhihudaily.bean.News;
import com.lance.lancezhihudaily.ui.activity.NewsDetailActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private List<News> mNewsList;
    private Context mContext;

    static class ViewHolder extends RecyclerView.ViewHolder{

        View latestNewsView;
        TextView latestNewsId;
        ImageView latestNewsImage;

        public ViewHolder(View itemView) {
            super(itemView);
            latestNewsView = itemView;
            latestNewsId = (TextView) itemView.findViewById(R.id.news_title);
            latestNewsImage = (ImageView) itemView.findViewById(R.id.image_id);
        }

    }
    public NewsAdapter(Context context, List<News> newsList) {
        mContext = context;
        mNewsList = newsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.latestNewsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                News news = mNewsList.get(position);
                Intent intent = NewsDetailActivity.newIntent(v.getContext(), news);
                v.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = mNewsList.get(position);
        holder.latestNewsId.setText(news.getTitle());
        Glide.with(mContext).load(news.getImage()).into(holder.latestNewsImage);

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void refreshNewsList(List<News> newsList) {
        mNewsList.addAll(newsList);
        notifyDataSetChanged();
    }
}
