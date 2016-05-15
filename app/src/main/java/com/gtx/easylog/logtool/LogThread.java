package com.gtx.easylog.logtool;

import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Administrator on 2016/5/15.
 */
public class LogThread extends Thread {

    private Handler uihandler;
    private LogAdapter la = null;

    public LogThread(Handler uihandler, String cmd) {
        this.uihandler = uihandler;
        la = LogFactory.getIntance().getLogadapter(cmd);
    }

    public void run()
    {
        la.startLog();
        BufferedReader br = la.getReader();

        String line;
        try {
            while((line = br.readLine()) != null)
            {
                Message msg = uihandler.obtainMessage(Constants.UPDATE_LOG, line);
                uihandler.sendMessage(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
