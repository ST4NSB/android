package com.example.l03_2;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class ToastService extends Service {
    private Handler mHandler;

    @Override
    public void onCreate() {
        mHandler = new Handler();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
       // ToastService("onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class ToastRunnable implements Runnable {
        String mText;

        public ToastRunnable(String text) {
            mText = text;
        }

        @Override
        public void run(){
            Toast.makeText(getApplicationContext(), mText, Toast.LENGTH_SHORT).show();
        }
    }

    private void ToastService() {
        mHandler.post(new ToastRunnable("onStart"));
    }
}
