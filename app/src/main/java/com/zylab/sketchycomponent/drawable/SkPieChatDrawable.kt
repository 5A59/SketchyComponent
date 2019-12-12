package com.zylab.sketchycomponent.drawable

import android.content.Context
import android.graphics.Canvas
import com.zylab.sketchy.drawable.SkDrawable
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkArc
import com.zylab.sketchycomponent.R

/**
 * Created by zhangyi on 19-12-1
 */

class SkPieChatDrawable(private val context: Context) : SkDrawable() {
    private val arc1 = SkArc()
    private val arc2 = SkArc()
    private val arc3 = SkArc()

    override fun parse() {
        super.parse()
        val center = SkPoint(300.0, 350.0)
        val radius = 200.0
        arc1.center = center
        arc1.radius = radius
        arc1.startAngle = 0.0
        arc1.sweepAngle = 90.0
        arc1.fillColor = context.resources.getColor(R.color.bg6)

        arc2.center = center
        arc2.radius = radius
        arc2.startAngle = 90.0
        arc2.sweepAngle = 135.0
        arc2.fillColor = context.resources.getColor(R.color.bg7)

        arc3.center = center
        arc3.radius = radius
        arc3.startAngle = 225.0
        arc3.sweepAngle = 135.0
        arc3.fillColor = context.resources.getColor(R.color.bg8)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        arc1.draw(canvas)
        arc2.draw(canvas)
        arc3.draw(canvas)
    }
}
