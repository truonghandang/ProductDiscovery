package com.truonghd.productdiscovery.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.truonghd.productdiscovery.connection.ApiClient;
import com.truonghd.productdiscovery.model.ProductListingModel;
import com.truonghd.productdiscovery.model.ProductModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Truong.HanDang on 2019-07-18
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ProductListingVM extends ViewModel {
    private ArrayList<ProductModel> mProductsList = new ArrayList<>();
    private IRequestApiCallBack mRequestApiCallBack;

    public ProductListingVM() {
        getDataFromServer();
    }

    public void setRequestApiCallBack(IRequestApiCallBack mRequestApiCallBack) {
        this.mRequestApiCallBack = mRequestApiCallBack;
    }

    private void getDataFromServer() {
        Call<ProductListingModel> call = ApiClient.getInstance().getApi().getDataSearch("");
        call.enqueue(new Callback<ProductListingModel>() {
            @Override
            public void onResponse(@NonNull Call<ProductListingModel> call, @NonNull Response<ProductListingModel> response) {
                assert response.body() != null;
                mProductsList = response.body().getResult().getListProducts();
                if (mRequestApiCallBack != null) {
                    mRequestApiCallBack.onSuccess(mProductsList);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ProductListingModel> call, @NonNull Throwable t) {
                if (mRequestApiCallBack != null) {
                    mRequestApiCallBack.onFailure(t);
                }
            }
        });
    }


    public interface IRequestApiCallBack {
        void onSuccess(ArrayList<ProductModel> productsList);

        void onFailure(Throwable t);
    }

    public interface OnClickItemCallBack {
        void onClickItemListing();
    }
}
