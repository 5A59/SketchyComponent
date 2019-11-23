package com.zylab.sketchycomponent.view

import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable

/**
 * Created by zhangyi on 19-11-23
 */

abstract class SkDrawable(var width: Double = 0.0, var height: Double = 0.0) : Drawable() {

    protected fun canPreParse(): Boolean {
        return width > 0.0 && height > 0.0
    }

    override fun setAlpha(alpha: Int) {
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }
}
