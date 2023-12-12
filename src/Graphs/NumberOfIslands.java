package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 14/11/23,Tuesday

public class NumberOfIslands {

    public static void main(String[] args) {

        char[][] grid = {
                        {'0','1'},
                        {'1','0'},
                        {'1','1'},
                        {'1','0'}
        };

        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {

        boolean [][] visited = new boolean[grid.length][grid[0].length];

        int ans = 0 ;

        for(int i = 0 ; i < grid.length ; ++i)
        {
            for(int j = 0 ; j < grid[i].length ; ++j)
            {
                if(!visited[i][j] && grid[i][j] == '1')
                {
                    connectedComponents(grid , i , j , visited);
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void connectedComponents(char[][] grid , int i , int j , boolean[][]visited)
    {

        // in base case we will check whether we are inside the board or not and whether we're at land or not as well
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j])return ;

        visited[i][j] = true;
        // move upwards
        connectedComponents(grid , i - 1, j , visited);

        //move up right diagonal
        connectedComponents(grid , i - 1 , j + 1 , visited);

        //move right
        connectedComponents(grid , i , j + 1 , visited);

        // move down right diagonal
        connectedComponents(grid , i + 1 , j + 1 , visited);

        // move down
        connectedComponents(grid , i + 1 , j , visited);

        //move left down diagonal
        connectedComponents(grid , i + 1 , j - 1 , visited);

        //move left
        connectedComponents(grid , i , j - 1 , visited);

        // move left up diagonal
        connectedComponents(grid , i - 1 , j -1 , visited);
    }
}
