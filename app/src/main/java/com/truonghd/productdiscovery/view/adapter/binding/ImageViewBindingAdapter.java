package com.truonghd.productdiscovery.view.adapter.binding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.truonghd.productdiscovery.R;

/**
 * Created by Truong.HanDang on 2019-07-18
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
@SuppressWarnings("unused")
public final class ImageViewBindingAdapter {

    @BindingAdapter(value = {"imageUrl"}, requireAll = false)
    public static void loadImageUrl(ImageView view, String url) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.img_product_default)
                .error(R.drawable.img_product_default)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);

        Glide.with(view.getContext())
                .load(url)
                .apply(options)
                .into(view);
    }
}
