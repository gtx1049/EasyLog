package com.gtx.easylog.controller;

import android.app.Service;
import android.content.Intent;
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

    LinearLayout mLayout;
    LayoutParams wmParams;
    WindowManager mWindowManager;

    private TextView logout;
    private ScrollView scrollView;

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
        wmParams = new WindowManager.LayoutParams();
        mWindowManager = (WindowManager)getApplication().getSystemService(getApplication().WINDOW_SERVICE);
        wmParams.type = LayoutParams.TYPE_PHONE;
        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.flags = LayoutParams.FLAG_NOT_FOCUSABLE;
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        wmParams.x = 0;
        wmParams.y = 0;

        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        LayoutInflater inflater = LayoutInflater.from(getApplication());
        mLayout = (LinearLayout) inflater.inflate(R.layout.float_layout, null);

        mWindowManager.addView(mLayout, wmParams);

        mLayout.measure(View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
                .makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

        logout = (TextView)mLayout.findViewById(R.id.logdata);
        scrollView = (ScrollView)mLayout.findViewById(R.id.scroller);

        textPack = new TextPack(logout, scrollView);

        myhandler = new LogHandler(textPack);
        lg = new LogThread(myhandler, Constants.LOG_KERNEL);
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
        if(mLayout != null)
        {
            mWindowManager.removeView(mLayout);
            if(lg != null) {
                lg.stopThread();
            }
        }
    }
}
