package com.zylab.sketchycomponent.shape

import android.graphics.Canvas
import com.zylab.sketchycomponent.model.SkPoint

/**
 * Created by zhangyi on 19-11-19
 */

class SkArrow(private val startPoint: SkPoint, private val width: Double, private val height: Double) : SkShape() {
    override fun parse() {
    }

    override fun draw(canvas: Canvas) {
        val line = SkLine(startPoint, SkPoint(startPoint.x + width, startPoint.y))
        line.draw(canvas)
        line.reset(startPoint, SkPoint(startPoint.x + height / 2, startPoint.y - height / 2))
        line.draw(canvas)
        line.reset(startPoint, SkPoint(startPoint.x + height / 2, startPoint.y + height / 2))
        line.draw(canvas)
    }
}
