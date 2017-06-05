package com.lance.lancezhihudaily.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/24 0024.
 */

public class NewsDetail {

    //HTML 格式的新闻
    private String body;

    //图片的内容提供方。为了避免被起诉非法使用图片，在显示图片时最好附上其版权信息
    private String image_source;

    //新闻标题
    private String title;

    //获得的图片同[最新消息]获得的图片分辨率不同。这里获得的是在文章浏览界面中使用的大图
    private String image;

    //供在线查看内容与分享至 SNS 用的 URL
    private String share_url;

    //供 Google Analytics 使用
    private String ga_prefix;

    //栏目的信息
    private SectionBean section;

    //新闻的类型
    private int type;

    //新闻的 id
    private long id;

    //供手机端的 WebView(UIWebView) 使用
    private List<String> js;

    //[最新消息]中的缩略图
    private List<String> images;

    //供手机端的 WebView(UIWebView) 使用
    private List<String> css;

    public static class SectionBean {

        // 栏目的缩略图
        private String thumbnail;

        //该栏目的id
        private int id;

        //该栏目的名称
        private String name;

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public SectionBean getSection() {
        return section;
    }

    public void setSection(SectionBean section) {
        this.section = section;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getJs() {
        return js;
    }

    public void setJs(List<String> js) {
        this.js = js;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }
}