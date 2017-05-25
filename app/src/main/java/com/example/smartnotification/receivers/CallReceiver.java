package com.example.smartnotification.receivers;

import android.content.Context;

import com.example.smartnotification.R;
import com.example.smartnotification.util.DateUtils;
import com.example.smartnotification.util.LogHelper;
import com.example.smartnotification.util.NotificationHelper;

import java.util.Date;

public class CallReceiver extends PhoneCallReceiver {

    @Override
    protected void onIncomingCallStarted(Context ctx, String number, Date start) {

    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {

    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {
        NotificationHelper notificationHelper = new NotificationHelper(ctx);
        notificationHelper.generateCallNotification(ctx, false, number);
        LogHelper.writeFile(ctx.getString(R.string.incoming_call_log_template, number,
                DateUtils.formatDate(end)), ctx);
    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {
        NotificationHelper notificationHelper = new NotificationHelper(ctx);
        notificationHelper.generateCallNotification(ctx, true, number);
        LogHelper.writeFile(ctx.getString(R.string.outgoing_call_log_template, number,
                DateUtils.formatDate(end)), ctx);
    }
}
