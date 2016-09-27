package com.example.pingpong;

/**
 * Created by Krabik on 26.09.2016.
 */
public class Tile {
    private int x;
    private int y;
    private int hasEnemy;

    public Tile(int i_x, int i_y, int i_hasEnemy){
        this.x = i_x;
        this.y = i_y;
        this.hasEnemy = i_hasEnemy;
    }

    public int getX(){return x;}

    public int getY(){return y;}

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
