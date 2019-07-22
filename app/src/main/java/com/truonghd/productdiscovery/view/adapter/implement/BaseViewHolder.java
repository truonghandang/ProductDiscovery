package com.truonghd.productdiscovery.view.adapter.implement;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Truong.HanDang on 2019-07-17
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public abstract class BaseViewHolder<T extends ViewDataBinding>
        extends RecyclerView.ViewHolder {

    private T mBinding;

    public T getBinding() {
        return mBinding;
    }

    /**
     * base view holder
     *
     * @param binding view binding
     */
    public BaseViewHolder(@NonNull T binding) {
        super(binding.getRoot());
        this.mBinding = binding;
    }

    /**
     * fill data to holder
     *
     * @param position integerß
     */
    public abstract void onBindView(int position);
}
