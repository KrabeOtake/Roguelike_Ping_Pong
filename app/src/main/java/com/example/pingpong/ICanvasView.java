package com.example.pingpong;

import java.util.ArrayList;

/**
 * Created by Сергей Пинкевич on 20.07.2016.
 */

public interface ICanvasView {
    void drawPlayers(ArrayList<Player> players);
    void drawBall(Ball ball);
}
