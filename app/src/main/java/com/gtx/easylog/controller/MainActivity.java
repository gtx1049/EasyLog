package com.gtx.easylog.controller;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;

import com.gtx.easylog.R;
import com.gtx.easylog.logtool.Constants;
import com.gtx.easylog.logtool.LogThread;

public class MainActivity extends AppCompatActivity {

    private LogThread lg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //logout = (TextView)findViewById(R.id.logdata);
        //scrollView = (ScrollView)findViewById(R.id.scroller);

        //textPack = new TextPack(logout, scrollView);

        //myhandler = new LogHandler(textPack);
        //lg = new LogThread(myhandler, Constants.LOG_KERNEL);
        //lg.start();

        Intent floatservice = new Intent(MainActivity.this, LogService.class);
        startService(floatservice);

    }

    @Override
    protected  void onDestroy()
    {
        super.onDestroy();
        if(lg != null) {
            lg.stopThread();
        }
    }
}
