package com.zylab.sketchy.shape

import android.graphics.*
import com.zylab.sketchy.model.DEFAULT_POINT
import com.zylab.sketchy.model.SkBezier
import com.zylab.sketchy.model.SkPoint

/**
 * Created by zhangyi on 19-11-23
 */

open class SkSquare(var startPoint: SkPoint = DEFAULT_POINT, var width: Double = 0.0, var height: Double = 0.0) : SkShape() {
    private val lines: MutableList<SkLine> = ArrayList()

    override fun parse(bezierList: MutableList<SkBezier>) {
        if (!isValidPoint(startPoint) || width <= 0.0 || height <= 0.0) {
            return
        }
        var line = SkLine(
            startPoint,
            SkPoint(startPoint.x + width, startPoint.y)
        )
        lines.add(line)
        line = SkLine(
            SkPoint(
                startPoint.x,
                startPoint.y + height
            ), SkPoint(startPoint.x + width, startPoint.y + height)
        )
        lines.add(line)
        line = SkLine(
            startPoint,
            SkPoint(startPoint.x, startPoint.y + height)
        )
        lines.add(line)
        line = SkLine(
            SkPoint(
                startPoint.x + width,
                startPoint.y
            ), SkPoint(startPoint.x + width, startPoint.y + height)
        )
        lines.add(line)
    }

    override fun fillShape(canvas: Canvas) {
        if (fillColor != 0) {
            fillPaint.color = fillColor
            fillPaint.style = Paint.Style.FILL
            canvas.drawRect(startPoint.x.toFloat(), startPoint.y.toFloat(), (startPoint.x + width).toFloat(), (startPoint.y + height).toFloat(), fillPaint)
        }
    }

    override fun draw(canvas: Canvas) {
        drawBackground(canvas)
        fillShape(canvas)
        lines.forEach {
            it.brushWidth = brushWidth
            it.color = color
            it.fillColor = fillColor
            it.bgColor = bgColor
            it.draw(canvas)
        }
    }
}
