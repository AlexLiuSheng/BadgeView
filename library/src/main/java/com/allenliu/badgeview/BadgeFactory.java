package com.allenliu.badgeview;

import android.content.Context;

/**
 * Created by Allen Liu on 2016/7/15.
 */
public class BadgeFactory {
    public static BadgeView create(Context context){
        return  new BadgeView(context);
    }
}
