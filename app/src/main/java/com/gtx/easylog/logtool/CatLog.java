package com.gtx.easylog.logtool;

import com.gtx.easylog.helper.ColorBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2016/5/15.
 */
public class CatLog implements LogAdapter {

    private String cmd;
    private BufferedReader br = null;
    private Process logprocess = null;

    public CatLog()
    {
        cmd = "su -c logcat -v time";
    }

    @Override
    public BufferedReader getReader() {
        if(logprocess != null)
        {
            br = new BufferedReader(new InputStreamReader(logprocess.getInputStream()), 8192);
            return br;
        }
        return null;
    }

    @Override
    public void startLog() {
        try {
            logprocess = Runtime.getRuntime().exec(cmd);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void kill() {
        logprocess.destroy();
    }

    @Override
    public String colorLine(String line) {
        return ColorBuilder.getInstance().colorLog(line);
    }
}
