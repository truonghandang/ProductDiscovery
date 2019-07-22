package com.truonghd.productdiscovery.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.truonghd.productdiscovery.R;
import com.truonghd.productdiscovery.databinding.ItemProductBinding;
import com.truonghd.productdiscovery.model.ProductModel;
import com.truonghd.productdiscovery.view.adapter.implement.BaseViewHolder;
import com.truonghd.productdiscovery.view.adapter.implement.RecyclerBaseAdapter;
import com.truonghd.productdiscovery.viewmodel.ProductListingVM;

import java.util.ArrayList;

/**
 * Created by Truong.HanDang on 2019-07-17
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ProductListingAdapter extends RecyclerBaseAdapter {
    private ArrayList<ProductModel> mProductsList = new ArrayList<>();
    private ProductListingVM.OnClickItemCallBack iOnClickItemCallBack;

    public void setProductsList(ArrayList<ProductModel> mProductsList) {
        this.mProductsList = mProductsList;
    }

    public void setOnClickItemCallBack(ProductListingVM.OnClickItemCallBack onClickItemCallBack) {
        this.iOnClickItemCallBack = onClickItemCallBack;
    }

    @Override
    public int getContentItemCount() {
        return mProductsList.size();
    }

    @Override
    public BaseViewHolder onCreateHeaderHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public BaseViewHolder onCreateFooterHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public BaseViewHolder onCreateContentHolder(ViewGroup parent, int viewType) {
        ItemProductBinding binding = createBinding(parent, R.layout.item_product);
        return new ProductViewHolder(binding);
    }

    private class ProductViewHolder extends BaseViewHolder<ItemProductBinding> {
        /**
         * base view holder
         *
         * @param binding view binding
         */
        ProductViewHolder(@NonNull ItemProductBinding binding) {
            super(binding);
            binding.setEvent(iOnClickItemCallBack);
        }

        @Override
        public void onBindView(int position) {
            ItemProductBinding binding = getBinding();
            ProductModel model = mProductsList.get(toContentPosition(position));
            binding.setProductItem(model);

            binding.executePendingBindings();
        }
    }
}
