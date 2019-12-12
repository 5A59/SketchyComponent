package com.zylab.sketchycomponent.drawable

import android.content.Context
import android.graphics.Canvas
import com.zylab.sketchy.drawable.SkDrawable
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchy.shape.SkArrow
import com.zylab.sketchy.shape.SkLine
import com.zylab.sketchy.shape.SkSquare
import com.zylab.sketchycomponent.R

/**
 * Created by zhangyi on 19-12-1
 */

class SkBarChatDrawable(private val context: Context) : SkDrawable() {
    private var xAxle = SkLine()
    private var xAxleArrow = SkArrow()
    private var yAxle = SkLine()
    private var yAxleArrow = SkArrow()

    private var bar1 = SkSquare()
    private var bar2 = SkSquare()
    private var bar3 = SkSquare()

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

        bar1.startPoint = SkPoint(150.0, 250.0)
        bar1.width = 100.0
        bar1.height = 350.0
        bar1.fillColor = context.resources.getColor(R.color.bg6)
        bar1.parse()

        bar2.startPoint = SkPoint(290.0, 150.0)
        bar2.width = 100.0
        bar2.height = 450.0
        bar2.fillColor = context.resources.getColor(R.color.bg7)
        bar2.parse()

        bar3.startPoint = SkPoint(430.0, 400.0)
        bar3.width = 100.0
        bar3.height = 200.0
        bar3.fillColor = context.resources.getColor(R.color.bg8)
        bar3.parse()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        xAxle.draw(canvas)
        xAxleArrow.draw(canvas)
        yAxle.draw(canvas)
        yAxleArrow.draw(canvas)

        bar1.draw(canvas)
        bar2.draw(canvas)
        bar3.draw(canvas)
    }
}
