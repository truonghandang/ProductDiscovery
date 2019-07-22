package com.truonghd.productdiscovery.connection;

import com.truonghd.productdiscovery.model.ProductDetailsModel;
import com.truonghd.productdiscovery.model.ProductListingModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Truong.HanDang on 2019-07-17
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public interface ApiInterface {
    @GET("search/?channel=pv_online&visitorId=&terminal=cp02&_limit=20")
    Call<ProductListingModel> getDataSearch(@Query("q") String query);

    @GET("products/{PRODUCT_SKU}")
    Call<ProductDetailsModel> getDetailsData(@Path("PRODUCT_SKU") String productId);
}
