package com.gtx.easylog.controller;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.gtx.easylog.logtool.Constants;

/**
 * Created by Administrator on 2016/5/18.
 */
public class OverLayView extends ViewGroup{

    private OverlayTextView logout;
    private OverlayScrollView scrollView;

    public OverLayView(Context context) {
        super(context);

        scrollView = new OverlayScrollView(context);
        logout = new OverlayTextView(context);

        logout.setVisibility(VISIBLE);

        scrollView.addView(logout);

        scrollView.setVisibility(VISIBLE);

        addView(scrollView);
        setVisibility(VISIBLE);
    }

    public TextView getTextView()
    {
        return logout;
    }

    public ScrollView getScrollView()
    {
        return scrollView;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        // TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int count = this.getChildCount();

        for(int i = 0;i < count;i++){
            View child = this.getChildAt(i);

            child.measure(widthMeasureSpec, heightMeasureSpec);

        }
    }

    @Override
    protected void onLayout(boolean arg0, int l, int t, int r, int b) {

        int count = this.getChildCount();

        for(int i = 0;i < count;i++){
            View child = this.getChildAt(i);
            child.setVisibility(View.VISIBLE);
            //child.measure(r-l, b-t);
            int x = l;
            int y = t;

            child.layout(x,y,x + getWidth(),y + getHeight());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        //System.out.println("OverLayView" + event.toString());
        return false;
    }

    class OverlayTextView extends TextView
    {
        public OverlayTextView(Context context)
        {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event)
        {
            //System.out.println("OverlayTextView");
            return false;
        }
    }

    class OverlayScrollView extends ScrollView
    {
        public OverlayScrollView(Context context)
        {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event)
        {
            //System.out.println("OverlayScrollView");
            return false;
        }
    }
}
