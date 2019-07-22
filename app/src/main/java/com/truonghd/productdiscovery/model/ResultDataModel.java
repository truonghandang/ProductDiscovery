package com.truonghd.productdiscovery.model;

import java.util.ArrayList;

/**
 * Created by Truong.HanDang on 2019-07-18
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ResultDataModel {
    private ArrayList<ProductModel> products;

    public ArrayList<ProductModel> getListProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductModel> products) {
        this.products = products;
    }
}
