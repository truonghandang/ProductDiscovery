package com.truonghd.productdiscovery.view.activity;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;

/**
 * BaseActivity.java
 *
 * @param <VB>
 */
public abstract class BaseActivity<VB extends ViewDataBinding> extends FragmentActivity {
    /**
     * View Binding
     */
    private VB mViewBinding;

    /**
     * set content view
     *
     * @param layoutRes layout Resource
     * @param <T>       object exend ViewDataBinding
     * @return view data binding
     */
    private <T extends ViewDataBinding> T setBindingContentView(@LayoutRes int layoutRes) {
        return DataBindingUtil.setContentView(this, layoutRes);
    }

    /**
     * get View Binding
     *
     * @return view binding
     */
    VB getViewBinding() {
        return mViewBinding;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutResourceId();
        if (layoutId > 0) {
            mViewBinding = setBindingContentView(layoutId);
        }
    }

    /**
     * get Layout Resource
     *
     * @return int
     */
    @LayoutRes
    protected abstract int getLayoutResourceId();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewBinding = null;
    }
}
