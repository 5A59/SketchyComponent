## SketchyComponent
Languate: [中文](./README-CN.md) | [English](./README.md)   

![logo](./pics/SketchyComponent.png)

### What is SketchyComponent
SketchyComponent is a set of *sketchy style* components.

We provide basic sketchy shapes and some icons.   
Here are some examples：    
![demo](./pics/demo.png)   ![demo](./pics/demo1.png)   ![demo](./pics/demo2.png)   ![demo](./pics/demo3.png)   

### Try
[Download Demo APK](./apk/SketchyComponent.apk)

### Quick Start
#### Install
1. add `jcenter` to repositories
```
repositories {
    jcenter()
}
```
2. add `sketchy` to dependencies
```
implementation 'com.zylab:sketchy:0.1.1'
```

#### How to use
``` java
// 1. new SkDrawable
val skSquareDrawable = SkSquareDrawable().apply {
    // 2. set props
    fillColor = resources.getColor(android.R.color.holo_orange_dark)
}
// 3. set the background of View 
text.background = skSquareDrawable
```

### Update
#### Latest version
0.1.1

#### 0.1.1 
Complete basic functions.

### Introduce
#### Basic Model
##### SkPoint
Represents a point in the drawing.   
* Props   
x: Double    
y: Double   

##### SkBezier
Represents a first order Bezier curve.
* Props   
startPoint: SkPoint    
controlPoint: SkPoint    
endPoint: SkPoint    

#### Basic Drawable
##### SkDrawable
The base class of other SkDrawables.    
* Props      
width: Double    
height: Double   
borderColor: Int    
fillColor: Int    
bgColor: Int    

##### SkSquareDrawable
A drawable of square.   
![pic](./pics/square.png)   

* props     
startPoint: SkPoint (The default value is (0, 0))   
squareWidth: Double (The default value is the width of drawable)    
squireHeight: Double (The default value is the height of drawable)   

##### SkLineDrawable
A drawable of line.   
![pic](./pics/line.png)   

* Props     
startPoint: SkPoint (The default value is (0, 0))  
endPoint: SkPoint (The default value is (0, Drawable width))  

##### SkCircleDrawable
A drawable of circle.   
![pic](./pics/circle.png)   

* Props  
center: SkPoint (The default value is (width of drawable / 2, height of drawable / 2))  
radius: Double (The default value is min(width of drawable / 2, height of drawable / 2))  

##### SkArcDrawable
A drawable of arc.    
![pic](./pics/arc.png)   

* Props   
center: SkPoint   
radius: Double   
startAngle: Double    
sweepAngle: Double    
linkCenter: Boolean (Whether if line to center)   

##### SkImgDrawable
A drawable of images.   
![pic](./pics/drawable.png)   

* 属性  
img: Drawable    
style: Int (STYLE_CIRCLE and STYLE_SQUARE)  

#### Basic Icon
##### SkTimeIcon
![pic](./pics/time.png)   

##### SkSearchIcon
![pic](./pics/search.png)   

##### SkListIcon
![pic](./pics/list.png)   

##### SkArrowIcon
![pic](./pics/arrow-left.png) ![pic](./pics/arrow-right.png) ![pic](./pics/arrow-up.png)   ![pic](./pics/arrow-down.png) ![pic](./pics/arrow-left-1.png) ![pic](./pics/arrow-right-1.png) 

* Props  
style: Int (STYLE, STYLE1)  
direction: Int (UP, DOWN, LEFT, RIGHT)  

![pic](./pics/arrow-up-1.png) ![pic](./pics/arrow-down-1.png)   

#### Basic Shape
We also provide custom capabilities by some basic shapes. So You can draw something you want using these shapes.      
Here are some examples.   

![pic](./pics/linechart.png) ![pic](./pics/piechart.png) ![pic](./pics/barchart.png)   

##### How to use
All basic shapes inherit from `SkShape`. There are two important functions -- `SkShape#parse()` and `SkShape#draw(canvas: Canvas)`.    
`SkShape#parse` used to generate paths of graphics.   
`SkShape#draw` used to draw paths to canvas. It will call `parse` if paths are not generated.  
Take SkLine as an example：
```
// 1. new SkLine 
val line = SkLine()
// 2. set props
line.startPoint = SkPoint(0.0, 0.0)
line.endPoint = SkPoint(100.0, 100.0)
// 3. draw to canvas
line.draw(canvas)
```

##### SkShape
The base class of shapes.   
* Props    
borderColor: Int   
fillColor: Int    
bgColor: Int    

##### SkSquare
A shape of square.   
![pic](./pics/square.png)

* Props   
startPoint: SkPoint    
width: Double   
height: Double   


##### SkLine   
A shape of line.   
![pic](./pics/line.png)

* Props     
startPoint: SkPoint   
endPoint: SkPoint    


##### SkCircle 
A shape of circle.   
![pic](./pics/circle.png)

* Props   
center: SkPoint    
radius: Double    

##### SkArc
A shape of arc.   
![pic](./pics/arc.png)

* Props    
center: SkPoint   
radius: Double    
startAngle: Double    
sweepAngle: Double    
linkCenter: Boolean    

##### SkCircleImg
A shape of circle images.   
![pic](./pics/drawable-circle.png)   

* Props     
center: SkPoint    
radius: Double    
img: Drawable   

##### SkSquareImg
A shape of square images.   
![pic](./pics/drawable-square.png)   

* Props     
startPoint: SkPoint   
width: Double   
height: Double    
img: Drawable    

### About
Any questions or suggestions, welcome to feedback:    
Email：zy5a59@outlook.com    
Wechat：zy_lab   