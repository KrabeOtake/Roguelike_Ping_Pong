package com.example.pingpong;

import android.os.Handler;
import android.widget.Toast;

/**
 * Created by Сергей Пинкевич on 19.07.2016.
 */

public class GameManager {

    private Ball ball;
    private Player player;
    private CanvasView canvasView;
    public static int heightScreen;
    public static int widthScreen;
    public static final int PLAYER_HEIGHT = 100;
    public static final int PLAYER_WIDTH = 10;
    private int difficulty;

    public GameManager(CanvasView canvasView, int h, int w) {
        this.canvasView = canvasView;
        heightScreen = h;
        widthScreen = w;
        difficulty = GameActivity.gameDifficulty;
        initBall();
        initPlayers();
        moveBall();
    }

    /**
     * create ball in the center of the screen
     */
    public void initBall() {
        ball = new Ball(widthScreen / 2, heightScreen / 2);
    }

    /**
     * create player on the left side, in vertical center
     */
    public void initPlayers() {
        player = new Human(widthScreen / 10, heightScreen / 2 - PLAYER_HEIGHT / 2,
                PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    public void onDraw() {
        canvasView.drawPlayer(player);
        canvasView.drawBall(ball);
    }

    public void onTouchEvent(int y) {
        player.moveTo(y);
    }

    public void moveBall() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                ball.move(player);
                handler.postDelayed(this, 25); // 40 FPS = 1000 msec / 25
            }
        });
    }
}
