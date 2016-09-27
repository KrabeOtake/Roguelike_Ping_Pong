package com.example.pingpong;

/**
 * Created by Krabik on 27.09.2016.
 */
import java.util.Random;
import java.util.Stack;



public class Maze
{
    int a = 4;
    int b = 4;

    //This represents the board
    Cell[][] maze = new Cell[a][b];

    //This Stack is going to be used in the generateMaze method
    Stack<Cell> cellStack = new Stack<Cell>();
/*
    public static void main(String[] args)
    {
        Board board = new Board();
        //Assigns each cell its (x,y) location values
        board.assignLocations();
        //This method prints out the board via console
        board.display();
    }
*/
    /**
     * This method assigns the x,y locations for each cell
     */
public Maze(){
    this.assignLocations();
}
    public void assignLocations()
    {
        int cellNumber = 0;

        //This loop creates the cells
        for(int y=0;y<b;y++)
        {
            for(int x=0;x<a;x++)
            {
                Cell newCell = new Cell(x,y);
                maze[x][y] = newCell;
            }
        }

        //This loop assigns the cell values
        for(int k=0;k<b;k++)
        {
            for(int l =0;l<a;l++)
            {
                maze[l][k].cellNumber = cellNumber;
                cellNumber++;
            }
        }

        //This loop assigns the neighbors
        for(int r =0;r<b;r++)
        {
            for(int z=0;z<a;z++)
            {
                assignNeighbors(maze[z][r]);
            }
        }
        generateMaze();
    }

    /**
     * This is the core method that generates a maze.
     * It is a copy of the DFS pseudocode presented in the post.
     */
    public void generateMaze()
    {
        Cell currentCell = maze[0][0];

        while(!allVisited())
        {
            if(validNeighbors(currentCell)!=0)
            {
                Cell neighbor = getRandomNeighbor(currentCell);
                removeWalls(currentCell,neighbor);
                cellStack.push(currentCell);
                currentCell = neighbor;
                currentCell.visited=true;
            }

            else
            {
                Cell newCell = cellStack.pop();
                currentCell = newCell;
            }
        }
    }
    /**
     * This method prints out the maze.
     */
    public void display() {
        for (int i = 0; i < b; i++) {
            // draw the north edge
            for (int j = 0; j < a; j++)
            {
                if(maze[j][i].northWall)
                {
                    System.out.print("+---");
                }
                else
                {
                    System.out.print("+   ");
                }
            }
            System.out.println("+");
            // draw the west edge
            for (int j = 0; j < a; j++)
            {
                if(maze[j][i].westWall)
                {
                    System.out.print("|   ");
                }
                else
                {
                    System.out.print("    ");
                }
            }
            System.out.println("|");
        }

        for (int j = 0; j < a; j++)
        {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    /**
     * This method removes the walls between two given cells.
     * @param currentCell
     * @param nextCell
     */
    public void removeWalls(Cell currentCell, Cell nextCell)
    {
        System.out.println("Current removing walls between " + currentCell.cellNumber + " and " + nextCell.cellNumber);
        if(currentCell.cellNumber + a == nextCell.cellNumber)
        {
            //System.out.println("This cell is south, therefore must remove southern wall.");
            currentCell.southWall = false;
            nextCell.northWall = false;
        }
        else if(currentCell.cellNumber + 1 ==nextCell.cellNumber)
        {
            //System.out.println("This cell is east of the current cell, therefore must remove east wall.");
            currentCell.eastWall = false;
            nextCell.westWall = false;
        }
        else if(currentCell.cellNumber -1 == nextCell.cellNumber)
        {
            //System.out.println("This cell is west of the current cell, therefore must remove the west wall.");
            currentCell.westWall = false;
            nextCell.eastWall = false;
        }
        else if(currentCell.cellNumber -a == nextCell.cellNumber)
        {
            //System.out.println("This cell is north of the current cell, therefore must remove the northern wall.");
            currentCell.northWall = false;
            nextCell.southWall = false;
        }

        currentCell.neighbors.remove(nextCell);
        nextCell.neighbors.remove(currentCell);
    }

    /**
     * This method returns a random neighbor from the list of neighbors located on
     * the neighborList, which is a variable of the Cell class.
     * @param currentCell
     * @return
     */
    public Cell getRandomNeighbor(Cell currentCell)
    {
        Cell cell = null;

        if(currentCell.neighbors.size()==0)
        {
            return null;
        }
        else
        {
            Random generator = new Random();
            int random = generator.nextInt(currentCell.neighbors.size());
            cell = currentCell.neighbors.get(random);
        }

        return cell;
    }

    /**
     * This method assigns neighbors to a specified cell.
     * Uses simple constraints such as determining the (x,y) coordinates of the aforementioned cell
     * @param currentCell
     */

    public void assignNeighbors(Cell currentCell)
    {
        //This handles the cell north of current cell
        if(currentCell.yloc != 0)
        {
            currentCell.neighbors.add(maze[currentCell.xloc][currentCell.yloc-1]);
        }

        //This handles the cell left of the current cell
        if(currentCell.xloc!= 0)
        {
            currentCell.neighbors.add(maze[currentCell.xloc -1][currentCell.yloc]);
        }

        //This handles the cell right of the current
        if(currentCell.xloc!=a-1)
        {
            currentCell.neighbors.add(maze[currentCell.xloc +1][currentCell.yloc]);
        }

        //This handles the cell south of the current cell
        if(currentCell.yloc!=b-1)
        {
            currentCell.neighbors.add(maze[currentCell.xloc][currentCell.yloc+1]);
        }
    }

    /**
     * This returns the number of "valid" neighbors, or
     * neighbors that have NOT yet been visited (Cell.visited) is used to determine this
     * @param currentCell
     * @return
     */
    public int validNeighbors(Cell currentCell)
    {
        int neighbors =0;
        //This loop filters out neighbors that have already been visited
        for(int x=0;x<currentCell.neighbors.size();x++)
        {
            if(!currentCell.neighbors.get(x).visited)
            {
                neighbors++;
            }
            else
            {
                currentCell.neighbors.remove(x);
            }
        }
        return neighbors;
    }

    /**
     * This method simply loops through all of the cells on the board
     * to determine whether or not all cells have been visited.
     * @return
     */
    public boolean allVisited()
    {
        for(int y=0;y<b;y++)
        {
            for(int x=0;x<a;x++)
            {
                if(maze[x][y].visited==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
}


