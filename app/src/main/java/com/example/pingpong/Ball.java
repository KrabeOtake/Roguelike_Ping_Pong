package com.example.pingpong;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;

import java.util.ArrayList;

/**
 * Created by Сергей Пинкевич on 18.07.2016.
 */

public class Ball {
    private int x;
    private int y;
    private int radius;
    private final int INIT_RADIUS = 10;
    private final int BALL_SPEED = 8;
    private int dx;
    private int dy;
    private GameActivity activity;

    private MediaPlayer player;

    public Ball(int x, int y, GameActivity activity) {
        dx = -BALL_SPEED;
        dy = BALL_SPEED;
        this.x = x;
        this.y = y;
        this.radius = INIT_RADIUS;
        this.activity = activity;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void move(ArrayList<Player> players) {
        x += dx;
        y += dy;
        checkBounds();
        checkCollisions(players);
    }

    public void checkBounds() {
        if (y > GameManager.heightScreen || y < 0) {
            dy = -dy;
//            Intent intent = new Intent(activity, SoundService.class);
//            activity.startService(intent);
        }
    }

    public void checkCollisions(ArrayList<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            if ((x > players.get(i).getX() && x < players.get(i).getWidth()) &&
                    (y > players.get(i).getY() && y < players.get(i).getHeight())) {
                dx = -dx;
//                Intent intent = new Intent(activity, SoundService.class);
//                activity.startService(intent);
            }
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
