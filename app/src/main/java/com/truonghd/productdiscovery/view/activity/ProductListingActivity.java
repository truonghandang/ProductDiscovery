package com.truonghd.productdiscovery.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.truonghd.productdiscovery.R;
import com.truonghd.productdiscovery.databinding.ActivityProductListingBinding;
import com.truonghd.productdiscovery.model.ProductModel;
import com.truonghd.productdiscovery.view.adapter.ProductListingAdapter;
import com.truonghd.productdiscovery.viewmodel.ProductListingVM;

import java.util.ArrayList;

public class ProductListingActivity extends BaseActivity<ActivityProductListingBinding> implements ProductListingVM.IRequestApiCallBack, ProductListingVM.OnClickItemCallBack {
    private ProductListingVM mViewModel;
    private ProductListingAdapter mAdapter;
    private static final String TAG = ProductListingActivity.class.getSimpleName();

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_product_listing;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ProductListingVM(this);
        mViewModel.setRequestApiCallBack(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mAdapter = new ProductListingAdapter();
        RecyclerView rvProductListing = getViewBinding().recyclerProductListing;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rvProductListing.setLayoutManager(layoutManager);
        rvProductListing.setAdapter(mAdapter);
        mAdapter.setOnClickItemCallBack(this);
    }


    @Override
    public void onSuccess(ArrayList<ProductModel> productsList) {
        Log.d(TAG, "onSuccess: " + productsList.size());
        mAdapter.setProductsList(productsList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(Throwable t) {
        Log.d(TAG, "onFailure: " + t.getMessage());
    }

    @Override
    public void onClickItemListing() {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        startActivity(intent);
    }
}