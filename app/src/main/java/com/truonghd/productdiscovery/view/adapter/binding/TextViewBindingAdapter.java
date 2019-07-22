package com.truonghd.productdiscovery.view.adapter.binding;

import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;

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
public final class TextViewBindingAdapter {

    @BindingAdapter(value = {"setTextStrike"}, requireAll = false)
    public static void setTextStrike(TextView view, String text) {
        view.setText(text);
        view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
