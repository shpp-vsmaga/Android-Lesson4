package com.shpp.sv.lesson4;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class AlarmActivity extends Activity {

    MediaPlayer mediaPlayer;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_activity);
        context = getApplicationContext();
        vibrate();
        playSound();

    }

    private void playSound() {
        mediaPlayer = MediaPlayer.create(context, R.raw.alaram_sound);
        mediaPlayer.setVolume(1, 1);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1000);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    }

    public void onClickStopAlarm(View view) {
        moveTaskToBack(true);
        System.exit(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}
