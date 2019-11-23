package com.zylab.sketchycomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zylab.sketchycomponent.view.SkSquareDrawable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawable = SkSquareDrawable()
        drawable.backgroundColor = resources.getColor(android.R.color.holo_green_dark)
        text.background = drawable
    }
}
