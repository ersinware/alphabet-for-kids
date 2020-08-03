package com.alphabetforkids.view.utils

import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.children
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.alphabetforkids.R
import com.bumptech.glide.Glide

fun ViewGroup.addCorrectImage(
    inflater: LayoutInflater,
    background: Drawable
) = addView(
    inflater.inflate(
        R.layout.baby_correct_image,
        this,
        false
    ).apply {
        this.background = background
    }
)

fun ViewGroup.addIncorrectImage(
    inflater: LayoutInflater,
    background: Drawable
) = addView(
    inflater.inflate(
        R.layout.baby_incorrect_image,
        this,
        false
    ).apply {
        this.background = background
    }
)

fun ViewGroup.setVisibilityChildren(
    visibility: Int
) {
    for (child in children)
        child.visibility = visibility
}

fun ViewGroup.setClickableChildren(
    clickable: Boolean
) {
    for (child in children)
        child.isClickable = clickable
}

fun ViewGroup.removeLastChildrenOfChildren() {
    for (child in children)
        (child as? ViewGroup)?.let {
            if (it.childCount > 1)
                for (i in it.childCount - 1 downTo 1)
                    it.removeViewAt(i)
        }
}
