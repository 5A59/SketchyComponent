package com.zylab.sketchycomponent

import android.os.Bundle
import com.zylab.sketchy.drawable.*
import com.zylab.sketchy.icon.SkArrowIcon
import com.zylab.sketchy.model.SkPoint
import com.zylab.sketchycomponent.view.DisplayLine
import kotlinx.android.synthetic.main.activity_shape.*
import kotlinx.android.synthetic.main.activity_shape.toolbar

/**
 * Created by zhangyi on 19-11-28
 */

class ShapeActivity : BaseActivity() {
    private lateinit var displayDataList: MutableList<DisplayLine.DisplayData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape)
        initTitleBar()
        scrollView.background = SkSquareDrawable().apply {
            fillColor = resources.getColor(R.color.bg5)
        }
        initData()
        layout.displayDataList = displayDataList
    }

    private fun initTitleBar() {
        toolbar.background = SkSquareDrawable().apply {
            fillColor = resources.getColor(R.color.toolbar)
        }
        arrowImg.background = SkArrowIcon()
        arrowImg.setOnClickListener {
            finish()
        }
        titleText.text = "Shape"
    }

    private fun initData() {
        displayDataList = ArrayList<DisplayLine.DisplayData>().apply {
            add(DisplayLine.DisplayData("Line", ArrayList<SkDrawable>().apply {
                add(
                    SkLineDrawable().apply {
                        startPoint = SkPoint(0.0, Utils.dp2px(this@ShapeActivity, 50F).toDouble())
                        endPoint = SkPoint(
                            Utils.dp2px(this@ShapeActivity, 100F).toDouble(),
                            Utils.dp2px(this@ShapeActivity, 50F).toDouble()
                        )
                    }
                )
                add(
                    SkLineDrawable().apply {
                        startPoint = SkPoint(Utils.dp2px(this@ShapeActivity, 50F).toDouble(), 0.0)
                        endPoint = SkPoint(
                            Utils.dp2px(this@ShapeActivity, 50F).toDouble(),
                            Utils.dp2px(this@ShapeActivity, 100F).toDouble()
                        )
                    }
                )
                add(
                    SkLineDrawable().apply {
                        startPoint = SkPoint(0.0, 0.0)
                        endPoint = SkPoint(
                            Utils.dp2px(this@ShapeActivity, 100F).toDouble(),
                            Utils.dp2px(this@ShapeActivity, 100F).toDouble()
                        )
                    }
                )
            }))
            add(DisplayLine.DisplayData("Square", ArrayList<SkDrawable>().apply {
                add(SkSquareDrawable())
                add(
                    SkSquareDrawable().apply {
                        startPoint = SkPoint(0.0, Utils.dp2px(this@ShapeActivity, 25F).toDouble())
                        squareWidth = Utils.dp2px(this@ShapeActivity, 100F).toDouble()
                        squareHeight = Utils.dp2px(this@ShapeActivity, 50F).toDouble()
                        fillColor = resources.getColor(R.color.bg1)
                    }
                )
                add(
                    SkSquareDrawable().apply {
                        width = Utils.dp2px(this@ShapeActivity, 50F).toDouble()
                        height = Utils.dp2px(this@ShapeActivity, 100F).toDouble()
                        fillColor = resources.getColor(R.color.bg2)
                    }
                )
            }))
            add(DisplayLine.DisplayData("Circle", ArrayList<SkDrawable>().apply {
                add(SkCircleDrawable())
                add(SkCircleDrawable().apply {
                    fillColor = resources.getColor(R.color.bg3)
                })
            }))
            add(DisplayLine.DisplayData("Arc", ArrayList<SkDrawable>().apply {
                add(SkArcDrawable().apply {
                    startAngle = 0.0
                    sweepAngle = 180.0
                })
                add(SkArcDrawable().apply {
                    fillColor = resources.getColor(R.color.bg4)
                    startAngle = -45.0
                    sweepAngle = 90.0
                    center = SkPoint(
                        Utils.dp2px(this@ShapeActivity, 20F).toDouble(),
                        Utils.dp2px(this@ShapeActivity, 50F).toDouble()
                    )
                    radius = Utils.dp2px(this@ShapeActivity, 50F).toDouble()
                })
                add(SkArcDrawable().apply {
                    startAngle = -45.0
                    sweepAngle = 270.0
                    fillColor = resources.getColor(R.color.logo1)
                })
            }))
            add(DisplayLine.DisplayData("Image", ArrayList<SkDrawable>().apply {
                add(SkImgDrawable().apply {
                    style = SkImgDrawable.STYLE_CIRCLE
                    img = resources.getDrawable(R.mipmap.cat)
                })
                add(SkImgDrawable().apply {
                    img = resources.getDrawable(R.mipmap.cat)
                })
            }))
        }

    }
}
