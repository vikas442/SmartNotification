package com.example.smartnotification.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.smartnotification.AppSetting;
import com.example.smartnotification.util.NotificationHelper;

public class PhoneUnlockReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
            NotificationHelper notificationHelper = new NotificationHelper(context);
            if (AppSetting.isUnlockTrackingEnabled(context)) {
                notificationHelper.generateUnlockNotification(context);
            }
            if (!AppSetting.isRegistered(context)) {
                notificationHelper.generateRegisterNotification(context);
            }
        }
    }
}
