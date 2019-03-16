package com.example.lenovo.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    String TAG;
    public MyService() {
    }

    @Override
    public void onCreate()  {
        super.onCreate();
        Log.d(TAG,"on create");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "OnStart Command");

        for (int i = 0; i < 10000000; i++) {

            if (i > 1000){
                stopSelf();
            }
            try {
                Thread.sleep(10);
                Log.d(TAG, "Number" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }




}
