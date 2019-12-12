package com.zylab.sketchy.shape

import android.graphics.*
import com.zylab.sketchy.model.DEFAULT_POINT
import com.zylab.sketchy.model.SkBezier
import com.zylab.sketchy.model.SkPoint

/**
 * Created by zhangyi on 19-11-19
 */

abstract class SkShape {
    protected var path: Path = Path()
    protected val paint = Paint()
    protected val fillPaint = Paint()
    protected val bgPaint = Paint()
    protected val clearPaint = Paint()

    var bgColor: Int = 0
    var color: Int = 0
    var fillColor: Int = 0

    protected var bezierList: MutableList<SkBezier> = ArrayList()

    var brushWidth: Double = 11.0
    protected var step = 50.0

    init {
        clearPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    fun getShapeWidth(): Double {
        return brushWidth
    }

    fun parse() {
        parse(bezierList)
    }

    abstract fun parse(bezierList: MutableList<SkBezier>)

    protected open fun drawBackground(canvas: Canvas) {
        if (bgColor != 0) {
            canvas.drawColor(bgColor)
        }
    }

    protected open fun fillShape(canvas: Canvas) {
    }

    open fun draw(canvas: Canvas) {
        if (bezierList.isEmpty()) {
            parse()
        }
        drawBackground(canvas)
        fillShape(canvas)
        if (color != 0) {
            paint.color = color
        }
        if (bezierList.isNotEmpty()) {
            path.rewind()
            bezierList.forEach {
                path.moveTo(it.startPoint.x.toFloat(), it.startPoint.y.toFloat())
                path.quadTo(
                    it.controlPoint.x.toFloat(),
                    it.controlPoint.y.toFloat(),
                    it.endPoint.x.toFloat(),
                    it.endPoint.y.toFloat()
                )
            }
            canvas.drawPath(path, paint)
        }
    }

    protected fun isValidPoint(point: SkPoint?): Boolean {
        return point != null && point != DEFAULT_POINT
    }
}
