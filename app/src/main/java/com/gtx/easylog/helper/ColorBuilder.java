package com.gtx.easylog.helper;

import android.graphics.Color;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.gtx.easylog.logtool.Constants;

/**
 * Created by Administrator on 2016/5/16.
 */
public class ColorBuilder {
    public static ColorBuilder instance = null;

    public static final String BLACK = "#000000";
    public static final String BLUE = "#0000C6";
    public static final String RED = "#FF0000";
    public static final String GREEN = "#02F78E";
    public static final String YELLOW = "#FFDC35";
    public static final String ORANGE = "#FF8000";

    private ColorBuilder()
    {

    }

    public static ColorBuilder getInstance()
    {
        if(instance == null)
            instance = new ColorBuilder();
        return instance;
    }

    public String colorLog(String line)
    {
        StringBuffer span = new StringBuffer(line);

        String[] tmp = line.split(": ");
        String header = tmp[0];

        if(header.contains(Constants.LOG_V_LEVEL))
        {
            addColor(span, BLACK);
        }
        else if(header.contains(Constants.LOG_D_LEVEL))
        {
            addColor(span, BLUE);
        }
        else if(header.contains(Constants.LOG_I_LEVEL))
        {
            addColor(span, GREEN);
        }
        else if(header.contains(Constants.LOG_W_LEVEL))
        {
            addColor(span, ORANGE);
        }
        else if(header.contains(Constants.LOG_E_LEVEL))
        {
            addColor(span, RED);
        }

        span.append("<br>");
        return span.toString();
    }

    private void addColor(StringBuffer sb, String color)
    {
        String token = "<font color=\"#######\">";
        String tokenend = "</font>";
        token = token.replace("#######", color);
        sb.insert(0, token);
        sb.append(tokenend);
    }
}
