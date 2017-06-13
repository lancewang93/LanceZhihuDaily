package com.lance.lancezhihudaily.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lance.lancezhihudaily.R;
import com.lance.lancezhihudaily.asynctask.LoadNewsDetailTask;
import com.lance.lancezhihudaily.asynctask.NewsDetailTaskResponse;
import com.lance.lancezhihudaily.bean.News;
import com.lance.lancezhihudaily.bean.NewsDetail;
import com.lance.lancezhihudaily.db.DBDao;
import com.lance.lancezhihudaily.utils.HtmlUtil;

/**
 * Created by Administrator on 2017/5/28 0028.
 */

public class NewsDetailFragment extends Fragment implements NewsDetailTaskResponse,View.OnClickListener {

    private static final String ARG_NEWS = "mNews";

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageView mImageViewHeader;
    private TextView mTextViewTitle;
    private TextView mTextViewSource;
    private Toolbar mToolbarNewsDetail;
    private FloatingActionButton mFloatingFavorite;
    private WebView mWebView;

    public News mNews;
    public NewsDetail mNewsDetail;

    private LoadNewsDetailTask mLoadNewsDetailTask;
    private DBDao mDBDao;

    private boolean isFavorite = false;

    public static NewsDetailFragment newInstance(News news) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_NEWS, news);
        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        newsDetailFragment.setArguments(args);
        return newsDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNews = (News) getArguments().getSerializable(ARG_NEWS);
        mDBDao = new DBDao(getActivity());
        mLoadNewsDetailTask = new LoadNewsDetailTask();
        mLoadNewsDetailTask.setResponse(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_layout);
        mImageViewHeader = (ImageView) view.findViewById(R.id.image_view_header);
        mTextViewTitle = (TextView) view.findViewById(R.id.text_view_title);
        mTextViewSource = (TextView) view.findViewById(R.id.text_view_source);
        mToolbarNewsDetail = (Toolbar) view.findViewById(R.id.news_detail_toolbar);
        mFloatingFavorite = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        mWebView = (WebView) view.findViewById(R.id.web_view);

        isFavorite = mDBDao.isFavorite(mNews);
        if (isFavorite) {
            mFloatingFavorite.setImageResource(R.drawable.fav_active);
        } else {
            mFloatingFavorite.setImageResource(R.drawable.fav_normal);
        }
        initCollapsingToolBar();
        setWebView(mWebView);
        mLoadNewsDetailTask.execute(mNews.getNewsId());
        return view;
    }

    //设置WebView
    private void setWebView(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
    }

    //AsyncTask的监听器返回newsDetail数据
    @Override
    public void processFinish(NewsDetail newsDetail) {
        if (newsDetail != null) {
            mNewsDetail = newsDetail;
            //加载newsDetail数据
            loadNewsDetailData();
        }
    }

    //折叠标题栏的加载
    private void initCollapsingToolBar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mToolbarNewsDetail);
        mCollapsingToolbarLayout.setTitleEnabled(true);
    }

    //加载newsDetail数据的方法
    public void loadNewsDetailData() {
        Glide.with(getContext())
                .load(mNewsDetail.getImage())
                .into(mImageViewHeader);
        mTextViewTitle.setText(mNewsDetail.getTitle());
        mTextViewSource.setText(mNewsDetail.getImage_source());
        mWebView.setDrawingCacheEnabled(true);
        String htmlData = HtmlUtil.createHtmlData(mNewsDetail);
        mWebView.loadData(htmlData, HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
        //设置FloatingButton的点击监听器
        mFloatingFavorite.setOnClickListener(this);
    }

    //FloatingButton的点击后实现的逻辑
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatingActionButton:
                if (isFavorite) {
                    mDBDao.deleteFavorite(mNews);
                    mFloatingFavorite.setImageResource(R.drawable.fav_normal);
                    isFavorite = false;
                } else {
                    mDBDao.insertFavorite(mNews);
                    mFloatingFavorite.setImageResource(R.drawable.fav_active);
                    isFavorite = true;
                }
                break;
            default:
                break;
        }
    }
}