package com.truonghd.productdiscovery.model;

/**
 * Created by Truong.Han on 2019-07-22.
 * VIETIS Corporation
 * truong.han@vietis.com.vn
 */
public class ProductStatusModel {
    private boolean publish;
    private String sale;

    private static final String PRODUCT_READY = "Hàng đang bán";
    private static final String PRODUCT_OUT_OF_STOCK = "Tạm hết hàng";

    public boolean getPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public String getSale() {
        if (publish) {
            return PRODUCT_READY;
        }
        return PRODUCT_OUT_OF_STOCK;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}
