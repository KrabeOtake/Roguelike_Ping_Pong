package com.example.pingpong;

/**
 * Created by Сергей Пинкевич on 18.07.2016.
 */

public class Ball {
    private int x;
    private int y;
    private int radius;
    private final int INIT_RADIUS = 10;

    public Ball(int x, int y) {
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
}
