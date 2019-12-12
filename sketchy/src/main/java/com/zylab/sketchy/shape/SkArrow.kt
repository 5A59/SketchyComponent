package com.zylab.sketchy.shape

import android.graphics.Canvas
import com.zylab.sketchy.model.DEFAULT_POINT
import com.zylab.sketchy.model.SkBezier
import com.zylab.sketchy.model.SkPoint

/**
 * Created by zhangyi on 19-11-19
 */

class SkArrow(var startPoint: SkPoint = DEFAULT_POINT, var width: Double = 0.0, var height: Double = 0.0) : SkShape() {
    companion object {
        const val STYLE = 0
        const val STYLE1 = 1

        const val UP = 0
        const val DOWN = 1
        const val LEFT = 2
        const val RIGHT = 3
    }
    var style = STYLE
    var direction: Int = LEFT

    override fun parse(bezierList: MutableList<SkBezier>) {
    }

    override fun drawBackground(canvas: Canvas) {
        if (bgColor != 0) {
            bgPaint.color = bgColor
            canvas.drawRect(startPoint.x.toFloat(), (startPoint.y).toFloat(),
                width.toFloat(), height.toFloat(), bgPaint)
        }
    }

    override fun draw(canvas: Canvas) {
        if (!isValidPoint(startPoint) || width <= 0 || height <= 0) {
            return
        }
        drawBackground(canvas)

        if (color != 0) {
            paint.color = color
        }
        val line = SkLine()
        line.brushWidth = brushWidth
        var arrowPoint = SkPoint(0.0, 0.0)
        when (direction) {
            LEFT -> {
                arrowPoint.x = startPoint.x
                arrowPoint.y = startPoint.y + height / 2
                if (style == STYLE) {
                    line.reset(arrowPoint, SkPoint(arrowPoint.x + width, arrowPoint.y))
                    line.draw(canvas)
                }
                line.reset(arrowPoint,
                    SkPoint(arrowPoint.x + width / 2, arrowPoint.y - height / 2)
                )
                line.draw(canvas)
                line.reset(arrowPoint,
                    SkPoint(arrowPoint.x + width/ 2, arrowPoint.y + height / 2)
                )
                line.draw(canvas)
            }
            RIGHT -> {
                arrowPoint.x = startPoint.x + width
                arrowPoint.y = startPoint.y + height / 2
                if (style == STYLE) {
                    line.reset(arrowPoint, SkPoint(arrowPoint.x - width, arrowPoint.y))
                    line.draw(canvas)
                }
                line.reset(arrowPoint,
                    SkPoint(arrowPoint.x - width / 2, arrowPoint.y - height / 2)
                )
                line.draw(canvas)
                line.reset(arrowPoint,
                    SkPoint(arrowPoint.x - width / 2, arrowPoint.y + height / 2)
                )
                line.draw(canvas)
            }
            UP -> {
                arrowPoint.x = startPoint.x + width / 2
                arrowPoint.y = startPoint.y
                if (style == STYLE) {
                    line.reset(arrowPoint, SkPoint(arrowPoint.x, arrowPoint.y + height))
                    line.draw(canvas)
                }
                line.reset(arrowPoint,
                    SkPoint(arrowPoint.x - width / 2, arrowPoint.y + height / 2)
                )
                line.draw(canvas)
                line.reset(arrowPoint,
                    SkPoint(arrowPoint.x + width / 2, arrowPoint.y + height / 2)
                )
                line.draw(canvas)
            }
            DOWN -> {
                arrowPoint.x = startPoint.x + width / 2
                arrowPoint.y = startPoint.y + height
                if (style == STYLE) {
                    line.reset(arrowPoint, SkPoint(arrowPoint.x, arrowPoint.y - height))
                    line.draw(canvas)
                }
                line.reset(arrowPoint,
                    SkPoint(arrowPoint.x - width / 2, arrowPoint.y - height / 2)
                )
                line.draw(canvas)
                line.reset(arrowPoint,
                    SkPoint(arrowPoint.x + width / 2, arrowPoint.y - height / 2)
                )
                line.draw(canvas)
            }
        }
    }
}
