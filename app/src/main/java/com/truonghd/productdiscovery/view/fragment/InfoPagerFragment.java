package com.truonghd.productdiscovery.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.truonghd.productdiscovery.R;
import com.truonghd.productdiscovery.databinding.FragmentImagePagerBinding;
import com.truonghd.productdiscovery.databinding.FragmentProductInfoPagerBinding;

/**
 * Created by Truong.HanDang on 2019-07-19
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class InfoPagerFragment extends BaseFragment<FragmentProductInfoPagerBinding> {

    public static InfoPagerFragment newInstance() {
        Bundle args = new Bundle();
        InfoPagerFragment fragment = new InfoPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_product_info_pager;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
