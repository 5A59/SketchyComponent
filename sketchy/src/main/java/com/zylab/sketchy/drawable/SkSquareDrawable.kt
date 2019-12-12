package com.zylab.sketchy.drawable

import com.zylab.sketchy.model.DEFAULT_POINT
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkSquare

/**
 * Created by zhangyi on 19-11-23
 */

class SkSquareDrawable(width: Double = 0.0, height: Double = 0.0) : SkDrawable(width, height) {
    var startPoint: SkPoint = DEFAULT_POINT
    var squareWidth: Double = 0.0
    var squareHeight: Double = 0.0

    init {
        shape = SkSquare()
    }

    override fun parse() {
        super.parse()
        (shape as? SkSquare)?.let {
            it.startPoint = if (!isValidPoint(startPoint)) {
                SkPoint(it.getShapeWidth(), it.getShapeWidth())
            } else {
                startPoint
            }
            it.width = if (squareWidth <= 0.0) width - it.getShapeWidth() * 2 else squareWidth
            it.height = if (squareHeight <= 0.0) height - it.getShapeWidth() * 2 else squareHeight
            it.parse()
        }
    }
}
