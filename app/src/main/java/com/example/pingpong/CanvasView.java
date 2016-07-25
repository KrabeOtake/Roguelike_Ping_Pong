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
import android.widget.ImageButton;
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

    public void changeScores() {
        GameActivity activity = new GameActivity();
        scorePlayer1 = (ImageView) activity.findViewById(R.id.score_1);
    }
}
