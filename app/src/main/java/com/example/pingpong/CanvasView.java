package com.example.pingpong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Сергей Пинкевич on 18.07.2016.
 */

public class CanvasView extends View implements ICanvasView {

    private static int heightScreen;
    private static int widthScreen;
    private GameManager manager;
    private Paint paint;
    private Canvas canvas;
    private ImageView scorePlayer1;
    private ImageView scorePlayer2;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initScreenSize(context);
        manager = new GameManager(this, heightScreen, widthScreen);
        initPaint();
    }

    public void initPaint() {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true); // for smoothing
        paint.setStyle(Paint.Style.FILL);
    }

    private void initScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        heightScreen = point.y;
        widthScreen = point.x;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        manager.onDraw();
    }

    @Override
    public void drawPlayers(ArrayList<Player> players) {
        for (int i = 0; i < players.size(); i++)
            canvas.drawRect(players.get(i).getX(), players.get(i).getY(), players.get(i).getWidth(),
                    players.get(i).getHeight(), paint);
    }

    @Override
    public void drawBall(Ball ball) {
        canvas.drawCircle(ball.getX(), ball.getY(), ball.getRadius(), paint);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_MOVE)
            manager.onTouchEvent(y);
        invalidate();
        return true;
    }

    public void changeScore(Player p, int number) {
        ImageView temp = null;
        if (number == 1)
            temp = scorePlayer1;
        if (number == 2)
            temp = scorePlayer2;

        switch (p.getScore()) {
            case 0:
                temp.setImageResource(R.drawable.score0);
                break;
            case 1:
                temp.setImageResource(R.drawable.score1);
                break;
            case 2:
                temp.setImageResource(R.drawable.score2);
                break;
            case 3:
                temp.setImageResource(R.drawable.score3);
                break;
            case 4:
                temp.setImageResource(R.drawable.score4);
                break;
            case 5:
                temp.setImageResource(R.drawable.score5);
                break;
            case 6:
                temp.setImageResource(R.drawable.score6);
                break;
            case 7:
                temp.setImageResource(R.drawable.score7);
                break;
            case 8:
                temp.setImageResource(R.drawable.score8);
                break;
            case 9:
                temp.setImageResource(R.drawable.score9);
                break;
            case 10:
                temp.setImageResource(R.drawable.score10);
                break;
        }
        invalidate();
    }

    public void getImageView(ImageView player1, ImageView player2) {
        scorePlayer1 = player1;
        scorePlayer2 = player2;
    }
}
