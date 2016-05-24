package com.gtx.easylog.controller;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
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
            return false;
        }
    }
}
