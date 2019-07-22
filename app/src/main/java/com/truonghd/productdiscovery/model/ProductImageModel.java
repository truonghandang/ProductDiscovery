package com.truonghd.productdiscovery.model;

/**
 * Created by Truong.HanDang on 2019-07-18
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ProductImageModel {
    private String url;
    private int priority;

    public String getImageUrl() {
        return url;
    }

    public void setImageUrl(String url) {
        this.url = url;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
