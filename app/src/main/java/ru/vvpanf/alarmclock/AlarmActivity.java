package ru.vvpanf.alarmclock;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AlarmActivity extends AppCompatActivity {
    private Ringtone ringtone;
    private Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        Uri notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtone = RingtoneManager.getRingtone(this, notificationUri);
        if (ringtone == null) {
            notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            ringtone = RingtoneManager.getRingtone(this, notificationUri);
        }
        if (ringtone != null) {
            ringtone.play();
        }
        stopButton = findViewById(R.id.stop_button);
        stopButton.setOnClickListener(v -> {
            stopRingtone();
        });
    }

    @Override
    protected void onDestroy() {
        stopRingtone();
        super.onDestroy();
    }

    private void stopRingtone() {
        if (ringtone != null && ringtone.isPlaying()) {
            ringtone.stop();
        }
    }
}