package com.example.smartnotification.services;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.example.smartnotification.receivers.PhoneUnlockReceiver;

public class UnlockObserverService extends Service {
    private PhoneUnlockReceiver mPhoneUnlockReceiver = new PhoneUnlockReceiver();

    public UnlockObserverService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerReceiver();
    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_USER_PRESENT);
        registerReceiver(mPhoneUnlockReceiver, filter);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        unregisterReceiver(mPhoneUnlockReceiver);
        registerReceiver();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(mPhoneUnlockReceiver);
        super.onDestroy();
    }
}
