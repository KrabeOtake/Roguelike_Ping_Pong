package com.example.pingpong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GameActivity extends Activity {

    public static final String DIFFICULTY = "difficulty";
    public static int gameDifficulty = 2;
    // 1 - easy
    // 2 - medium
    // 3 - hard
    // Value, which was sent by default = 2, medium

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        gameDifficulty = intent.getIntExtra(DIFFICULTY, 2); // 2 is value by default (medium level)
    }
}
