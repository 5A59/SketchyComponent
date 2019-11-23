package com.zylab.sketchycomponent.shape

import android.graphics.*
import com.zylab.sketchycomponent.model.DEFAULT_POINT
import com.zylab.sketchycomponent.model.SkPoint

/**
 * Created by zhangyi on 19-11-23
 */

class SkSquare(var startPoint: SkPoint = DEFAULT_POINT, var width: Double = 0.0, var height: Double = 0.0) : SkShape() {

    private val lines: MutableList<SkLine> = ArrayList()
    var backgroundColor: Int = 0

    override fun parse() {
        if (!isValidPoint(startPoint) || width <= 0.0 || height <= 0.0) {
            return
        }
        var line = SkLine(startPoint, SkPoint(startPoint.x + width, startPoint.y))
        lines.add(line)
        line = SkLine(SkPoint(startPoint.x, startPoint.y + height), SkPoint(startPoint.x + width, startPoint.y + height))
        lines.add(line)
        line = SkLine(startPoint, SkPoint(startPoint.x, startPoint.y + height))
        lines.add(line)
        line = SkLine(SkPoint(startPoint.x + width, startPoint.y), SkPoint(startPoint.x + width, startPoint.y + height))
        lines.add(line)
    }

    override fun draw(canvas: Canvas) {
        path.close()
        canvas.clipPath(path)
        canvas.drawColor(Color.parseColor("#ff6633"))
        lines.forEach {
            it.draw(canvas)
        }
    }
}
