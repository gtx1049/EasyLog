package com.gtx.easylog.logtool;

/**
 * Created by Administrator on 2016/5/15.
 */
public class LogFactory {
    private static LogFactory instance = null;

    private LogFactory()
    {
    }

    public static LogFactory getIntance()
    {
        if(instance == null)
        {
            instance = new LogFactory();
        }
        return instance;
    }
}
