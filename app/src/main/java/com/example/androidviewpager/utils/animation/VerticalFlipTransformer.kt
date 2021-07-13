package com.example.onboarding.utils.animation

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class VerticalFlipTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            page.translationX = -position * page.width
            page.cameraDistance = 12000F

            if (position < 0.5 && position > -0.5) {
                page.visibility = View.VISIBLE
            } else {
                page.visibility = View.INVISIBLE
            }

            when {
                position < -1 -> {     // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    page.alpha = 0F

                }
                position <= 0 -> {    // [-1,0]
                    page.alpha = 1F
                    page.rotationY = 180 *(1- abs(position) +1)

                }
                position <= 1 -> {    // (0,1]
                    page.alpha = 1F
                    page.rotationY = -180 *(1- abs(position) +1)

                }
                else -> {    // (1,+Infinity]
                    // This page is way off-screen to the right.
                    page.alpha = 0F
                }
            }
        }
    }
}