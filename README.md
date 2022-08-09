# BadgeView
a BadeView  base on android

<img src="https://github.com/AlexLiuSheng/BadgeView/blob/master/library/version1.0.5.png" width=320/>

## include:

      `implementation 'com.allenliu.badgeview:library:1.1.1'`

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

## history version
  - v1.0.6  
  add `setMargin`method,using this method you can change the position of badgeview,but the width of bindview or the height of bindview will be changed.see image effect.
  
  - v1.1.1
  add `setSpace`method,it replace origin method `setMargin`.now `setMargin` is a Deprecated method.Use `setSpace` method to set space  between view and badgeview instead.

## License
        
        Copyright 2016 AllenLiu.

        Licensed to the Apache Software Foundation (ASF) under one or more contributor
        license agreements. See the NOTICE file distributed with this work for
        additional information regarding copyright ownership. The ASF licenses this
        file to you under the Apache License, Version 2.0 (the "License"); you may not
        use this file except in compliance with the License. You may obtain a copy of
        the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
        WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
        License for the specific language governing permissions and limitations under
        the License.
welecome to star,thank you.
