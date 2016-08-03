package com.example.pingpong;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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
    private final int COORDINATE_PAUSE = 100;
    private int difficulty;
    private GameActivity activity;

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
        moveBot();
    }

    /**
     * create ball in the center of the screen
     */
    public void initBall() {
        ball = new Ball(widthScreen / 2, heightScreen / 2, activity);
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
        player2.setSpeed(50); //Setting bigger speed for Bot
        player2.setScore(8);
        players.add(player1);
        players.add(player2);
    }

    /**
     * moving Bot-player
     * lower delay for less inertion movement
     */
    public void moveBot() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                players.get(1).moveTo(ball.getY() - players.get(1).getY() / 2);
                handler.postDelayed(this, 5);
            }
        });
    }

    public void onDraw() {
        canvasView.drawPlayers(players);
        canvasView.drawBall(ball);
    }

    public void onTouchEvent(int y) {
//        y -= players.get(0).getHeight() / 2;
        players.get(0).moveTo(y);
    }

    public void moveBall() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                ball.move(players);
                if (isRoundOver()) {
                    checkGameIsOver();
                }
                handler.postDelayed(this, 25); // 40 FPS = 1000 msec / 25
            }
        });
    }

    private void redrawScore(Player p, int number) {
        canvasView.changeScore(p, number);
    }

    public boolean isRoundOver() {
        if (ball.getX() < -COORDINATE_PAUSE) {
            changeScore(1);
            return true;
        }
        if (ball.getX() > widthScreen + COORDINATE_PAUSE) {
            changeScore(0);
            return true;
        }
        return false;
    }

    public void changeScore(int number) {
        players.get(number).addScore();
        redrawScore(players.get(number), number + 1);
        resetGame();
    }

    public void checkGameIsOver() {
        for (int i = 0; i < players.size(); i++)
            if (players.get(i).getScore() == 10) {
                ball = null;
                Intent intent = new Intent(activity.getApplicationContext(), GameOverActivity.class);
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(intent);
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
    }

    public void resetGame(){
        resetBallPosition();
        resetPlayersPosition();
    }

    public void resetBallPosition() {
        ball.setX(widthScreen / 2);
        ball.setY(heightScreen / 2);
    }

    public void resetPlayersPosition() {
        for (Player p : players) {
            p.setY(heightScreen / 2 - PLAYER_HEIGHT / 2);
            p.setHeight(PLAYER_HEIGHT + p.getY());
        }
    }

    public void setActivity(GameActivity activity) {
        this.activity = activity;
    }
}
