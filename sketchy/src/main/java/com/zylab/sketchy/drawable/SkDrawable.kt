package com.zylab.sketchy.drawable

import android.graphics.*
import android.graphics.drawable.Drawable
import com.zylab.sketchy.model.DEFAULT_POINT
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkShape

/**
 * Created by zhangyi on 19-11-23
 */

abstract class SkDrawable(var width: Double = 0.0, var height: Double = 0.0) : Drawable() {
    protected var shape: SkShape? = null
    private var bufferCanvas = Canvas()
    private var paint = Paint()

    var bgColor: Int = 0
    var borderColor: Int = 0
    var fillColor: Int = 0
    var brushWidth: Double = 11.0
        set(value) {
            field = value
            shape?.brushWidth = value
        }

    private var hasParsed = false

    open fun parse() {
        shape?.bgColor = bgColor
        shape?.borderColor = borderColor
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
        }
        if (width <= 0) {
            width = 100.0
        }
        if (height <= 0) {
            height = 100.0
        }
        if (!hasParsed) {
            parse()
            hasParsed = true
        }

        var bufferBitmap = Bitmap.createBitmap(width.toInt(), height.toInt(), Bitmap.Config.ARGB_8888)
        bufferCanvas.setBitmap(bufferBitmap)
        onDraw(bufferCanvas)

        canvas.drawBitmap(bufferBitmap, 0F, 0F, paint)
    }

    protected open fun onDraw(canvas: Canvas) {
        shape?.draw(canvas)
    }

    protected fun isValidPoint(point: SkPoint?): Boolean {
        return point != null && point != DEFAULT_POINT
    }
}
