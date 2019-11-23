package com.zylab.sketchycomponent.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import com.zylab.sketchycomponent.model.DEFAULT_POINT
import com.zylab.sketchycomponent.model.SkBezier
import com.zylab.sketchycomponent.model.SkPoint

/**
 * Created by zhangyi on 19-11-19
 */

abstract class SkShape {
    var path: Path = Path()
    protected val paint = Paint()
    protected var bezierList: MutableList<SkBezier> = ArrayList()
    protected var brushWidth: Double = 15.0
    protected var step = 50.0

    fun getShapeWidth(): Double {
        return brushWidth
    }

    abstract fun parse()

    open fun draw(canvas: Canvas) {
        if (bezierList.isEmpty()) {
            parse()
        }
        if (bezierList.isNotEmpty()) {
            bezierList.forEach {
                path.moveTo(it.startPoint.x.toFloat(), it.startPoint.y.toFloat())
                path.quadTo(
                    it.controlPoint.x.toFloat(),
                    it.controlPoint.y.toFloat(),
                    it.endPoint.x.toFloat(),
                    it.endPoint.y.toFloat()
                )
                canvas.drawPath(path, paint)
            }
        }
    }

    protected fun isValidPoint(point: SkPoint?): Boolean {
        return point != null && point != DEFAULT_POINT
    }
}
