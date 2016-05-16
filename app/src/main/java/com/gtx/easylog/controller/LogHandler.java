package com.gtx.easylog.controller;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.gtx.easylog.helper.ColorBuilder;
import com.gtx.easylog.logtool.Constants;

/**
 * Created by Administrator on 2016/5/15.
 */
public class LogHandler extends Handler {

    private TextPack textPack;

    public LogHandler(TextPack textPack)
    {
        this.textPack = textPack;
    }

    @Override
    public void handleMessage(Message msg)
    {
        switch (msg.what)
        {
            case Constants.UPDATE_LOG:
            {

                CharSequence line = ColorBuilder.getInstance().colorLog((String) msg.obj);
                textPack.getTextView().append(line);

                textPack.getScrollView().smoothScrollTo(0, textPack.getTextView().getBottom());
            }
            break;
            default:
                break;
        }
    }
}
