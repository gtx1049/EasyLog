package com.gtx.easylog.controller;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gtx.easylog.R;
import com.gtx.easylog.logtool.LogThread;

public class MainActivity extends AppCompatActivity {

    private TextView logout;
    private Handler myhandler;
    private LogThread lg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = (TextView)findViewById(R.id.logdata);

        myhandler = new LogHandler(logout);
        lg = new LogThread(myhandler, "logcat");
        lg.start();
    }
}
