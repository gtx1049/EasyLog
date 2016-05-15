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

    public LogAdapter getLogadapter(String cmd)
    {
        if(cmd.equals(Constants.LOG_CAT))
            return getCatlog();
        else if(cmd.equals(Constants.LOG_KERNEL))
            return getKernellog();

        return null;
    }

    private LogAdapter getCatlog()
    {
        return new CatLog();
    }

    private LogAdapter getKernellog()
    {
        return new KernelLog();
    }
}
