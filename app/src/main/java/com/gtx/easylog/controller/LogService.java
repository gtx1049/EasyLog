package com.gtx.easylog.controller;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.gtx.easylog.R;
import com.gtx.easylog.logtool.Constants;
import com.gtx.easylog.logtool.LogThread;

public class LogService extends Service {

    //LinearLayout mLayout;
    LayoutParams wmParams;
    WindowManager mWindowManager;

    //private TextView logout;
    //private ScrollView scrollView;

    OverLayView olView = null;

    private TextPack textPack;

    private Handler myhandler;
    private LogThread lg = null;


    public LogService() {

    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        createFloatWindow();
    }

    private void createFloatWindow()
    {
        wmParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);

        mWindowManager = (WindowManager)getApplication().getSystemService(getApplication().WINDOW_SERVICE);

        //wmParams.type = LayoutParams.TYPE_PHONE;
        wmParams.format = PixelFormat.RGBA_8888;

        wmParams.gravity = Gravity.LEFT | Gravity.TOP;



        wmParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        wmParams.height = WindowManager.LayoutParams.MATCH_PARENT;


        olView = new OverLayView(this);

        mWindowManager.addView(olView, wmParams);

        olView.measure(View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
                .makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

        textPack = new TextPack(olView.getTextView(), olView.getScrollView());

        myhandler = new LogHandler(textPack);
        lg = new LogThread(myhandler, Constants.LOG_CAT);
        lg.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if(olView != null)
        {
            mWindowManager.removeView(olView);
            if(lg != null) {
                lg.stopThread();
            }
        }
    }
}
