package com.example.pingpong;

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

    public void move(Player player) {
        x += dx;
        y += dy;
        checkBounds();
        checkCollisions(player);
    }

    public void checkBounds() {
        if (x > GameManager.widthScreen || x < 0)
            dx = -dx;
        if (y > GameManager.heightScreen || y < 0)
            dy = -dy;
    }

    public void checkCollisions(Player player) {
        if ((x > player.getX() && x < player.getWidth())
                && (y > player.getY() && y < player.getHeight())) {
            dx = -dx;
            dy = -dy;
        }
    }
}
