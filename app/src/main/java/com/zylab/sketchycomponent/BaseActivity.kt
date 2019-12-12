package com.zylab.sketchycomponent

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by zhangyi on 19-11-30
 */

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
    }
}
