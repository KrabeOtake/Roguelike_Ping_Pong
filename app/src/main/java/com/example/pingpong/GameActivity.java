package com.example.pingpong;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private static final String DIFFICULTY = "difficulty";
    private static int gameDifficulty;
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
