package com.faqihzain.movieguidekotlin.util

import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation


class HorizontalDottedProgress : View {
    private val mDotRadius = 5
    private val mBounceDotRadius = 8
    private var mDotPosition = 0
    private val mDotAmount = 10

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    protected override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.setColor(getResources().getColor(R.color.holo_orange_dark))
        createDot(canvas, paint)
    }

    protected override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        startAnimation()
    }

    private fun createDot(
        canvas: Canvas,
        paint: Paint
    ) { //here i have setted progress bar with 10 dots , so repeat and wnen i = mDotPosition  then increase the radius of dot i.e mBounceDotRadius
        for (i in 0 until mDotAmount) {
            if (i == mDotPosition) {
                canvas.drawCircle(
                    (10 + i * 20).toFloat(), mBounceDotRadius.toFloat(),
                    mBounceDotRadius.toFloat(), paint)
            } else {
                canvas.drawCircle(
                    (10 + i * 20).toFloat(), mBounceDotRadius.toFloat(),
                    mDotRadius.toFloat(), paint)
            }
        }
    }

    protected override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width: Int
        val height: Int
        //calculate the view width
        val calculatedWidth = 20 * 9
        width = calculatedWidth
        height = mBounceDotRadius * 2
        //MUST CALL THIS
        setMeasuredDimension(width, height)
    }

    private fun startAnimation() {
        val bounceAnimation =
            BounceAnimation()
        bounceAnimation.duration = 100
        bounceAnimation.repeatCount = Animation.INFINITE
        bounceAnimation.interpolator = LinearInterpolator()
        bounceAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {}
            override fun onAnimationRepeat(animation: Animation) {
                mDotPosition++
                //when mDotPosition == mDotAmount , then start again applying animation from 0th positon , i.e  mDotPosition = 0;
                if (mDotPosition == mDotAmount) {
                    mDotPosition = 0
                }
                Log.d("INFOMETHOD", "----On Animation Repeat----")
            }
        })
        startAnimation(bounceAnimation)
    }

    private inner class BounceAnimation : Animation() {
        override fun applyTransformation(
            interpolatedTime: Float,
            t: Transformation?
        ) {
            super.applyTransformation(interpolatedTime, t)
            //call invalidate to redraw your view againg.
            invalidate()
        }
    }
}