package com.zylab.sketchy.drawable

import com.zylab.sketchy.model.DEFAULT_POINT
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkArc

/**
 * Created by zhangyi on 19-11-24
 */

class SkArcDrawable(
    width: Double = 0.0,
    height: Double = 0.0
) : SkDrawable(width, height) {
    var startAngle: Double = 0.0
    var sweepAngle: Double = 0.0
    var center: SkPoint = DEFAULT_POINT
    var radius: Double = 0.0

    init {
        shape = SkArc()
    }

    override fun parse() {
        super.parse()
        (shape as? SkArc)?.let {
            if (!isValidPoint(center)) {
                it.center = SkPoint(width / 2, height / 2)
            } else {
                it.center = center
            }
            if (radius <= 0.0) {
                it.radius = width / 2 - it.getShapeWidth()
            } else {
                it.radius = radius
            }
            it.startAngle = startAngle
            it.sweepAngle = sweepAngle
            it.linkCenter = true
        }
    }

}
