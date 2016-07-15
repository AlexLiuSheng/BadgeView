package com.allenliu.badgeview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

public class BadgeDemoActivity extends AppCompatActivity {
private TextView tv;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge_demo);
        tv= (TextView) findViewById(R.id.tv);
        iv= (ImageView) findViewById(R.id.iv);
       BadgeFactory.create(this).bind(tv).setBadgeCount(1).setWidthAndHeight(15,15);
        BadgeFactory.create(this).setBadgeCount(1).setWidth(15).setHeight(15).setBadgeGravity(Gravity.LEFT|Gravity.TOP).bind(iv).setBadgeCount(1);
    }

}
