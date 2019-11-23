package com.zylab.sketchycomponent.shape

import com.zylab.sketchycomponent.model.DEFAULT_POINT
import com.zylab.sketchycomponent.model.SkBezier
import com.zylab.sketchycomponent.model.SkPoint
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt
import kotlin.random.Random

/**
 * Created by zhangyi on 19-11-19
 */

class SkCircle(var center: SkPoint = DEFAULT_POINT, var radius: Double = 0.0) : SkShape() {

    init {
        step = 15.0
    }

    override fun parse() {
        if (!isValidPoint(center) || radius <= 0.0) {
            return
        }
        var startX = center.x - radius
        startX = if (startX < 0) 0.0 else startX
        var startY: Double
        var endX = center.x + radius

        var nextX: Double
        var nextY: Double
        var controlX: Double
        var controlY: Double

        var startPoint: SkPoint
        var controlPoint: SkPoint
        var endPoint: SkPoint

        while (startX < endX) {
            nextX = min(startX + step * 2, endX)
            nextY = y(nextX, 1)
            startY = y(startX, 1)
            if (abs(startY - (nextY + startY) / 2) < 0.1) {
                startX += step
                continue
            }
            controlX = Random.nextDouble(startX, (startX + nextX) / 2)
            controlY = Random.nextDouble(
                min(startY, (startY + nextY) / 2),
                max(startY, (startY + nextY) / 2)
            ) + brushWidth
            startPoint = SkPoint(startX, startY)
            controlPoint = SkPoint(controlX, controlY)
            endPoint = SkPoint(nextX, nextY)
            bezierList.add(SkBezier(startPoint, controlPoint, endPoint))

            controlX = Random.nextDouble((startX + nextX) / 2, nextX)
            controlY = Random.nextDouble(
                min(nextY, (startY + nextY) / 2),
                max(nextY, (startY + nextY) / 2)
            ) + brushWidth
            controlPoint = SkPoint(controlX, controlY)
            bezierList.add(SkBezier(startPoint, controlPoint, endPoint))

            nextY = y(nextX, -1)
            startY = y(startX, -1)
            controlX = Random.nextDouble(startX, (startX + nextX) / 2)
            controlY = Random.nextDouble(
                min(startY, (startY + nextY) / 2),
                max(startY, (startY + nextY) / 2)
            ) - brushWidth
            startPoint = SkPoint(startX, startY)
            controlPoint = SkPoint(controlX, controlY)
            endPoint = SkPoint(nextX, nextY)
            bezierList.add(SkBezier(startPoint, controlPoint, endPoint))

            controlX = Random.nextDouble((startX + nextX) / 2, nextX)
            controlY = Random.nextDouble(
                min(nextY, (startY + nextY) / 2),
                max(nextY, (startY + nextY) / 2)
            ) - brushWidth
            controlPoint = SkPoint(controlX, controlY)
            bezierList.add(SkBezier(startPoint, controlPoint, endPoint))

            startX += step
        }
    }

    private fun y(x: Double, k: Int): Double {
        return center.y + sqrt(radius * radius - (x - center.x) * (x - center.x)) * k
    }
}
