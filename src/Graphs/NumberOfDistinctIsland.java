package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 15/11/23,Wednesday

import java.util.HashSet;

public class NumberOfDistinctIsland {

    public static void main(String[] args) {

        int[][] arr = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};

        System.out.println(countDistinct(arr));

    }

    public static int countDistinct(int[][] grid)
    {
        var set = new HashSet<String>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0 ; i < grid.length ; ++i)
        {
            for (int j = 0; j < grid[i].length; ++j)
            {
                if(!visited[i][j] && grid[i][j] == 1)
                {
                    StringBuilder path = new StringBuilder();

                    island(grid , i , j , visited , path);
                    set.add(path.toString());
                }
            }
        }

        System.out.println(set);
        return set.size();
    }

    public static void island(int[][] grid , int i , int j  , boolean [][] visited ,  StringBuilder path) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || visited[i][j] || grid[i][j] == 0)
        {
           return ;
        }
        visited[i][j] = true;

        // move upward
         island(grid , i - 1 , j  , visited , path.append("u"));

        // move right
         island(grid , i , j + 1  , visited , path.append("r") );

        // move down
         island(grid , i + 1 , j  , visited , path.append("d"));

        // move left
         island(grid , i , j - 1  , visited , path.append("l"));

    }

}
