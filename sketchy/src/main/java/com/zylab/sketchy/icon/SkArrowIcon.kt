package com.zylab.sketchy.icon

import com.zylab.sketchy.drawable.SkDrawable
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkArrow

/**
 * Created by zhangyi on 19-11-24
 */

class SkArrowIcon : SkDrawable() {
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

    init {
        shape = SkArrow()
    }

    override fun parse() {
        super.parse()
        (shape as? SkArrow)?.let {
            it.style = style
            it.direction = direction
            it.width = width
            it.height = height
            it.startPoint = SkPoint(0.0, 0.0)
        }
    }
}
