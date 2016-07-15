# BadgeView
a BadeView  base on android

include:

      compile 'com.allenliu.badgeview:library:1.0.2'
use like this:

    BadgeFactory.create(this)
    .setTextColor(Color.White)
    .setWidthAndHeight(25,25)
    .setBadgeBackground(Color.Red)
    .setTextSize(10)
    .setBadgeGravity(Gravity.Right|Gravity.Top)
    .setBadgeCount(20)
    .bind(view);
