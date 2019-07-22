package com.truonghd.productdiscovery.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.truonghd.productdiscovery.R;
import com.truonghd.productdiscovery.databinding.ActivityProductDetailsBinding;
import com.truonghd.productdiscovery.view.adapter.ImagePagerAdapter;
import com.truonghd.productdiscovery.view.adapter.ProductInfoPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Truong.HanDang on 2019-07-18
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ProductDetailsActivity extends BaseActivity<ActivityProductDetailsBinding> implements ViewPager.OnPageChangeListener {
    private ViewPager mImagePager;
    private ImagePagerAdapter mImageAdapter;

    private ViewPager mInfoPager;
    private ProductInfoPagerAdapter mInfoAdapter;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_product_details;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImagePager = getViewBinding().layoutPreview.viewpagerSlider;

        mImageAdapter = new ImagePagerAdapter(getSupportFragmentManager());

        ArrayList<String> listImage = new ArrayList<>();
        listImage.add("https://img1.phongvu.vn/media/catalog/product/u/n/untitled-1_1_5.png");
        listImage.add("https://img1.phongvu.vn/media/catalog/product/u/n/untitled-3_4_5.png");
        listImage.add("https://img1.phongvu.vn/media/catalog/product/u/n/untitled-2_5_4.png");
        listImage.add("http://catalog.teko.vn/storage/psu/19030233/ff1779b83c8c3225810b473251b16ea0_power%20asus%20rog%20thor%20850p_7.jpg");
        listImage.add("https://img1.phongvu.vn/media/catalog/product/v/i/vigor_2920gvn.jpg");
        mImageAdapter.setListImage(listImage);
        mImagePager.setAdapter(mImageAdapter);
        mImagePager.setCurrentItem(0);
        mImagePager.addOnPageChangeListener(this);

        getViewBinding().layoutPreview.tabDots.setupWithViewPager(mImagePager, true);


        mInfoPager = getViewBinding().layoutInfo.viewpagerProductInfo;
        mInfoAdapter = new ProductInfoPagerAdapter(getSupportFragmentManager());
        mInfoPager.setAdapter(mInfoAdapter);
        mInfoPager.setCurrentItem(0);
        mInfoPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
