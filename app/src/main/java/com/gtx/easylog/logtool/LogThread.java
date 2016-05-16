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

    private boolean isruning;
    private boolean ispause;
    private Object lock;

    public LogThread(Handler uihandler, String cmd) {
        this.uihandler = uihandler;
        la = LogFactory.getIntance().getLogadapter(cmd);

        isruning = true;
        lock = new Object();
    }

    public void run()
    {
        la.startLog();
        BufferedReader br = la.getReader();

        String line;
        try {
            while(isruning && (line = br.readLine()) != null)
            {
                Message msg = uihandler.obtainMessage(Constants.UPDATE_LOG, line);
                uihandler.sendMessage(msg);
                Thread.sleep(100);
                if(ispause)
                {
                    synchronized (lock)
                    {
                        lock.wait();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        la.kill();
    }

    public void pauseThread()
    {
        ispause = true;
    }

    public void resumeThread()
    {
        ispause = false;
        synchronized (lock)
        {
            lock.notifyAll();
        }
    }

    public void stopThread()
    {
        setRuning(false);
    }

    private void setRuning(boolean is)
    {
        this.isruning = is;
    }
}
