package com.zylab.sketchycomponent.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import com.zylab.sketchy.drawable.SkLineDrawable
import com.zylab.sketchycomponent.Utils

/**
 * Created by zhangyi on 19-11-30
 */

class DisplayLayout(context: Context, attributeSet: AttributeSet? = null) : LinearLayout(context, attributeSet) {
    var displayDataList: MutableList<DisplayLine.DisplayData> = ArrayList()
        set(value) {
            field = value
            fillLayout()
        }

    init {
        orientation = VERTICAL
    }

    private fun fillLayout() {
        displayDataList.forEach {
            val line = DisplayLine(context)
            line.displayData = it
            val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            params.topMargin = Utils.dp2px(context, 10F)
            addView(line, params)

            val divider = ImageView(context)
            val dividerParams = LayoutParams(LayoutParams.MATCH_PARENT, Utils.dp2px(context, 10F))
            dividerParams.topMargin = Utils.dp2px(context, 10F)
            divider.background = SkLineDrawable()
            addView(divider, dividerParams)
        }
    }
}
