package com.truonghd.productdiscovery.view.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.truonghd.productdiscovery.R;
import com.truonghd.productdiscovery.databinding.ItemProductInfoBinding;
import com.truonghd.productdiscovery.model.AttributeModel;
import com.truonghd.productdiscovery.view.adapter.implement.BaseViewHolder;
import com.truonghd.productdiscovery.view.adapter.implement.RecyclerBaseAdapter;

import java.util.ArrayList;

/**
 * Created by Truong.Han on 2019-07-22.
 * VIETIS Corporation
 * truong.han@vietis.com.vn
 */
public class ProductInfoAdapter extends RecyclerBaseAdapter {
    private ArrayList<AttributeModel> mProductsAttrList = new ArrayList<>();

    public void setProductsAttribute(ArrayList<AttributeModel> mProductsAttribute) {
        this.mProductsAttrList = mProductsAttribute;
    }

    @Override
    public int getContentItemCount() {
        return mProductsAttrList.size();
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
        ItemProductInfoBinding binding = createBinding(parent, R.layout.item_product_info);
        return new InfoViewHolder(binding);
    }

    private class InfoViewHolder extends BaseViewHolder<ItemProductInfoBinding> {
        /**
         * base view holder
         *
         * @param binding view binding
         */
        InfoViewHolder(@NonNull ItemProductInfoBinding binding) {
            super(binding);
        }

        @Override
        public void onBindView(int position) {
            int currentPosition = toContentPosition(position);
            getBinding().setViewModel(mProductsAttrList.get(currentPosition));
            getBinding().executePendingBindings();

            if (currentPosition == 0) {
                getBinding().getRoot().setBackground(getBinding().getRoot().getContext().getDrawable(R.drawable.bg_item_info_header));
            } else if (currentPosition % 2 == 0) {
                getBinding().getRoot().setBackgroundColor(ContextCompat.getColor(getBinding().getRoot().getContext(), R.color.colorPaleGrey));
            } else if (currentPosition % 2 == 0 && currentPosition == mProductsAttrList.size() - 1) {
                getBinding().getRoot().setBackground(getBinding().getRoot().getContext().getDrawable(R.drawable.bg_item_info_end));
            }
        }
    }
}
