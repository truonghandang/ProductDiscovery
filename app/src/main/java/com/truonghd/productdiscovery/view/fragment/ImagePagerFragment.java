package com.truonghd.productdiscovery.view.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.truonghd.productdiscovery.R;
import com.truonghd.productdiscovery.databinding.FragmentImagePagerBinding;
import com.truonghd.productdiscovery.model.ProductImageModel;

/**
 * Created by Truong.HanDang on 2019-07-19
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ImagePagerFragment extends BaseFragment<FragmentImagePagerBinding> {
    private ProductImageModel mImageModel;
    private static final String IMAGE_MODEL = "image_model";

    public static ImagePagerFragment newInstance(ProductImageModel imageModel) {
        Bundle args = new Bundle();
        args.putSerializable(IMAGE_MODEL, imageModel);
        ImagePagerFragment fragment = new ImagePagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mImageModel = (ProductImageModel) getArguments().getSerializable(IMAGE_MODEL);
        }
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_image_pager;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getViewBinding().setModel(mImageModel);
    }
}
