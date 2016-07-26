package com.example.pingpong;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class GameOverActivity extends Activity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_game_over);
    }

    public void onAgain(View view) {
        intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void onBackToMenu(View view) {
        intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
