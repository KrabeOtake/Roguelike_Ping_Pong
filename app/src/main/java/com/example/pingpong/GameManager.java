package com.example.pingpong;

import android.os.Handler;

import java.util.ArrayList;

/**
 * Created by Сергей Пинкевич on 19.07.2016.
 */

public class GameManager {

    private Ball ball;
    private ArrayList<Player> players;
    private CanvasView canvasView;
    public static int heightScreen;
    public static int widthScreen;
    public static final int PLAYER_HEIGHT = 100;
    public static final int PLAYER_WIDTH = 10;
    private final int COORDINATE_PAUSE = 40;
    private int difficulty;

    public GameManager(CanvasView canvasView, int h, int w) {
        this.canvasView = canvasView;
        heightScreen = h;
        widthScreen = w;
        difficulty = GameActivity.gameDifficulty;
        players = new ArrayList<>();
        initGame();
    }

    public void initGame() {
        initBall();
        initPlayers();
        gameProcess();
    }

    public void gameProcess() {
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
     * create bot on the right side, in vertical center
     */
    public void initPlayers() {
        Player player1 = new Human(widthScreen / 10, heightScreen / 2 - PLAYER_HEIGHT / 2,
                PLAYER_WIDTH, PLAYER_HEIGHT);
        Player player2 = new Bot((int)(widthScreen * 0.9), heightScreen / 2 - PLAYER_HEIGHT / 2,
                PLAYER_WIDTH, PLAYER_HEIGHT);
        players.add(player1);
        players.add(player2);
    }

    public void onDraw() {
        canvasView.drawPlayers(players);
        canvasView.drawBall(ball);
    }

    public void onTouchEvent(int y) {
        players.get(0).moveTo(y);
    }

    public void moveBall() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                ball.move(players);
                roundOver();
                handler.postDelayed(this, 25); // 40 FPS = 1000 msec / 25
            }
        });
    }

    public boolean roundOver() {
        if (ball.getX() < -COORDINATE_PAUSE) {
            players.get(0).addScore();
            resetGame();
            return true;
        }
        if (ball.getX() > widthScreen + COORDINATE_PAUSE) {
            players.get(1).addScore();
            resetGame();
            return true;
        }
        return false;
    }

    public void changeScores() {
        canvasView.changeScores();
    }

    public boolean gameOver() {
        for (int i = 0; i < players.size(); i++)
            if (players.get(i).getScore() == 10)
                return true;
        return false;
    }

    public void resetGame(){
        resetBallPosition();
        resetPlayersPosition();
    }

    public void resetBallPosition() {
        ball.setX(widthScreen / 2);
        ball.setY(heightScreen / 2);
    }

    public  void resetPlayersPosition() {
        for(Player p : players) {
            p.setHeight(PLAYER_HEIGHT);
            p.setY(heightScreen / 2 - PLAYER_HEIGHT / 2);
        }
    }
}
