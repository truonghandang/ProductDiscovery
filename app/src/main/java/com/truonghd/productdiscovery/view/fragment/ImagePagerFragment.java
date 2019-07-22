package com.truonghd.productdiscovery.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.truonghd.productdiscovery.R;
import com.truonghd.productdiscovery.databinding.FragmentImagePagerBinding;

/**
 * Created by Truong.HanDang on 2019-07-19
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ImagePagerFragment extends BaseFragment<FragmentImagePagerBinding> {
    private String mUrlImage;

    public static ImagePagerFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putSerializable("img_url", url);
        ImagePagerFragment fragment = new ImagePagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUrlImage = (String) getArguments().getSerializable("img_url");
        }
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_image_pager;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView img = getViewBinding().imgSlider;

        Glide.with(view.getContext())
                .load(mUrlImage)
                .into(img);
    }
}
