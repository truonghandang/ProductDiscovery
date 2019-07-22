package com.truonghd.productdiscovery.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.truonghd.productdiscovery.connection.ApiClient;
import com.truonghd.productdiscovery.model.ProductDetailsModel;
import com.truonghd.productdiscovery.model.ProductModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Truong.HanDang on 2019-07-19
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ProductDetailsVM extends ViewModel {
    private IRequestDataDetaisCallBack mRequestApiCallBack;
    private ProductModel mProductsModel;

    public void setRequestApiCallBack(IRequestDataDetaisCallBack mRequestApiCallBack) {
        this.mRequestApiCallBack = mRequestApiCallBack;
    }

    public ProductDetailsVM(String productId) {
        getDataFromServer(productId);
    }

    private void getDataFromServer(String productId) {
        Call<ProductDetailsModel> call = ApiClient.getInstance().getApi().getDetailsData(productId);
        call.enqueue(new Callback<ProductDetailsModel>() {
            @Override
            public void onResponse(@NonNull Call<ProductDetailsModel> call, @NonNull Response<ProductDetailsModel> response) {
                assert response.body() != null;
                mProductsModel = response.body().getResult().getProduct();
                if (mRequestApiCallBack != null) {
                    mRequestApiCallBack.onSuccess(mProductsModel);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ProductDetailsModel> call, @NonNull Throwable t) {
                if (mRequestApiCallBack != null) {
                    mRequestApiCallBack.onFailure(t);
                }
            }
        });
    }

    public interface IRequestDataDetaisCallBack {
        void onSuccess(ProductModel productModel);

        void onFailure(Throwable t);
    }
}
