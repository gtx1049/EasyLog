package com.gtx.easylog.controller;

import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/15.
 */
public class TextPack {
    private TextView tv;
    private ScrollView sv;

    public TextPack(TextView tv, ScrollView sv) {
        this.tv = tv;
        this.sv = sv;
    }

    public TextView getTextView() {
        return tv;
    }

    public ScrollView getScrollView()
    {
        return sv;
    }
}
