package com.example.pingpong;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MazeActivity extends Activity {
    Maze maze = new Maze();

   /* Maze maze = new Maze();
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String [] prgmNameList={ " ", " "," ", " "," ", " "," ", " "," ", " "," ", " "," ", " "," ", " ",};
    public int [] prgmImages = new int[16];
  // public int [] prgmImages ={R.drawable.wall,R.drawable.wall,R.drawable.road,R.drawable.road,R.drawable.wall,R.drawable.wall,R.drawable.wall,R.drawable.wall,R.drawable.wall,R.drawable.wall,R.drawable.wall};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze);
        maze.generateMaze(4,4);
        maze.display();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++)
            prgmImages[i+j] = maze.prgmImages[i][j];
        }
        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze);
        maze.display();
        GridView gridview = (GridView) findViewById(R.id.gridview);
        CustomAdapter adapter = new CustomAdapter(this, maze.maze);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                // Send intent to SingleViewActivity
                Intent i = new Intent(getApplicationContext(), GameActivity.class);

                // Pass image index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
