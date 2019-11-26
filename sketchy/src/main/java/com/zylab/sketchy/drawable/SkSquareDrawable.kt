package com.zylab.sketchy.drawable

import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkSquare

/**
 * Created by zhangyi on 19-11-23
 */

class SkSquareDrawable(width: Double = 0.0, height: Double = 0.0) : SkDrawable(width, height) {
    init {
        shape = SkSquare()
    }

    override fun parse() {
        super.parse()
        (shape as? SkSquare)?.let {
            it.startPoint = SkPoint(it.getShapeWidth(), it.getShapeWidth())
            it.width = width - it.getShapeWidth() * 2
            it.height = height - it.getShapeWidth() * 2
            it.parse()
        }
    }
}
