package com.zylab.sketchy.shape.img

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import com.zylab.sketchy.shape.SkSquare

/**
 * Created by zhangyi on 19-11-24
 */

class SkSquareImg : SkSquare() {
    var img: Drawable? = null

    override fun fillShape(canvas: Canvas) {
        if (img == null) {
            super.fillShape(canvas)
            return
        }
        img?.let {
            it.setBounds(
                startPoint.x.toInt(),
                startPoint.y.toInt(),
                (startPoint.x + width).toInt(),
                (startPoint.y + height).toInt()
            )
            it.draw(canvas)
        }
    }
}
