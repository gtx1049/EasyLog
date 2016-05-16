package com.gtx.easylog.logtool;

/**
 * Created by Administrator on 2016/5/15.
 */
public class Constants {
    public final static String LOG_CAT = "logcat";
    public final static String LOG_KERNEL = "kernel";

    public final static String LOG_V_LEVEL = "V/";
    public final static String LOG_D_LEVEL = "D/";
    public final static String LOG_I_LEVEL = "I/";
    public final static String LOG_W_LEVEL = "W/";
    public final static String LOG_E_LEVEL = "E/";
    public final static String LOG_A_LEVEL = "assert";

    public final static String KERN_EMERG = "<0>";
    public final static String KERN_ALERT = "<1>";
    public final static String KERN_CRIT = "<2>";
    public final static String KERN_ERR  = "<3>";
    public final static String KERN_WARNING  = "<4>";
    public final static String KERN_NOTICE  = "<5>";
    public final static String KERN_INFO  = "<6>";
    public final static String KERN_DEBUG  = "<7>";

    public final static int MAX_LINE = 200;

    public final static int UPDATE_LOG = 0x01;
    public final static int SWITCH_SCROOL = 0x02;
}
