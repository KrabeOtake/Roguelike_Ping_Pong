package com.example.pingpong;

/**
 * Created by Сергей Пинкевич on 18.07.2016.
 */

public abstract class Player {
    private int x;
    private int y;
    private int height;
    private int width;
    private int PLAYER_SPEED = 30;
    private int score;

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = y + height;
        this.width = x + width;
        score = 0;
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
        height += dy; // it is necessary for drawing rectangle
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        score++;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSpeed(int s){
        this.PLAYER_SPEED = s;
    }
}
