package com.zylab.sketchycomponent

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.zylab.sketchy.drawable.*
import com.zylab.sketchy.icon.SkArrowIcon
import com.zylab.sketchycomponent.drawable.SkBarChatDrawable
import com.zylab.sketchycomponent.drawable.SkLineChatDrawable
import com.zylab.sketchycomponent.drawable.SkPieChatDrawable
import kotlinx.android.synthetic.main.activity_other.*

/**
 * Created by zhangyi on 19-11-28
 */

class OtherActivity : BaseActivity() {
    private val drawables: MutableList<SkDrawable> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        initTitleBar()
        scrollView.background = SkSquareDrawable().apply {
            fillColor = resources.getColor(R.color.bg5)
        }
        initData()

        drawables.forEach {
            val imageView = ImageView(this)
            val layoutParams = LinearLayout.LayoutParams(Utils.dp2px(this, 250F), Utils.dp2px(this, 250F))
            imageView.background = it
            layout.addView(imageView, layoutParams)
        }
    }

    private fun initTitleBar() {
        toolbar.background = SkSquareDrawable().apply {
            fillColor = resources.getColor(R.color.toolbar)
        }
        arrowImg.background = SkArrowIcon()
        arrowImg.setOnClickListener {
            finish()
        }
        titleText.text = "Other"
    }

    private fun initData() {
        drawables.add(SkLineChatDrawable())
        drawables.add(SkPieChatDrawable(this))
        drawables.add(SkBarChatDrawable(this))
    }
}
