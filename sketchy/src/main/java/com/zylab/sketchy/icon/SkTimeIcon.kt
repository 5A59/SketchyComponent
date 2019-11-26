package com.zylab.sketchy.icon

import android.graphics.Canvas
import com.zylab.sketchy.drawable.SkDrawable
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkCircle
import com.zylab.sketchy.shape.SkLine
import kotlin.math.min

/**
 * Created by zhangyi on 19-11-26
 */

class SkTimeIcon : SkDrawable() {
    var circle = SkCircle()
    var line1 = SkLine()
    var line2 = SkLine()

    override fun parse() {
        circle.bgColor = backgroundColor
        circle.color = lineColor
        circle.fillColor = fillColor

        line1.bgColor = backgroundColor
        line1.color = lineColor
        line1.fillColor = fillColor

        line2.bgColor = backgroundColor
        line2.color = lineColor
        line2.fillColor = fillColor

        circle.center = SkPoint(width / 2, height / 2)
        circle.radius = min(width / 2, height / 2)
        circle.parse()

        line1.reset(SkPoint(circle.center.x, circle.center.y), SkPoint(circle.center.x + circle.radius, circle.center.y))
        line2.reset(SkPoint(circle.center.x, circle.center.y), SkPoint(circle.center.x, circle.center.y - circle.radius))
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        circle.draw(canvas)
        line1.draw(canvas)
        line2.draw(canvas)
    }
}
