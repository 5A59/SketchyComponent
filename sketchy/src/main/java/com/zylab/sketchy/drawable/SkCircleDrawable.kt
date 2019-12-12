package com.zylab.sketchy.drawable

import com.zylab.sketchy.model.DEFAULT_POINT
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkCircle
import kotlin.math.min

/**
 * Created by zhangyi on 19-11-24
 */

class SkCircleDrawable(width: Double = 0.0, height: Double = 0.0) : SkDrawable(width, height) {
    var center: SkPoint = DEFAULT_POINT
    var radius: Double = 0.0

    init {
        shape = SkCircle()
    }

    override fun parse() {
        super.parse()
        (shape as? SkCircle)?.let {
            it.center = if (isValidPoint(center)) {
                center
            } else {
                SkPoint(width / 2, height / 2)
            }
            it.radius = if (radius <= 0) {
                min(width / 2, height / 2) - it.getShapeWidth()
            } else {
                radius
            }
        }
    }
}
