package com.android.vira.utils

import android.widget.ImageView
import android.widget.MediaController
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

/**
 * Created by HosseinBahrami at 1/21/2020
 */
object BindingAdapters {
    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(v: ImageView?, url: String?) {
        Picasso.get().load(url).into(v)
    }
}