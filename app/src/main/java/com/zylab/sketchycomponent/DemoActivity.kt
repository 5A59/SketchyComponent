package com.zylab.sketchycomponent

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.zylab.sketchy.drawable.SkArcDrawable
import com.zylab.sketchy.drawable.SkCircleDrawable
import com.zylab.sketchy.drawable.SkImgDrawable
import com.zylab.sketchy.drawable.SkSquareDrawable
import com.zylab.sketchy.icon.SkArrowIcon
import com.zylab.sketchy.icon.SkListIcon
import kotlinx.android.synthetic.main.activity_demo.*

/**
 * Created by zhangyi on 19-11-24
 */

class DemoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        text.background = SkSquareDrawable().apply {
            fillColor = resources.getColor(android.R.color.holo_green_dark)
        }

        text2.background = SkSquareDrawable().apply {
            fillColor = resources.getColor(android.R.color.holo_orange_dark)
        }

        img.setImageDrawable(SkCircleDrawable().apply {
            fillColor = resources.getColor(android.R.color.holo_blue_dark)
        })

        arrowImg.setImageDrawable(SkArrowIcon())
        arrowImg1.setImageDrawable(SkArrowIcon().apply {
            style = SkArrowIcon.STYLE1
            direction = SkArrowIcon.RIGHT
        })

        arcImg.setImageDrawable(SkArcDrawable().apply {
            fillColor = resources.getColor(android.R.color.holo_blue_dark)
        })

        bitmapImg.setImageDrawable(SkImgDrawable().apply {
            style = SkImgDrawable.STYLE_CIRCLE
            img = resources.getDrawable(R.mipmap.cat)
        })

        bitmapImg2.setImageDrawable(SkImgDrawable().apply {
            img = resources.getDrawable(R.mipmap.cat)
        })

        icon.setImageDrawable(SkListIcon())
    }
}
