package com.zylab.sketchy.shape

import android.graphics.Canvas
import android.graphics.Paint
import com.zylab.sketchy.model.DEFAULT_POINT
import com.zylab.sketchy.model.SkBezier
import com.zylab.sketchy.model.SkPoint
import kotlin.math.*

/**
 * Created by zhangyi on 19-11-24
 */

class SkArc(
    var center: SkPoint = DEFAULT_POINT,
    var radius: Double = 0.0,
    var startAngle: Double = 0.0,
    var sweepAngle: Double = 0.0,
    var linkCenter: Boolean = true
) : SkShape() {

    init {
        step = 10.0
    }

    override fun parse(bezierList: MutableList<SkBezier>) {
        if (!isValidPoint(center) || radius <= 0) {
            return
        }
        var startX: Double
        var startY: Double

        var nextX: Double
        var nextY: Double
        var angle = startAngle
        var nextAngle: Double

        var startPoint = SkPoint(0.0, 0.0)
        var endPoint = SkPoint(0.0, 0.0)

        var line = SkLine()
        line.brushWidth = brushWidth

        while (angle < (startAngle + sweepAngle)) {
            startX = calcX(center.x, radius, angle)
            startY = calcY(center.y, radius, angle)
            nextAngle = min(angle + step * 2, startAngle + sweepAngle)
            nextX = calcX(center.x, radius, nextAngle)
            nextY = calcY(center.y, radius, nextAngle)

            startPoint.x = startX
            startPoint.y = startY
            line.startPoint = startPoint
            endPoint.x = nextX
            endPoint.y = nextY
            line.endPoint = endPoint
            line.parse(bezierList)
            angle += step
        }

        if (linkCenter) {
            startX = calcX(center.x, radius, startAngle)
            startY = calcY(center.y, radius, startAngle)
            nextX = calcX(center.x, radius, startAngle + sweepAngle)
            nextY = calcY(center.y, radius, startAngle + sweepAngle)
            line = SkLine(SkPoint(center.x, center.y), SkPoint(startX, startY))
            line.parse(bezierList)
            line = SkLine(SkPoint(center.x, center.y), SkPoint(nextX, nextY))
            line.parse(bezierList)
        }
    }

    private fun calcX(cx: Double, radius: Double, angle: Double): Double {
        return cx + radius * cos(Math.toRadians(angle))
    }

    private fun calcY(cy: Double, radius: Double, angle: Double): Double {
        return cy + radius * sin(Math.toRadians(angle))
    }

    override fun fillShape(canvas: Canvas) {
        if (fillColor != 0) {
            fillPaint.color = fillColor
            fillPaint.style = Paint.Style.FILL
            canvas.drawArc(
                (center.x - radius).toFloat(),
                (center.y - radius).toFloat(),
                (center.x + radius).toFloat(),
                (center.y + radius).toFloat(),
                startAngle.toFloat(),
                sweepAngle.toFloat(),
                true, fillPaint
            )
        }
    }
}
