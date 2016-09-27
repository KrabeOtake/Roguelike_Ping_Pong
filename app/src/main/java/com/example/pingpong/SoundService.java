package com.example.pingpong;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;

/**
 * Created by Сергей Пинкевич on 27.07.2016.
 */
public class SoundService extends IntentService {

    // Creates an IntentService. Invoked by your subclass's constructor.
    public SoundService() {
        super("SoundService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        MediaPlayer player = MediaPlayer.create(getApplicationContext(), R.raw.hit);
        player.start();
    }
}
