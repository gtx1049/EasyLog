package com.gtx.easylog.logtool;

import java.io.BufferedReader;

/**
 * Created by Administrator on 2016/5/15.
 */
public interface LogAdapter {
    public BufferedReader getReader();
    public void startLog();
}
