package com.shpp.sv.lesson4;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    PendingIntent pendingIntent;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

    }


    public void onClickSetAlarmBtn(View view) {
        Calendar calendar = getCalendarFromPicker();

        Intent intent = new Intent(MainActivity.this, MyBroadcastReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        Toast.makeText(this, "Alarm is set to " + calendar.get(Calendar.HOUR_OF_DAY) + ":" +
                calendar.get(Calendar.MINUTE), Toast.LENGTH_LONG).show();



    }

    public Calendar getCalendarFromPicker() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
        calendar.set(Calendar.SECOND, 0);
        return calendar;
    }
}
