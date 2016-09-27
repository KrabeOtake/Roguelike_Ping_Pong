package com.example.pingpong;

/**
 * Created by Krabik on 27.09.2016.
 */
import java.util.ArrayList;


public class Cell
{

    public Cell(int x, int y)
    {
        xloc =  x;
        yloc = y;
    }

    boolean northWall = true;
    boolean southWall = true;
    boolean eastWall = true;
    boolean westWall = true;

    boolean allWallsUp = true;
    boolean visited = false;

    int xloc;
    int yloc;
    int cellNumber;

    ArrayList<Cell> neighbors = new ArrayList<Cell>();

}
