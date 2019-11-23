package com.zylab.sketchycomponent.view

import android.graphics.Canvas
import android.graphics.Rect
import com.zylab.sketchycomponent.model.SkPoint
import com.zylab.sketchycomponent.shape.SkSquare

/**
 * Created by zhangyi on 19-11-23
 */

class SkSquareDrawable(width: Double = 0.0, height: Double = 0.0) : SkDrawable(width, height) {
    private var square: SkSquare = SkSquare()
    var backgroundColor: Int = 0

    init {
        if (canPreParse()) {
            parse()
        }
    }

    private fun parse() {
        square.backgroundColor = backgroundColor
        square.startPoint = SkPoint(square.getShapeWidth(), square.getShapeWidth())
        square.width = width - square.getShapeWidth() * 2
        square.height = height - square.getShapeWidth() * 2
        square.parse()
    }

    override fun draw(canvas: Canvas) {
        if (!canPreParse()) {
            width = bounds.width().toDouble()
            height = bounds.height().toDouble()
            parse()
        }
        square.draw(canvas)
    }

    override fun getPadding(padding: Rect): Boolean {
        val tmpPadding = square.getShapeWidth().toInt()
        padding.set(tmpPadding, tmpPadding, tmpPadding, tmpPadding)
        return true
    }
}
