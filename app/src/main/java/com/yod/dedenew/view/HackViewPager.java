package com.yod.dedenew.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by twq on 2015/12/8.
 * 设置滑动动画、是否可以滑动
 */
public class HackViewPager extends ViewPager {

    private boolean isPagingEnabled = false;
    private boolean animateSwitch = true;

    public HackViewPager(Context context) {
        super(context);
    }

    public HackViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.isPagingEnabled) {
            try {
                return super.onTouchEvent(ev);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.isPagingEnabled) {
            try {
                return super.onInterceptTouchEvent(ev);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public void setIsPagingEnabled(boolean isPagingEnabled) {
        this.isPagingEnabled = isPagingEnabled;
    }

    public void setAnimateSwitch(boolean animateSwitch) {
        this.animateSwitch = animateSwitch;
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, animateSwitch);
    }


}
