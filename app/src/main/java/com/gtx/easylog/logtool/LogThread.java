package com.gtx.easylog.logtool;

import android.os.Handler;

/**
 * Created by Administrator on 2016/5/15.
 */
public class LogThread extends Thread {

    private Handler uihandler;

    public LogThread(Handler uihandler) {
        this.uihandler = uihandler;
    }

    public void run()
    {

    }

}
