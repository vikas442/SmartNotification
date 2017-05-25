package com.example.smartnotification.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by daffolap-402 on 25/5/17.
 */

public class DateUtils {
    private static SimpleDateFormat sSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM, hh:mm", Locale.ENGLISH);

    public static String formatDate(Date date){
        return sSimpleDateFormat.format(date);
    }
}
