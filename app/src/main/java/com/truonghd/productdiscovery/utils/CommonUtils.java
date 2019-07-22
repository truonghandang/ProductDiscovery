package com.truonghd.productdiscovery.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Truong.HanDang on 2019-07-18
 * truonghd94@gmail.com
 *
 * @version 1.0
 */
public final class CommonUtils {

    public static String formatNumber(String stamp) {
        try {
            int value = Integer.valueOf(stamp);
            return NumberFormat.getInstance(Locale.US).format(value);
        } catch (Exception e) {
            return null;
        }
    }
}
