package com.zylab.sketchy.shape.img

import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.Canvas
import com.zylab.sketchy.shape.SkCircle


/**
 * Created by zhangyi on 19-11-24
 */

class SkCircleImg : SkCircle() {
    var img: Drawable? = null

    var circlePath: Path = Path()

    override fun fillShape(canvas: Canvas) {
        if (img == null) {
            super.fillShape(canvas)
            return
        }
        img?.let {
            circlePath.addCircle(center.x.toFloat(), center.y.toFloat(), radius.toFloat(), Path.Direction.CW)
            circlePath.fillType = Path.FillType.WINDING
            circlePath.close()
            canvas.save()
            canvas.clipPath(circlePath)
            it.setBounds(
                ((center.x - radius).toInt()),
                (center.y - radius).toInt(),
                (center.x + radius).toInt(),
                (center.y + radius).toInt()
            )
            it.draw(canvas)
            canvas.restore()
        }
    }
}
