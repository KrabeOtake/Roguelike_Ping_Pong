package com.example.pingpong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Сергей Пинкевич on 19.07.2016.
 */

public class GameManager {

    private Ball ball;
    private Player player;
    private Paint paint;
    private CanvasView canvasView;
    private static int heightScreen;
    private static int widthScreen;

    public GameManager(CanvasView canvasView, int h, int w) {
        this.canvasView = canvasView;
        heightScreen = h;
        widthScreen = w;
        initBall();
        initPlayers();
        initPaint();
    }

    public void initBall() {
        ball = new Ball(heightScreen / 2, widthScreen / 2);
    }

    public void initPlayers() {
        player = new Human(200, 0, 15, 100);
    }

    public void initPaint() {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true); // for smoothing
        paint.setStyle(Paint.Style.FILL);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawRect(player.getX(), player.getY(),
                player.getWidth(), player.getHeight(), paint);
        canvas.drawCircle(ball.getX(), ball.getY(), ball.getRadius(), paint);
    }
}
