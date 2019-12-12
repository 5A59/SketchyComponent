package com.zylab.sketchy.drawable

import com.zylab.sketchy.model.DEFAULT_POINT
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkLine

/**
 * Created by zhangyi on 19-11-30
 */

class SkLineDrawable(
    width: Double = 0.0,
    height: Double = 0.0
) : SkDrawable(width, height) {
    var startPoint: SkPoint = DEFAULT_POINT
    var endPoint: SkPoint = DEFAULT_POINT

    init {
        shape = SkLine()
    }

    override fun parse() {
        super.parse()
        (shape as? SkLine)?.let {
            if (!isValidPoint(startPoint) || !isValidPoint(endPoint)) {
                it.reset(SkPoint(0.0, it.getShapeWidth()), SkPoint(width, it.getShapeWidth()))
            } else {
                it.reset(startPoint, endPoint)
            }
        }
    }
}
