package com.example.pingpong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameOverActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
