package com.demo.tomcat.wakeservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AlarmService extends Service {
    private static final String TAG = AlarmService.class.getSimpleName();


    public AlarmService()
    {
        Log.w(TAG, "onCreate(), ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
