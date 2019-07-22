package com.truonghd.productdiscovery.model;

import android.annotation.SuppressLint;

import com.truonghd.productdiscovery.utils.CommonUtils;

/**
 * Created by Truong.HanDang on 2019-07-18
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ProductPriceModel {
    private long supplierSalePrice;
    private long sellPrice;

    public String getSupplierSalePrice() {
        return CommonUtils.formatNumber(String.valueOf(supplierSalePrice));
    }

    public void setSupplierSalePrice(long supplierSalePrice) {
        this.supplierSalePrice = supplierSalePrice;
    }

    public String getSellPrice() {
        return CommonUtils.formatNumber(String.valueOf(sellPrice));
    }

    public void setSellPrice(long sellPrice) {
        this.sellPrice = sellPrice;
    }

    @SuppressLint("DefaultLocale")
    public String getPercentSaleOff() {
        if (supplierSalePrice == 0) {
            return "";
        }
        long percentOff = (sellPrice / supplierSalePrice) * 100;

        return String.format("-%d%%", percentOff);
    }

    public boolean isSaleOff() {
        return supplierSalePrice != sellPrice;
    }
}
