package com.example.pingpong;

/**
 * Created by Сергей Пинкевич on 18.07.2016.
 */

public abstract class Player {
    protected int x;
    protected int y;
    protected int height;
    protected int width;
    public static final int PLAYER_SPEED = 30;

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = y + height;
        this.width = x + width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void moveTo(int y1) {
        int dy = (y1 - y) * PLAYER_SPEED / GameManager.heightScreen;
        y += dy;
        height += dy; // it os necessary for drawing rectangle
    }
}
