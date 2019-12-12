package com.zylab.sketchycomponent.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import com.zylab.sketchy.drawable.SkDrawable
import com.zylab.sketchycomponent.R
import com.zylab.sketchycomponent.Utils
import kotlinx.android.synthetic.main.display_line.view.*

/**
 * Created by zhangyi on 19-11-30
 */

class DisplayLine constructor(context: Context, attributes: AttributeSet? = null) :
    LinearLayout(context, attributes) {

    var displayData: DisplayData? = null
        set(value) {
            field = value
            fillLayout()
        }

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
        LayoutInflater.from(context).inflate(R.layout.display_line, this, true)
    }

    private fun fillLayout() {
        displayData?.let {
            displayName.text = it.name
            it.drawables.forEach { drawable ->
                val img = ImageView(context)
                val params = LayoutParams(Utils.dp2px(context, it.width), Utils.dp2px(context, it.height))
                img.background = drawable
                displayLayout.addView(img, params)
            }
        }
    }

    data class DisplayData(
        var name: String,
        var drawables: MutableList<SkDrawable>,
        var width: Float = 100F,
        var height: Float = 100F
    )
}
