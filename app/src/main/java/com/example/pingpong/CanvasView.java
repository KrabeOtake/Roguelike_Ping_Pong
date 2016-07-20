package com.example.pingpong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Сергей Пинкевич on 18.07.2016.
 */

public class CanvasView extends View {

    private static int heightScreen;
    private static int widthScreen;
    private GameManager manager;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initScreenSize(context);
        manager = new GameManager(this, heightScreen, widthScreen);
    }

    private void initScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        heightScreen = point.x;
        widthScreen = point.y;
    }

    @Override
    public void onDraw(Canvas canvas) {
        manager.onDraw(canvas);
    }
}
