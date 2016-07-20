package com.example.pingpong;

import android.graphics.Canvas;

/**
 * Created by Сергей Пинкевич on 19.07.2016.
 */

public class GameManager {

    private Ball ball;
    private Player player;
    private CanvasView canvasView;
    public static int heightScreen;
    public static int widthScreen;

    public GameManager(CanvasView canvasView, int h, int w) {
        this.canvasView = canvasView;
        heightScreen = h;
        widthScreen = w;
        initBall();
        initPlayers();
    }

    public void initBall() {
        ball = new Ball(heightScreen / 2, widthScreen / 2);
    }

    public void initPlayers() {
        player = new Human(0, 0, 15, 100);
    }

    public void onDraw() {
        canvasView.drawPlayer(player);
        canvasView.drawBall(ball);
    }

    public void onTouchEvent(int y) {
        player.moveTo(y);
    }
}
