package com.zylab.sketchy.drawable

import android.graphics.drawable.Drawable
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.img.SkCircleImg
import com.zylab.sketchy.shape.img.SkSquareImg

/**
 * Created by zhangyi on 19-11-24
 */

class SkImgDrawable(width: Double = 0.0, height: Double = 0.0) : SkDrawable(width, height) {
    companion object {
        const val STYLE_SQUARE = 1
        const val STYLE_CIRCLE = 2
    }

    var style = STYLE_SQUARE
    var img: Drawable? = null

    override fun parse() {
        if (style == STYLE_CIRCLE) {
            shape = SkCircleImg()
            (shape as? SkCircleImg)?.let {
                it.img = img
                it.center = SkPoint(width / 2, height / 2)
                it.radius = width / 2 - it.getShapeWidth()
                it.parse()
            }
        } else {
            shape = SkSquareImg()
            (shape as? SkSquareImg)?.let {
                it.img = img
                it.startPoint =
                    SkPoint(it.getShapeWidth(), it.getShapeWidth())
                it.width = width - it.getShapeWidth() * 2
                it.height = height - it.getShapeWidth() * 2
                it.parse()
            }
        }
        super.parse()
    }
}
