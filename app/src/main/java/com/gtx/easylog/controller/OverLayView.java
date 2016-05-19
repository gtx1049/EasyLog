package com.gtx.easylog.controller;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/5/18.
 */
public class OverLayView extends View{
    public OverLayView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return false;
    }
}
