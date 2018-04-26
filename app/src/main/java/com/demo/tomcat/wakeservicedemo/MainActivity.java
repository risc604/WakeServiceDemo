package com.demo.tomcat.wakeservicedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.IOException;

// https://www.itstrike.cn/Question/dceae027-c3dd-4726-a6e1-ef84afc023f9.html


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    AlarmReceiver alarmReceiver;
    class AlarmReceiver extends WakefulBroadcastReceiver
    {
        public AlarmReceiver() {
            super();
        }

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w(TAG, "onCreate(), ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logSFileCreated();
    }



    //-------------------------- user function --------------------------//
    //private final static String mPID = String.valueOf(android.os.Process.myPid());
    final static String mPIDs = String.valueOf(android.os.Process.myPid());
    //final static String cmds01 = "logcat *:v *:w *:e *:d *:i | grep \"(" + mPID + ")\" -f ";
    final static String cmds011 = "logcat *:v | grep \"(" + mPIDs + ")\" -f ";

    public void logSFileCreated()
    {
        Log.w(TAG, "l ogSFileCreated(), ");
        try
        {
            //final String logFilePath = "/storage/emulated/0/Download/"+"Log_mt24.txt";
            final String logFilePath =  Environment.getExternalStorageDirectory().getAbsolutePath() +
                    "/Download/scheduler1s.txt";
            //final String cmds01 = "logcat *:v | grep \"(" + mPID + ")\" -f ";

            File f = new File(logFilePath);
            if (f.exists() && !f.isDirectory()) {
                if (!f.delete()) {
                    Log.w(TAG, "FAIL !! file delete NOT ok.");
                }
            }

            java.lang.Process process = Runtime.getRuntime().exec(cmds011 + logFilePath);
            Log.w(TAG, "logFileCreated(), process: " + process.toString() +
                    ", path: " + logFilePath + ", f.exists: " + f.exists());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}

