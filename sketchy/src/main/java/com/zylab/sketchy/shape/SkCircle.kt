package com.zylab.sketchy.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.util.Log
import com.zylab.sketchy.model.DEFAULT_POINT
import com.zylab.sketchy.model.SkBezier
import com.zylab.sketchy.model.SkPoint
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt
import kotlin.random.Random

/**
 * Created by zhangyi on 19-11-19
 */

open class SkCircle(var center: SkPoint = DEFAULT_POINT, var radius: Double = 0.0) : SkShape() {
    var arc = SkArc()

    init {
        step = 15.0
    }

    override fun parse(bezierList: MutableList<SkBezier>) {
        if (isValidPoint(center) && radius > 0) {
            arc.center = center
            arc.radius = radius
            arc.startAngle = 0.0
            arc.sweepAngle = 360.0
            arc.linkCenter = false
            arc.parse(bezierList)
        }
    }

    override fun fillShape(canvas: Canvas) {
        if (fillColor != 0) {
            fillPaint.color = fillColor
            fillPaint.style = Paint.Style.FILL
            canvas.drawCircle(center.x.toFloat(), center.y.toFloat(), radius.toFloat(), fillPaint)
        }
    }
}
