package com.example.commonlibrary.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.commonlibrary.utils.CommonLogger;

import androidx.viewpager.widget.ViewPager;

/**
 * 项目名称:    NewFastFrame
 * 创建人:        陈锦军
 * 创建时间:    2017/9/26      16:49
 * QQ:             1981367757
 */

public class WrappedViewPager extends ViewPager {
    public WrappedViewPager(Context context) {
        super(context);
    }

    public WrappedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            return needScroll && super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    private boolean needScroll=true;


    public void setNeedScroll(boolean needScroll) {
        this.needScroll = needScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            if (ev.getAction() == MotionEvent.ACTION_MOVE) {
                CommonLogger.e("move");
            }
            return needScroll && super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
