SketchyComponent

看惯了千篇一律的设计风格，何不来换种感觉？   

### 什么是 SketchyComponent
SketchyComponent 是一组手绘风格的 Android 组件库。   
组件库提供了基础的手绘风格图形，以及一些常用的 Icon。  
一些示例如下：    
![demo](./pics/demo.png)   
![demo](./pics/demo1.png)   
![demo](./pics/demo2.png)   
![demo](./pics/demo3.png)   

### 体验一下
download apk

### 快速开始
#### 安装
1. 添加 jcenter 仓库（AS 创建的默认项目已经添加）
```
repositories {
    jcenter()
}
```
2. 添加 sketchy 依赖
```
implementation 'com.zylab:sketchy:0.1.1'
```

#### 基本使用
基本使用很简单，分为三步走：
``` java
// 1. 创建 Sketchy 图形
val skSquareDrawable = SkSquareDrawable().apply {
    // 2. 设置属性
    fillColor = resources.getColor(android.R.color.holo_orange_dark)
}
// 3. 给 View 设置背景
text.background = skSquareDrawable
```

#### 基础 Model
##### SkPoint
表示图形中的一个点
* 属性
x: Double x 坐标   
y: Double y 坐标   

##### SkBezier
表示一条一阶贝塞尔曲线
* 属性
startPoint: SkPoint 起始点
controlPoint: SkPoint 控制点
endPoint: SkPoint 结束点

#### 基础图形
##### SkShape
图形基类，抽象类
* 属性，所有图形均有如下属性
borderColor: Int 线条颜色
fillColor: Int 填充颜色
bgColor: Int 背景颜色

##### SkSquare
绘制一个矩形
* 属性
startPoint: SkPoint 矩形左上角起点
width: Double 矩形宽度
height: Double 矩形长度

* 样式

##### SkLine
绘制一条线
* 属性
startPoint: SkPoint 起点
endPoint: SkPoint 终点

* 样式

##### SkCircle
绘制一个圆
* 属性
center: SkPoint 圆心
radius: Double 半径

* 样式

##### SkArc
绘制扇形
* 属性
center: SkPoint 圆心
radius: Double 半径
startAngle: Double 起始角度
sweepAngle: Double 扇形扫过的角度
linkCenter: Boolean 是否连接圆心

* 样式

##### SkCircleImg
绘制一个圆形图片
* 属性
center: SkPoint 圆心
radius: Double 半径
img: Drawable 图片

* 样式

##### SkSquareImg
绘制一个矩形图片
* 属性
startPoint: SkPoint 矩形左上角起点
width: Double 矩形宽度
height: Double 矩形长度
img: Drawable 图片

* 样式

#### 基础 Drawable
##### SkDrawable
Drawable 基类，其他 Drawable 均继承自此类
* 属性
width: Double 
height: Double
borderColor: Int 线条颜色
fillColor: Int 填充颜色
bgColor: Int 背景颜色

##### SkSquareDrawable
绘制一个矩形
* 属性
startPoint: SkPoint 矩形左上角起点，默认 (0, 0)
squareWidth: Double 矩形宽，默认 Drawable 宽度
squireHeight: Double 矩形高，默认 Drawable 高度

* 样式

##### SkLineDrawable
绘制一个线形
* 属性
startPoint: SkPoint 默认 (0, 0)
endPoint: SkPoint 默认 (0, Drawable width)

* 样式

##### SkCircleDrawable
绘制一个圆形
* 属性
center: SkPoint 默认 (width / 2, height / 2)
radius: Double 默认 min(width / 2, height / 2)

* 样式

##### SkArcDrawable
绘制一个扇形
* 属性
center: SkPoint 圆心
radius: Double 半径
startAngle: Double 起始角度
sweepAngle: Double 扇形扫过的角度
linkCenter: Boolean 是否连接圆心

##### SkImgDrawable
绘制图片
* 属性
img: Drawable 要绘制的图片
style: Int 图片风格 (圆形或矩形)

* 样式

#### 基础 Icon
##### SkTimeIcon
##### SkSearchIcon
##### SkListIcon
##### SkArrowIcon
* 属性
style: Int (STYLE, STYLE1)
direction: Int (UP, DOWN, LEFT, RIGHT)
