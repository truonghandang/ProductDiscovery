package com.truonghd.productdiscovery.view.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.truonghd.productdiscovery.view.fragment.ImagePagerFragment;

import java.util.ArrayList;

public class ImagePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> mListImage;

    public ImagePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return mListImage.size();
    }

    @Override
    public Fragment getItem(int position) {
        return ImagePagerFragment.newInstance(mListImage.get(position));
    }

    public void setListImage(ArrayList<String> mListImage) {
        this.mListImage = mListImage;
    }
}
