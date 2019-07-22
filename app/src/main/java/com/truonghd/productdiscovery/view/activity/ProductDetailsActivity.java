package com.truonghd.productdiscovery.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.truonghd.productdiscovery.R;
import com.truonghd.productdiscovery.databinding.ActivityProductDetailsBinding;
import com.truonghd.productdiscovery.model.ProductImageModel;
import com.truonghd.productdiscovery.model.ProductModel;
import com.truonghd.productdiscovery.view.adapter.ImagePagerAdapter;
import com.truonghd.productdiscovery.view.adapter.ProductInfoPagerAdapter;
import com.truonghd.productdiscovery.viewmodel.ProductDetailsVM;

import java.util.ArrayList;

/**
 * Created by Truong.HanDang on 2019-07-18
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class ProductDetailsActivity extends BaseActivity<ActivityProductDetailsBinding>
        implements ViewPager.OnPageChangeListener, ProductDetailsVM.IRequestDataDetaisCallBack {
    private ViewPager mImagePager;
    private ImagePagerAdapter mImageAdapter;

    private ViewPager mInfoPager;
    private ProductInfoPagerAdapter mInfoAdapter;
    private String mProductId;
    public static final String PRODUCT_ID = "product_sku";
    private ProductDetailsVM mViewModel;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_product_details;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProductId = getIntent().getStringExtra(PRODUCT_ID);

        mViewModel = new ProductDetailsVM("1200023");
        mViewModel.setRequestApiCallBack(this);

        mImagePager = getViewBinding().layoutPreview.viewpagerSlider;

        mImageAdapter = new ImagePagerAdapter(getSupportFragmentManager());

        mImagePager.setAdapter(mImageAdapter);
        mImagePager.setCurrentItem(0);
        mImagePager.addOnPageChangeListener(this);

        getViewBinding().layoutPreview.tabDots.setupWithViewPager(mImagePager, true);
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

    @Override
    public void onSuccess(ProductModel productModel) {
        getViewBinding().layoutPreview.setProductModel(productModel);

        mImageAdapter.setListImage(productModel.getImages());
        mImageAdapter.notifyDataSetChanged();

        mInfoPager = getViewBinding().layoutInfo.viewpagerProductInfo;
        mInfoAdapter = new ProductInfoPagerAdapter(getSupportFragmentManager());
        mInfoPager.setAdapter(mInfoAdapter);
        mInfoPager.setCurrentItem(1);

        mInfoAdapter.setListData(productModel.getAttributeGroups());
        mInfoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
