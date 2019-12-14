package com.zylab.sketchy.icon

import android.graphics.Canvas
import com.zylab.sketchy.drawable.SkDrawable
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkLine
import com.zylab.sketchy.shape.SkShape

/**
 * Created by zhangyi on 19-11-26
 */

class SkListIcon : SkDrawable() {
    private var line = SkLine()
    private var line1 = SkLine()
    private var line2 = SkLine()

    private fun setColor(shape: SkShape) {
        shape.bgColor = bgColor
        shape.borderColor = borderColor
        shape.fillColor = fillColor
    }

    override fun parse() {
        setColor(line)
        setColor(line1)
        setColor(line2)

        var xSpace = width / 4
        var ySpace = height / 4

        line.reset(SkPoint(xSpace, ySpace), SkPoint(xSpace * 3, ySpace))
        line1.reset(SkPoint(xSpace, ySpace * 2), SkPoint(xSpace * 3, ySpace * 2))
        line2.reset(SkPoint(xSpace, ySpace * 3), SkPoint(xSpace * 3, ySpace * 3))
        line.parse()
        line1.parse()
        line2.parse()
    }

    override fun onDraw(canvas: Canvas) {
        line.draw(canvas)
        line1.draw(canvas)
        line2.draw(canvas)
    }
}
