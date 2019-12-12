package com.zylab.sketchycomponent.drawable

import android.graphics.Canvas
import com.zylab.sketchy.drawable.SkDrawable
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkArrow
import com.zylab.sketchy.shape.SkLine

/**
 * Created by zhangyi on 19-12-1
 */

class SkLineChatDrawable : SkDrawable() {
    private var xAxle = SkLine()
    private var xAxleArrow = SkArrow()
    private var yAxle = SkLine()
    private var yAxleArrow = SkArrow()

    private var line1 = SkLine()
    private var line2 = SkLine()
    private var line3 = SkLine()

    override fun parse() {
        super.parse()
        xAxle.reset(SkPoint(100.0, 600.0), SkPoint(100.0, 100.0))
        xAxleArrow.direction = SkArrow.UP
        xAxleArrow.style = SkArrow.STYLE1
        xAxleArrow.width = 60.0
        xAxleArrow.height = 60.0
        xAxleArrow.startPoint = SkPoint(70.0, 100.0)
        xAxleArrow.parse()

        yAxle.reset(SkPoint(100.0, 600.0), SkPoint(600.0, 600.0))
        yAxleArrow.direction = SkArrow.RIGHT
        yAxleArrow.style = SkArrow.STYLE1
        yAxleArrow.width = 60.0
        yAxleArrow.height = 60.0
        yAxleArrow.startPoint = SkPoint(540.0, 570.0)
        yAxleArrow.parse()

        val p1 = SkPoint(200.0, 400.0)
        val p2 = SkPoint(300.0, 300.0)
        val p3 = SkPoint(400.0, 150.0)
        val p4 = SkPoint(480.0, 300.0)
        line1.reset(p1, p2)
        line2.reset(p2, p3)
        line3.reset(p3, p4)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        xAxle.draw(canvas)
        xAxleArrow.draw(canvas)
        yAxle.draw(canvas)
        yAxleArrow.draw(canvas)

        line1.draw(canvas)
        line2.draw(canvas)
        line3.draw(canvas)
    }
}
