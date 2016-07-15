package com.allenliu.badgeview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * Created by Allen Liu on 2016/7/15.
 */
public class BadgeView extends View {
    /**
     * 数字paint
     */
    private Paint numberPaint;
    /**
     * 背景Paint
     */
    private Paint backgroundPaint;
    private int defaultTextColor= Color.WHITE;
    private int defaultTextSize;
    private int defaultBackgroundColor=Color.RED;
    private String showText="0";
    private int badgeGravity=Gravity.RIGHT|Gravity.TOP;
    public BadgeView(Context context) {
        super(context);
        init(context);
    }

    public BadgeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        defaultTextSize=dip2px(context,15);
        numberPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        numberPaint.setColor(defaultTextColor);
        numberPaint.setStyle(Paint.Style.FILL);
        numberPaint.setTextSize(defaultTextSize);
        numberPaint.setTextAlign(Paint.Align.CENTER);
        backgroundPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        backgroundPaint.setColor(defaultBackgroundColor);
        backgroundPaint.setStyle(Paint.Style.FILL);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = badgeGravity;
        setLayoutParams(params);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w=MeasureSpec.getSize(widthMeasureSpec);
        int h=MeasureSpec.getSize(heightMeasureSpec);
        int size=w>h?h:w;
        int measure=MeasureSpec.makeMeasureSpec(size,MeasureSpec.AT_MOST);
        super.onMeasure(measure, measure);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getMeasuredWidth()/2f,getMeasuredHeight()/2f,getMeasuredWidth()/2,backgroundPaint);
        Paint.FontMetrics fontMetrics=numberPaint.getFontMetrics();
        float textH=fontMetrics.descent-fontMetrics.ascent;
        canvas.drawText(showText,getMeasuredWidth()/2f,getMeasuredHeight()/2f+(textH/2f-fontMetrics.descent),numberPaint);
    }

    private int dip2px(Context context, int dip){
       return (int) (dip * getContext().getResources().getDisplayMetrics().density + 0.5f);
   }

    /**
     *
     * @param w  sp
     * @param h  sp
     * @return
     */
    public BadgeView setWidthAndHeight(int w,int h){
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
        params.width=dip2px(getContext(),w);
        params.height=dip2px(getContext(),h);
        setLayoutParams(params);
        return this;
    }

    public BadgeView setWidth(int sp){
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
        params.width=dip2px(getContext(),sp);
        setLayoutParams(params);
        return  this;

    }
    public BadgeView setHeight(int sp){
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
        params.height=dip2px(getContext(),sp);
        setLayoutParams(params);
        return  this;
    }

    public BadgeView setTextSize(int sp){
        defaultTextSize=dip2px(getContext(),sp);
        numberPaint.setTextSize(dip2px(getContext(),sp));
        invalidate();
        return  this;
    }
    public  BadgeView setTextColor(int color){
        defaultTextColor=color;
        numberPaint.setColor(color);
        invalidate();
        return  this;
    }
    public BadgeView setBadgeBackground(int color){
        defaultBackgroundColor=color;
        backgroundPaint.setColor(color);
        invalidate();
        return  this;
    }
    public  BadgeView setBadgeCount(int count){
        showText= String.valueOf(count);
        invalidate();
        return  this;
    }
    public  BadgeView setBadgeCount(String count){
        showText= count;
        invalidate();
        return  this;
    }

    /**
     * set gravity must be before @link bind() method
     * @param gravity
     * @return
     */
    public BadgeView setBadgeGravity(int gravity){
        badgeGravity=gravity;
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
        params.gravity = gravity;
        setLayoutParams(params);
        return  this;
    }
    public BadgeView bind(View view){
        if(getParent()!=null)
            ((ViewGroup) getParent()).removeView(this);
        if(view==null)
            return this;
        if(view.getParent() instanceof FrameLayout){
            ((FrameLayout) view.getParent()).addView(this);
        }else if(view.getParent() instanceof  ViewGroup){
            ViewGroup parentContainer= (ViewGroup) view.getParent();
            int viewIndex=((ViewGroup) view.getParent()).indexOfChild(view);
            ((ViewGroup) view.getParent()).removeView(view);

            FrameLayout container=new FrameLayout(getContext());
            ViewGroup.LayoutParams containerParams=view.getLayoutParams();
            container.setLayoutParams(containerParams);
             container.setId(view.getId());
            
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            container.addView(view);
            container.addView(this);
            parentContainer.addView(container,viewIndex);
        }else if(view.getParent()==null){
           Log.e("badgeview","View must have a parent");
        }
        return  this;
    }
    public String getBadgeCount(){
        return showText;
    }
}
