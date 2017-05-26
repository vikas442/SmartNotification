package com.example.smartnotification;

import android.app.Application;
import android.content.Intent;

import com.example.smartnotification.services.UnlockObserverService;

/**
 * Created by daffolap-402 on 26/5/17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(getApplicationContext(), UnlockObserverService.class));
    }
}
