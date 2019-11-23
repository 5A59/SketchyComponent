package com.zylab.sketchycomponent.shape

import com.zylab.sketchycomponent.model.DEFAULT_POINT
import com.zylab.sketchycomponent.model.SkBezier
import com.zylab.sketchycomponent.model.SkPoint
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

/**
 * Created by zhangyi on 19-11-19
 */

class SkLine(private var startPoint: SkPoint = DEFAULT_POINT, private var endPoint: SkPoint = DEFAULT_POINT) : SkShape() {

    fun reset(startPoint: SkPoint, endPoint: SkPoint) {
        this.startPoint = startPoint
        this.endPoint = endPoint
        bezierList.clear()
        parse()
    }

    override fun parse() {
        if (!isValidPoint(startPoint) || !isValidPoint(endPoint)) {
            bezierList.clear()
            return
        }
        if (abs(startPoint.x - endPoint.x) < 0.00001) {
            parseVLine()
        } else {
            parseLine()
        }
    }

    private fun parseVLine() {
        var x = startPoint.x
        var startY = startPoint.y
        var endY = endPoint.y

        var nextY: Double
        var controlX: Double
        var controlY: Double

        while (startY < endY) {
            nextY = min(startY + step * 2, endY)
            controlX = Random.nextDouble(x, x + brushWidth)
            controlY = Random.nextDouble(startY, nextY)
            var startPoint = SkPoint(x, startY)
            var controlPoint = SkPoint(controlX, controlY)
            var endPoint = SkPoint(x, nextY)
            bezierList.add(SkBezier(startPoint, controlPoint, endPoint))

            controlX = Random.nextDouble(x - brushWidth, x)
            controlY = Random.nextDouble(startY, nextY)
            controlPoint = SkPoint(controlX, controlY)
            bezierList.add(SkBezier(startPoint, controlPoint, endPoint))
            startY += step
        }
    }

    private fun parseLine() {
        val k = (endPoint.y - startPoint.y) / (endPoint.x - startPoint.x)
        val b = (endPoint.x * startPoint.y - startPoint.x * endPoint.y) / (endPoint.x - startPoint.x)
        var startX = min(startPoint.x, endPoint.x)
        var endX = max(startPoint.x, endPoint.x)

        var nextX: Double
        var controlX: Double
        var controlY: Double

        while (startX < endX) {
            nextX = min(startX + step * 2, endX)
            controlX = Random.nextDouble(startX, nextX)
            controlY = Random.nextDouble(controlX * k + b, controlX * k + b + brushWidth)
            var startPoint = SkPoint(startX, startX * k + b)
            var controlPoint = SkPoint(controlX, controlY)
            var endPoint = SkPoint(nextX, nextX * k + b)
            bezierList.add(SkBezier(startPoint, controlPoint, endPoint))

            controlX = Random.nextDouble(startX, nextX)
            controlY = Random.nextDouble(controlX * k + b - brushWidth, controlX * k + b)
            controlPoint = SkPoint(controlX, controlY)
            bezierList.add(SkBezier(startPoint, controlPoint, endPoint))
            startX += step
        }
    }
}
