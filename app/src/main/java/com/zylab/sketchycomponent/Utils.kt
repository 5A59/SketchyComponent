package com.zylab.sketchycomponent

import android.content.Context

/**
 * Created by zhangyi on 19-11-30
 */

class Utils {
    companion object {
        var scale = 0F

        fun dp2px(context: Context, dp: Float): Int {
            if (scale <= 0F) {
                scale = context.resources.displayMetrics.density
            }
            return (dp * scale + 0.5F).toInt()
        }
    }
}
