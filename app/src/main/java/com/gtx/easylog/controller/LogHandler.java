package com.gtx.easylog.controller;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.gtx.easylog.logtool.Constants;

/**
 * Created by Administrator on 2016/5/15.
 */
public class LogHandler extends Handler {

    private TextView tw;

    public LogHandler(TextView tw)
    {
        this.tw = tw;
    }

    @Override
    public void handleMessage(Message msg)
    {
        switch (msg.what)
        {
            case Constants.UPDATE_LOG:
            {
                tw.append((String)msg.obj);
            }
            break;
            default:
                break;
        }
    }
}
