package com.example.pingpong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 111 on 14.07.2016.
 */

public class DifficultyActivity extends Activity {

    private Intent intent;
    private static final String DIFFICULTY = "difficulty";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        intent = new Intent(this, MazeActivity.class);
    }

    public void onEasy(View v) {
        intent.putExtra(DIFFICULTY, 1);
        startActivity(intent);
    }

    public void onMedium(View v) {
        intent.putExtra(DIFFICULTY, 2);
        startActivity(intent);
    }

    public void onHard(View v) {
        intent.putExtra(DIFFICULTY, 3);
        startActivity(intent);
    }
}
