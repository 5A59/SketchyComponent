package com.zylab.sketchycomponent

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zylab.sketchy.drawable.*
import com.zylab.sketchy.icon.SkArrowIcon
import com.zylab.sketchy.icon.SkListIcon
import com.zylab.sketchy.icon.SkSearchIcon
import com.zylab.sketchy.icon.SkTimeIcon
import kotlinx.android.synthetic.main.activity_icon.*
import kotlinx.android.synthetic.main.activity_shape.arrowImg
import kotlinx.android.synthetic.main.activity_shape.titleText
import kotlinx.android.synthetic.main.activity_shape.toolbar

/**
 * Created by zhangyi on 19-11-28
 */

class IconActivity : BaseActivity() {
    val icons: MutableList<SkDrawable> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon)
        initTitleBar()
        initData()
        recycler.background = SkSquareDrawable().apply {
            fillColor = resources.getColor(R.color.bg5)
        }
        recycler.layoutManager = GridLayoutManager(this, 3)
        recycler.adapter = IconAdapter()
    }

    private fun initData() {
        icons.add(SkArrowIcon().apply {
            direction = SkArrowIcon.LEFT
        })
        icons.add(SkArrowIcon().apply {
            direction = SkArrowIcon.RIGHT
        })
        icons.add(SkArrowIcon().apply {
            direction = SkArrowIcon.UP
        })
        icons.add(SkArrowIcon().apply {
            direction = SkArrowIcon.DOWN
        })
        icons.add(SkArrowIcon().apply {
            style = SkArrowIcon.STYLE1
            direction = SkArrowIcon.LEFT
        })
        icons.add(SkArrowIcon().apply {
            style = SkArrowIcon.STYLE1
            direction = SkArrowIcon.RIGHT
        })
        icons.add(SkArrowIcon().apply {
            style = SkArrowIcon.STYLE1
            direction = SkArrowIcon.UP
        })
        icons.add(SkArrowIcon().apply {
            style = SkArrowIcon.STYLE1
            direction = SkArrowIcon.DOWN
        })
        icons.add(SkListIcon())
        icons.add(SkSearchIcon().apply {
            fillColor = resources.getColor(R.color.bg5)
        })
        icons.add(SkTimeIcon())
    }

    private fun initTitleBar() {
        toolbar.background = SkSquareDrawable().apply {
            fillColor = resources.getColor(R.color.toolbar)
        }
        arrowImg.background = SkArrowIcon()
        arrowImg.setOnClickListener {
            finish()
        }
        titleText.text = "Icon"
    }

    inner class IconAdapter : RecyclerView.Adapter<IconViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconViewHolder {
            return IconViewHolder(LinearLayout(this@IconActivity))
        }

        override fun getItemCount(): Int {
            return icons.size
        }

        override fun onBindViewHolder(holder: IconViewHolder, position: Int) {
            holder.imageView.background = icons[position]
        }
    }

    inner class IconViewHolder(itemView: LinearLayout): RecyclerView.ViewHolder(itemView) {
        val imageView = ImageView(this@IconActivity)
        init {
            val padding = Utils.dp2px(this@IconActivity, 10F)
            itemView.setPadding(padding, padding, padding, padding)
            itemView.gravity = Gravity.CENTER
            val params = LinearLayout.LayoutParams(Utils.dp2px(this@IconActivity, 50F), Utils.dp2px(this@IconActivity, 50F))
            itemView.addView(imageView, params)
        }
    }
}
