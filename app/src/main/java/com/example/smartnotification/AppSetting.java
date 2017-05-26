package com.example.smartnotification;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by daffolap-402 on 25/5/17.
 */

public class AppSetting {

    private static final String UNLOCK_TRACKING = "com.example.smartnotification.UNLOCK_TRACKING";
    private static final String CALL_TRACKING = "com.example.smartnotification.CALL_TRACKING";
    private static final String REGISTERED = "com.example.smartnotification.REGISTERED";

    public static void updateUnlockEventTracking(Context context, boolean enabled) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(UNLOCK_TRACKING, enabled);
        editor.apply();
    }

    public static boolean isUnlockTrackingEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(UNLOCK_TRACKING, false);
    }

    public static void updateCallEventTracking(Context context, boolean enabled) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(CALL_TRACKING, enabled);
        editor.apply();
    }

    public static boolean isCallLoggingEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(CALL_TRACKING, false);
    }

    public static void updateRegistered(Context context, boolean registered) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(REGISTERED, registered);
        editor.apply();
    }

    public static boolean isRegistered(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(REGISTERED, false);
    }
}
