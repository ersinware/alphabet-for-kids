package com.alphabetforkids.view.utils.animation

import android.view.View
import android.view.animation.ScaleAnimation

class PagerClickAnimator {

    private val anim = ScaleAnimation(
        1f,
        0.9f,
        1f,
        0.9f,
        ScaleAnimation.RELATIVE_TO_SELF,
        0.5f,
        ScaleAnimation.RELATIVE_TO_SELF,
        0.5f
    ).apply {
        duration = PAGER_CLICK_ANIMATION_DURATION
        repeatCount = 1
        repeatMode = ScaleAnimation.REVERSE
    }

    var running = false

    suspend fun awaitEnd(view: View) {
        running = true

        view.startAnimation(anim)
        anim.awaitEnd()

        running = false
    }
}