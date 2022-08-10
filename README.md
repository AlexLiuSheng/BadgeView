# Smart BadgeView


[![](https://jitpack.io/v/kimoandroid/Smart-BadgeView.svg)](https://jitpack.io/#kimoandroid/Smart-BadgeView)

# Screenshot >>
<img src="https://user-images.githubusercontent.com/69405523/183925269-305f8081-b372-40e1-8e7c-7b57d36d0d1f.jpg" width=320/>


## Library implementation:

Add This Line To your build.gradle:

```java
dependencies {
    implementation 'com.enceptcode.badgeview:badge:1.0.7'
}
```

## bind like this:

     BadgeFactory.create(this)
    .setTextColor(Color.White)
    .setWidthAndHeight(25,25)
    .setBadgeBackground(Color.Red)
    .setTextSize(10)
    .setBadgeGravity(Gravity.Right|Gravity.Top)
    .setBadgeCount(20)
    .setShape(BadgeView.SHAPE_CIRCLE)
    .setSpace(10,10)
    .bind(view);
     
     
if u want to set space dont use ~~setMargin()~~,use `setSpace` instead.
## There are some other constructer methods and you can be easy to create your own shape :

    BadgeFactory.createDot(this).setBadgeCount(20).bind(imageView);
    BadgeFactory.createCircle(this).setBadgeCount(20).bind(imageView);
    BadgeFactory.createRectangle(this).setBadgeCount(20).bind(imageView);
    BadgeFactory.createOval(this).setBadgeCount(20).bind(imageView);
    BadgeFactory.createSquare(this).setBadgeCount(20).bind(imageView);
    BadgeFactory.createRoundRect(this).setBadgeCount(20).bind(imageView);
    
    
## unbind view just use `unbind` method.
   
     badgeView.unbind();


## License
[Apache License](https://www.apache.org/licenses/LICENSE-2.0)
