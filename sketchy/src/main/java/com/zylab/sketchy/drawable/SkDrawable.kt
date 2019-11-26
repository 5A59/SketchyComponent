package com.zylab.sketchy.drawable

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.Rect
import android.graphics.drawable.Drawable
import com.zylab.sketchy.shape.SkShape

/**
 * Created by zhangyi on 19-11-23
 */

abstract class SkDrawable(var width: Double = 0.0, var height: Double = 0.0) : Drawable() {
    protected var shape: SkShape? = null

    var backgroundColor: Int = 0
    var lineColor: Int = 0
    var fillColor: Int = 0
    var brushWidth: Double = 15.0
        set(value) {
            field = value
            shape?.brushWidth = value
        }

    open fun parse() {
        shape?.bgColor = backgroundColor
        shape?.color = lineColor
        shape?.fillColor = fillColor
    }

    override fun setAlpha(alpha: Int) {
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }

    override fun draw(canvas: Canvas) {
        if (width <= 0 || height <= 0) {
            width = bounds.width().toDouble()
            height = bounds.height().toDouble()
            parse()
        }
        onDraw(canvas)
    }

    protected open fun onDraw(canvas: Canvas) {
        shape?.draw(canvas)
    }

    override fun getPadding(padding: Rect): Boolean {
        var tmpPadding = shape?.getShapeWidth()?.toInt() ?: 0
        padding.set(tmpPadding, tmpPadding, tmpPadding, tmpPadding)
        return true
    }
}
