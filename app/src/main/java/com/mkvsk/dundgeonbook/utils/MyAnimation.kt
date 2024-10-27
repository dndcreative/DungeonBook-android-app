package com.mkvsk.dundgeonbook.utils

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.view.View

object MyAnimation {
     fun startFlightAnimation (expand: Boolean, view: View) {
        val rotateValue = if (expand) {
            -360f
        } else {
            360f
        }

        val rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, rotateValue)
        rotate.setDuration(1000)

        val oscillateX = PropertyValuesHolder.ofFloat(
            "translationX",
            0f, 8f, -8f
        )
        val swingAnimation = ObjectAnimator.ofPropertyValuesHolder(view, oscillateX)
        swingAnimation.setDuration(1000)
        swingAnimation.repeatCount = 2
        val flightSet = AnimatorSet()
        flightSet.playTogether(rotate, swingAnimation)
        flightSet.start()
    }

    fun letFlying(view: View) {
        val valuesX: () -> Float = { (-30 until 30).random().toFloat() }
        val valuesY: () -> Float = { (-50 until 50).random().toFloat() }

        val oscillateX = PropertyValuesHolder.ofFloat(
            "translationX",
            valuesX(), valuesX(), valuesX(), valuesX(), valuesX(), valuesX()
        )

        val oscillateY = PropertyValuesHolder.ofFloat(
            "translationY",
            valuesY(), valuesY(), valuesY(), valuesY()
        )

        val flyAnimator = ObjectAnimator.ofPropertyValuesHolder(view, oscillateX, oscillateY)
        flyAnimator.setDuration(5000)
        flyAnimator.repeatCount = ValueAnimator.INFINITE
        flyAnimator.repeatMode = ValueAnimator.REVERSE
        flyAnimator.start()
    }
}