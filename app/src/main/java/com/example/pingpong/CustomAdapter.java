package com.example.pingpong;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    Cell[][] board;

    public Integer[] mThumbIds = {
            R.drawable.wall, R.drawable.wall,R.drawable.wall, R.drawable.wall,R.drawable.wall, R.drawable.wall,
            R.drawable.wall, R.drawable.road,R.drawable.road, R.drawable.road,R.drawable.road, R.drawable.wall,
            R.drawable.wall, R.drawable.road,R.drawable.road, R.drawable.road,R.drawable.road, R.drawable.wall,
            R.drawable.wall, R.drawable.road,R.drawable.road, R.drawable.road,R.drawable.road, R.drawable.wall,
            R.drawable.wall, R.drawable.road,R.drawable.road, R.drawable.road,R.drawable.road, R.drawable.wall,
            R.drawable.wall, R.drawable.wall,R.drawable.wall, R.drawable.wall,R.drawable.wall, R.drawable.wall,
    };

    // Constructor
    public CustomAdapter(Context c, Cell[][] maze) {
        mContext = c;
        this.board = maze;
        for(int i = 0, k = 7; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.println("Cell "+ i +" " + j);
                mThumbIds[k] = checkTile(board[j][i]);
                k++;
            }
            k +=2;
        }
        mThumbIds[11] = R.drawable.wall;
        System.out.println(this.board[1][1].westWall);
        System.out.println(this.board[1][1].northWall);
        System.out.println(this.board[1][1].eastWall);
        System.out.println(this.board[1][1].southWall);
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(4, 4, 4, 4);
        }
        else
        {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public int checkTile(Cell cell){
        System.out.println(cell.westWall);
        System.out.println(cell.northWall);
        System.out.println(cell.eastWall);
        System.out.println(cell.southWall);
        if(cell.northWall){
            if(cell.eastWall){
                if(cell.southWall){
                    return R.drawable.onlyw;
                }
                else{
                    return R.drawable.noneast;
                }
            }
            else if(cell.southWall){
                if(cell.westWall){
                    return R.drawable.onlye;
                }
                else{
                 return R.drawable.nons;
                }
            }
            else if(cell.westWall){
                if(cell.eastWall){
                    return R.drawable.onlys;
                }
                else{
                    return R.drawable.nonw;
                }

            }
            else{
                return R.drawable.non;
            }

        }
        else if(cell.eastWall){
            if(cell.southWall){
                if(cell.westWall){
                    return R.drawable.onlyn;
                }
                else{
                    return R.drawable.nose;
                }
            }
            else if(cell.westWall){
                return R.drawable.nowe;
            }
            else{
                return R.drawable.noe;
            }

        }
        else if(cell.southWall){
            if(cell.westWall){
                return R.drawable.nosw;
            }
            else if(cell.northWall){
                return R.drawable.nons;
            }
            else{
                return R.drawable.nos;
            }
        }
        else if(cell.westWall){
            return R.drawable.now;
        }
        else{
            return R.drawable.road;
        }


/*
        if(!cell.westWall & !cell.eastWall & !cell.southWall & !cell.northWall){return R.drawable.road;}

        if(!cell.eastWall && !cell.westWall && !cell.northWall && cell.southWall){return R.drawable.nos;}
        if(!cell.eastWall && !cell.westWall && !cell.southWall && cell.northWall){return R.drawable.non;}
        if(!cell.eastWall && !cell.northWall && !cell.southWall && cell.westWall){return R.drawable.now;}
        if(!cell.northWall && !cell.westWall && !cell.southWall && cell.eastWall){return R.drawable.noe;}

        if(!cell.northWall & !cell.westWall & cell.southWall & cell.eastWall){return R.drawable.nose;}
        if(!cell.northWall & !cell.eastWall & cell.southWall & cell.westWall){return R.drawable.nosw;}
        if(!cell.southWall & !cell.westWall & cell.northWall & cell.eastWall){return R.drawable.noneast;}
        if(!cell.southWall & !cell.eastWall & cell.northWall & cell.westWall){return R.drawable.nonw;}
/*
        if(!cell.northWall & cell.westWall & cell.southWall & cell.eastWall){return R.drawable.onlyn;}
        if(cell.northWall & !cell.westWall & cell.southWall & cell.eastWall){return R.drawable.onlyw;}
        if(cell.northWall & cell.westWall & !cell.southWall & cell.eastWall){return R.drawable.onlys;}
        if(cell.northWall & cell.westWall & cell.southWall & !cell.eastWall ){return R.drawable.onlye;}
*/
    }



    // Keep all Images in array

}
