# RealTime BadgeView
Display a badgeView on any view with RealTime Update.


[![](https://jitpack.io/v/kimoandroid/Smart-BadgeView.svg)](https://jitpack.io/#kimoandroid/Smart-BadgeView)

## Screenshot:
<img src="https://user-images.githubusercontent.com/69405523/183925269-305f8081-b372-40e1-8e7c-7b57d36d0d1f.jpg" width=320/>


## Step.1 Library implementation:

Add This Line To your build.gradle (lastest v1.0.8):
```java
dependencies {
    implementation 'com.enceptcode.badgeview:badge:1.0.8'
}
```


## Step.2 Create Private Variable:
```java
private BadgeView badgeView;
```

<br>

### if you're using ide that didn't support auto import add these lines:
```java
import com.enceptcode.badgeview.BadgeFactory;
import com.enceptcode.badgeview.BadgeView;
```
<br>


## Step.3 Add This Line at `onCreate`:
```java
badgeView = BadgeFactory.createCircle(MainActivity.this);
```
You Can Replace `createCircle()` property with: `createDot()`, `createRectangle()`, `createOval()`, `createSquare()`, `createRoundRect()`

<br>

## Step.4 Add This Void:
```java
private void updateBadge(final String count, final ImageView image) {
    badgeView.setBadgeCount(count).setSpace(5,3).setTextSize(10).bind(image);
}
```
* you can add or change any property to other available methods:

`.setTextColor(Color.White)`

`.setWidthAndHeight(25,25)`

`.setBadgeBackground(Color.Red)`

`.setTextSize(10)`

`.setBadgeGravity(Gravity.Right|Gravity.Top)`

`.setShape(BadgeView.SHAPE_CIRCLE)`

<br>

## Final Step:
finally add this line at `onResume` or `onCreate` to call the void you had created before and display badge.

```java
updateBadge("21", imageview3);
```
void have two parameters first is the badge count, second is the view that badge will display on it.

<br>

## to unbind view just use `unbind` method:
```java
badgeView.unbind();
```

<br>

## License
[Apache License](https://www.apache.org/licenses/LICENSE-2.0)
