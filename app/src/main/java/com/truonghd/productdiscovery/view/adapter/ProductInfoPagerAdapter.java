package com.truonghd.productdiscovery.view.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.truonghd.productdiscovery.model.AttributeModel;
import com.truonghd.productdiscovery.view.fragment.InfoPagerFragment;

import java.util.ArrayList;

public class ProductInfoPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_INFO = 3;
    private ArrayList<AttributeModel> mListData = new ArrayList<>();

    public void setListData(ArrayList<AttributeModel> mListData) {
        this.mListData = mListData;
    }

    public ProductInfoPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return PAGE_INFO;
    }

    @Override
    public Fragment getItem(int position) {
        return InfoPagerFragment.newInstance(mListData);
    }
}
