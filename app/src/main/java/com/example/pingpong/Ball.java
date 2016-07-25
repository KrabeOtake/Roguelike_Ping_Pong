package com.example.pingpong;

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

    public Ball(int x, int y) {
        dx = BALL_SPEED;
        dy = BALL_SPEED;
        this.x = x;
        this.y = y;
        this.radius = INIT_RADIUS;
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
//        if (x > GameManager.widthScreen || x < 0)
//            dx = -dx;
        if (y > GameManager.heightScreen || y < 0)
            dy = -dy;
    }

    public void checkCollisions(ArrayList<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            if ((x > players.get(i).getX() && x < players.get(i).getWidth()) &&
                    (y > players.get(i).getY() && y < players.get(i).getHeight()))
                dx = -dx;
        }
    }
}
