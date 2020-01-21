package com.android.vira.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

/**
 *  Created by HosseinBahrami at 1/21/2020
 */

public class BindingAdapters {
    @BindingAdapter("loadImage")
    public static void loadImage(ImageView v, String url) {
        Picasso.get().load(url).into(v);
    }
}
