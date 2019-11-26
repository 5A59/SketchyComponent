package com.zylab.sketchy.drawable

import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkArc

/**
 * Created by zhangyi on 19-11-24
 */

class SkArcDrawable : SkDrawable() {
    init {
        shape = SkArc()
    }

    override fun parse() {
        super.parse()
        (shape as? SkArc)?.let {
            it.center = SkPoint(width / 2, height / 2)
            it.radius = width / 2 - it.getShapeWidth()
            it.startAngle = 0.0
            it.sweepAngle = 180.0
            it.linkCenter = true
        }
    }
}
