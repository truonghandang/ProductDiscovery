package com.truonghd.productdiscovery.view.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.truonghd.productdiscovery.view.fragment.InfoPagerFragment;

public class ProductInfoPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_INFO = 3;

    public ProductInfoPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return PAGE_INFO;
    }

    @Override
    public Fragment getItem(int position) {
        return InfoPagerFragment.newInstance();
    }
}
