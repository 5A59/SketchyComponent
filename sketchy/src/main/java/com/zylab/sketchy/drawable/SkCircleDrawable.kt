package com.zylab.sketchy.drawable

import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkCircle

/**
 * Created by zhangyi on 19-11-24
 */

class SkCircleDrawable : SkDrawable() {
    init {
        shape = SkCircle()
    }

    override fun parse() {
        super.parse()
        (shape as? SkCircle)?.let {
            it.center = SkPoint(width / 2, height / 2)
            it.radius = width / 2 - it.getShapeWidth()
        }
    }
}
