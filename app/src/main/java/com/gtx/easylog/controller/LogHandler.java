package com.gtx.easylog.controller;

import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.widget.TextView;

import com.gtx.easylog.helper.ColorBuilder;
import com.gtx.easylog.logtool.Constants;

/**
 * Created by Administrator on 2016/5/15.
 */
public class LogHandler extends Handler {

    private TextPack textPack;
    private boolean isscroll;

    public LogHandler(TextPack textPack)
    {
        this.textPack = textPack;
        isscroll = true;
    }

    private static StringBuffer text = new StringBuffer();

    private static int linecount = 0;

    @Override
    public void handleMessage(Message msg)
    {
        switch (msg.what)
        {
            case Constants.UPDATE_LOG:
            {
                linecount++;

                if(linecount == Constants.MAX_LINE)
                {
                    text = new StringBuffer(text.substring(text.length() / 2));
                    linecount = 0;
                }

                CharSequence line = ColorBuilder.getInstance().colorLog((String) msg.obj);
                text.append(line);
                textPack.getTextView().setText(Html.fromHtml(text.toString()));

                if(isscroll)
                    textPack.getScrollView().smoothScrollTo(0, textPack.getTextView().getBottom());
            }
            break;
            default:
                break;
        }
    }
}
