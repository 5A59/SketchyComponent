package com.zylab.sketchycomponent.model

/**
 * Created by zhangyi on 19-11-19
 */

data class SkBezier(var startPoint: SkPoint, var controlPoint: SkPoint, var endPoint: SkPoint)

data class SkPoint(var x: Double, var y: Double)

val DEFAULT_POINT = SkPoint(Double.MAX_VALUE, Double.MAX_VALUE)

