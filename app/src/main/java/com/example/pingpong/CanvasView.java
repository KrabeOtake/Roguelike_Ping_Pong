package com.example.pingpong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Сергей Пинкевич on 18.07.2016.
 */

public class CanvasView extends View {

    private Player player;
    private Paint paint;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPlayers();
        initPaint();
    }

    private void initPlayers() {
        paint = new Paint();
        paint.setAntiAlias(true); // fot smoothing
        paint.setStyle(Paint.Style.FILL);


    }

    private void initPaint() {
    }

    @Override
    public void onDraw(Canvas canvas) {

    }
}
