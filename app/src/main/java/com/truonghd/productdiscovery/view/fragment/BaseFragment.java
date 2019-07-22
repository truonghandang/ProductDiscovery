package com.truonghd.productdiscovery.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;


/**
 * BaseFragment.java
 *
 * @param <VB>
 */
public abstract class BaseFragment<VB extends ViewDataBinding> extends Fragment {

    private VB mViewBinding;

    @LayoutRes
    protected abstract int layoutRes();

    protected VB getViewBinding() {
        return mViewBinding;
    }

    protected <T extends ViewDataBinding> T createContentView(LayoutInflater inflater,
                                                              ViewGroup parent,
                                                              @LayoutRes int layoutResourceId) {
        return DataBindingUtil.inflate(inflater, layoutResourceId, parent, false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        int layoutRes = layoutRes();
        if (layoutRes > 0) {
            mViewBinding = createContentView(inflater, container, layoutRes);
            return mViewBinding.getRoot();
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewBinding = null;
    }
}
