package com.example.smartnotification.util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;

import com.example.smartnotification.MainActivity;
import com.example.smartnotification.R;
import com.example.smartnotification.RegisterActivity;

/**
 * Created by daffolap-402 on 25/5/17.
 */

public class NotificationHelper {
    private static NotificationManager notificationManager;
    private static int BIG_TEXT_NOTIFICATION_KEY = 1;
    private static int REGISTER_NOTIFICATION_KEY = 2;
    private static int CALL_NOTIFICATION_KEY = 3;
    private static int MISSED_NOTIFICATION_KEY = 4;

    public NotificationHelper(Context context) {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void generateUnlockNotification(Context context) {
        notificationManager.cancel(BIG_TEXT_NOTIFICATION_KEY);
        PendingIntent pIntent = PendingIntent.getActivity(context,
                (int) System.currentTimeMillis(),
                new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentText("Smart notification.")
                .setContentTitle("Phone unlocked")
                .setAutoCancel(true)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.mipmap.ic_launcher))
                .setSmallIcon(R.drawable.ic_status_notify)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Your phone is being unlocked.")
                        .setBigContentTitle("Phone unlocked")
                        .setSummaryText("Smart notification"))
                .setContentIntent(pIntent);

        notificationManager.notify(BIG_TEXT_NOTIFICATION_KEY, builder.build());
    }

    public void generateMissedCallNotification(Context context, String number) {
        notificationManager.cancel(MISSED_NOTIFICATION_KEY);
        PendingIntent pIntent = PendingIntent.getActivity(context,
                (int) System.currentTimeMillis(),
                new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentText("Smart notification.")
                .setContentTitle("Call Log")
                .setAutoCancel(true)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.mipmap.ic_launcher))
                .setSmallIcon(R.drawable.ic_status_notify)
//                .setColor(Color.RED)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(context.getString(R.string.missed_call_template, number))
                        .setBigContentTitle("Call Log")
                        .setSummaryText("Smart notification"))
                .setContentIntent(pIntent);

        notificationManager.notify(MISSED_NOTIFICATION_KEY, builder.build());
    }

    public void generateCallNotification(Context context, boolean isOutgoing, String number) {
        notificationManager.cancel(CALL_NOTIFICATION_KEY);
        PendingIntent pIntent = PendingIntent.getActivity(context,
                (int) System.currentTimeMillis(),
                new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentText("Smart notification.")
                .setContentTitle("Call Log")
                .setAutoCancel(true)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.mipmap.ic_launcher))
                .setSmallIcon(R.drawable.ic_status_notify)
//                .setColor(Color.RED)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(isOutgoing ? context.getString(R.string.outgoing_call_template, number) :
                                context.getString(R.string.incoming_call_template, number))
                        .setBigContentTitle("Call Log")
                        .setSummaryText("Smart notification"))
                .setContentIntent(pIntent);

        notificationManager.notify(CALL_NOTIFICATION_KEY, builder.build());
    }

    public void generateRegisterNotification(Context context) {
        notificationManager.cancel(REGISTER_NOTIFICATION_KEY);
        PendingIntent pIntent = PendingIntent.getActivity(context,
                (int) System.currentTimeMillis(),
                new Intent(context, RegisterActivity.class), 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentText("Registration")
                .setContentTitle("Register fast")
                .setAutoCancel(true)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.mipmap.ic_launcher))
                .setSmallIcon(R.drawable.ic_status_notify)
                .setColor(Color.GREEN)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Complete your registration to get delighting deals.")
                        .setBigContentTitle("Complete registration")
                        .setSummaryText("Smart notification"))
                .setContentIntent(pIntent);

        notificationManager.notify(REGISTER_NOTIFICATION_KEY, builder.build());
    }
}
