package com.truonghd.productdiscovery.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Truong.HanDang on 2019-07-18
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ProductModel {
    private String displayName;
    private String name;
    @SerializedName("sku")
    private String productId;
    @SerializedName("url")
    private String productUrl;
    private ArrayList<ProductImageModel> images;
    private ProductPriceModel price;
    private ProductStatusModel status;
    private ArrayList<AttributeModel> attributeGroups;

    public String getName() {
        if (!displayName.isEmpty()) {
            return displayName;
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public ArrayList<ProductImageModel> getImages() {
        return images;
    }

    public ProductImageModel getImage() {
        if (images.size() == 0) {
            return null;
        }
        return images.get(0);
    }

    public void setImages(ArrayList<ProductImageModel> images) {
        this.images = images;
    }

    public ProductPriceModel getPrice() {
        return price;
    }

    public void setPrice(ProductPriceModel price) {
        this.price = price;
    }

    public ProductStatusModel getStatus() {
        return status;
    }

    public void setStatus(ProductStatusModel status) {
        this.status = status;
    }

    public ArrayList<AttributeModel> getAttributeGroups() {
        return attributeGroups;
    }

    public void setAttributeGroups(ArrayList<AttributeModel> attributeGroups) {
        this.attributeGroups = attributeGroups;
    }
}
