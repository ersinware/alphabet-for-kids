package com.alphabetforkids.view.utils

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setImageByUrl(
    img: ImageView,
    imageUrl: String
) = Glide
    .with(img)
    .load(Uri.parse("file:///android_asset/$imageUrl"))
    .into(img)

@BindingAdapter("pagerListener")
fun setPagerListener(
    pager: ViewPager2,
    listener: ViewPager2.OnPageChangeCallback
) = pager.registerOnPageChangeCallback(listener)