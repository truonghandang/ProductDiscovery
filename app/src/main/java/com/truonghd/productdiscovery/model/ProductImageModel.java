package com.truonghd.productdiscovery.model;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by Truong.HanDang on 2019-07-18
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ProductImageModel implements Serializable {
    private String url;
    private int priority;

    public ProductImageModel(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        if (url.contains(" ")) {
            url = url.replace(" ", "%20");
        }
        Log.d("ProductImageModel", "getImageUrl: " + url);
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
