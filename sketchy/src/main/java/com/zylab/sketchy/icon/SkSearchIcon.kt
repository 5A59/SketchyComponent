package com.zylab.sketchy.icon

import android.graphics.Canvas
import android.graphics.Color
import com.zylab.sketchy.drawable.SkDrawable
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkCircle
import com.zylab.sketchy.shape.SkLine
import kotlin.math.min

/**
 * Created by zhangyi on 19-11-26
 */

class SkSearchIcon : SkDrawable() {
    var circle = SkCircle()
    var line = SkLine()

    override fun parse() {
        circle.bgColor = backgroundColor
        circle.color = lineColor
        circle.fillColor = if (fillColor == 0) Color.parseColor("#FFFFFF") else fillColor

        circle.center = SkPoint(width / 2, height / 2)
        circle.radius = (min(width / 2, height / 2) - circle.getShapeWidth()) * 3 / 4
        circle.parse()

        line.bgColor = backgroundColor
        line.color = lineColor
        line.fillColor = fillColor

        line.reset(SkPoint(width / 2, height / 2), SkPoint(width, height))
        line.parse()
    }

    override fun onDraw(canvas: Canvas) {
        line.draw(canvas)
        circle.draw(canvas)
    }
}
