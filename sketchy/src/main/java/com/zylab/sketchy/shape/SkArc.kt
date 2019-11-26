package com.zylab.sketchy.shape

import android.graphics.Canvas
import android.graphics.Paint
import com.zylab.sketchy.model.DEFAULT_POINT
import com.zylab.sketchy.model.SkBezier
import com.zylab.sketchy.model.SkPoint
import kotlin.math.*
import kotlin.random.Random

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
    private val angleStep = 10

    override fun parse(bezierList: MutableList<SkBezier>) {
        var startX: Double
        var startY: Double

        var nextX: Double
        var nextY: Double
        var controlX: Double
        var controlY: Double
        var angle = startAngle
        var nextAngle: Double

        var startPoint: SkPoint
        var controlPoint: SkPoint
        var endPoint: SkPoint

        while (angle < (startAngle + sweepAngle)) {
            startX = calcX(center.x, radius, angle)
            startY = calcY(center.y, radius, angle)
            nextAngle = min(angle + angleStep * 2, startAngle + sweepAngle)
            nextX = calcX(center.x, radius, nextAngle)
            nextY = calcY(center.y, radius, nextAngle)

            if (abs(startY - (nextY + startY) / 2) < 0.1 || abs(startX - (nextX + startX) / 2) < 0.1) {
                angle += angleStep
                continue
            }
            controlX = Random.nextDouble(
                min(startX, (startX + nextX) / 2),
                max(startX, (startX + nextX) / 2)
            )
            controlY = Random.nextDouble(
                min(startY, (startY + nextY) / 2),
                max(startY, (startY + nextY) / 2)
            ) + brushWidth

            startPoint = SkPoint(startX, startY)
            controlPoint = SkPoint(controlX, controlY)
            endPoint = SkPoint(nextX, nextY)
            bezierList.add(SkBezier(startPoint, controlPoint, endPoint))

            controlX = Random.nextDouble(
                min((startX + nextX) / 2, nextX),
                max((startX + nextX) / 2, nextX)
            )
            controlY = Random.nextDouble(
                min(nextY, (startY + nextY) / 2),
                max(nextY, (startY + nextY) / 2)
            ) + brushWidth
            controlPoint = SkPoint(controlX, controlY)
            bezierList.add(SkBezier(startPoint, controlPoint, endPoint))

            angle += angleStep
        }
        if (linkCenter) {
            startX = calcX(center.x, radius, startAngle)
            startY = calcY(center.y, radius, startAngle)
            nextX = calcX(center.x, radius, startAngle + sweepAngle)
            nextY = calcY(center.y, radius, startAngle + sweepAngle)
            var line = SkLine(SkPoint(center.x, center.y), SkPoint(startX, startY))
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
