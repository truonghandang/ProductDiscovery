package com.truonghd.productdiscovery.view.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.truonghd.productdiscovery.R;
import com.truonghd.productdiscovery.databinding.FragmentProductInfoPagerBinding;
import com.truonghd.productdiscovery.model.AttributeModel;
import com.truonghd.productdiscovery.view.adapter.ProductInfoAdapter;

import java.util.ArrayList;

/**
 * Created by Truong.HanDang on 2019-07-19
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public class InfoPagerFragment extends BaseFragment<FragmentProductInfoPagerBinding> {
    private static final String ATTRIBUTE_DATA = "attribute_data";
    private ArrayList<AttributeModel> mListDataInfo;
    private ProductInfoAdapter mAdapter;

    public static InfoPagerFragment newInstance(ArrayList<AttributeModel> attributeModelList) {
        Bundle args = new Bundle();
        args.putSerializable(ATTRIBUTE_DATA, attributeModelList);
        InfoPagerFragment fragment = new InfoPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mListDataInfo = (ArrayList<AttributeModel>) getArguments().getSerializable(ATTRIBUTE_DATA);
        }
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_product_info_pager;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        intRecyclerViewInfo();
    }

    private void intRecyclerViewInfo() {
        mAdapter = new ProductInfoAdapter();
        RecyclerView rvProductListing = getViewBinding().recyclerProductInfo;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rvProductListing.setLayoutManager(layoutManager);
        rvProductListing.setAdapter(mAdapter);

        mAdapter.setProductsAttribute(mListDataInfo);
        mAdapter.notifyDataSetChanged();
    }
}
