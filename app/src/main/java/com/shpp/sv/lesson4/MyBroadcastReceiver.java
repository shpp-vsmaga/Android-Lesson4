package com.shpp.sv.lesson4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

/**
 * Created by SV on 16.02.2016.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("svcom", "ALARM!!!");
        Log.d("svcom", String.valueOf(new Date(System.currentTimeMillis())));
        Intent stopIntent = new Intent(context, AlarmActivity.class);
        stopIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(stopIntent);
    }
}
