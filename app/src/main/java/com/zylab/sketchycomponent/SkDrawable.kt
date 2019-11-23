package com.zylab.sketchycomponent

import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.Log
import com.zylab.sketchycomponent.model.SkPoint
import com.zylab.sketchycomponent.shape.SkArrow
import com.zylab.sketchycomponent.shape.SkCircle
import com.zylab.sketchycomponent.shape.SkLine
import com.zylab.sketchycomponent.shape.SkSquare
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

/**
 * Created by zhangyi on 19-10-29
 *
 */

class SkDrawable : Drawable() {
    private val paint = Paint()
    private val path = Path()

    init {
//        paint.strokeWidth = 40f
//        paint.style = Paint.Style.STROKE
        Log.d("Test", bounds.toString())
    }

    override fun setAlpha(alpha: Int) {
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }

    override fun draw(canvas: Canvas) {
        Log.d("Test", bounds.toString())
        val line: SkLine = SkLine(SkPoint(0.0, 300.0), SkPoint(1000.0, 300.0))
        line.draw(canvas)

        val arrow = SkArrow(SkPoint(500.0, 500.0), 100.0, 100.0)
        arrow.draw(canvas)

        val circle = SkCircle(SkPoint(300.0, 600.0), 200.0)
        circle.draw(canvas)

        val square = SkSquare(SkPoint(10.0, 300.0), 100.0, 100.0)
        square.draw(canvas)
    }

    private fun drawLine(canvas: Canvas, lineY: Double, startX: Int, endX: Int) {
        var lastEnd = startX
        var step = 50
        var space = 15
        for (start in startX..endX step 50) {
            var x = Random.nextDouble(lastEnd.toDouble(), start.toDouble() + step).toFloat()
            var y = Random.nextDouble(lineY, lineY + space.toDouble()).toFloat()
            path.moveTo(lastEnd.toFloat(), lineY.toFloat())
            path.quadTo(x, y, start.toFloat() + step, lineY.toFloat())
            canvas.drawPath(path, paint)

            x = Random.nextDouble(lastEnd.toDouble(), start.toDouble() + step).toFloat()
            y = Random.nextDouble(lineY - space.toDouble(), lineY).toFloat()
            path.moveTo(lastEnd.toFloat(), lineY.toFloat())
            path.quadTo(x, y, start.toFloat() + step, lineY.toFloat())
            canvas.drawPath(path, paint)

            lastEnd = start
        }
    }

    private fun drawVLine(canvas: Canvas, lineX: Double, startY: Int, endY: Int) {
        var lastEnd = startY
        var step = 50
        var space = 15
        for (start in startY..endY step 50) {
            var y = Random.nextDouble(lastEnd.toDouble(), start.toDouble() + step).toFloat()
            var x = Random.nextDouble(lineX, lineX + space.toDouble()).toFloat()
            path.moveTo(lineX.toFloat(), lastEnd.toFloat())
            path.quadTo(x, y, lineX.toFloat(), start.toFloat() + step)
            canvas.drawPath(path, paint)

            x = Random.nextDouble(lineX - space.toDouble(), lineX).toFloat()
            y = Random.nextDouble(lastEnd.toDouble(), start.toDouble() + step).toFloat()
            path.moveTo(lineX.toFloat(), lastEnd.toFloat())
            path.quadTo(x, y, lineX.toFloat(), start.toFloat() + step)
            canvas.drawPath(path, paint)

            lastEnd = start
        }
    }

}
