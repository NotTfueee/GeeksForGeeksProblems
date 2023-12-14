package Recursion.BackTracking;

//File Created by -- > anuragbhatt
//Created On -- > 12/12/23,Tuesday

public class GoldMineProblem {

    public static void main(String[] args) {
        int[][] mine =
                {{1, 3, 1, 5},
                        {2, 2, 4, 1},
                        {5, 0, 2, 3},
                        {0, 6, 1, 2}};

        System.out.println(maxGold(mine.length , mine[0].length , mine));
    }

    public static int maxGold(int n , int m , int[][] mine)
    {

        // if there is one row in the mine we will simply calculate the sum of all the elements in the array and return them
        if(n == 1)
        {
            int sum = 0;
            for(int i : mine[0])
            {
                sum += i;
            }

            return sum;
        }

        int[][] dp = new int[n][m];
        int ans = Integer.MIN_VALUE;

        /*
        from the questions we can imply that we can only dig till the last column as we reach the last column we stop
         that means that the last column will always stay the same as it is the smaller problem and also we cannot
          move anywhere else after reaching the last column, we have to move from the smaller problem to the bigger problem
           that is to find the gold at column 0 and we will also handle the edge cases that are if we are at row 0 we cannot moveup
           and if we are at last row we cannot move down so for this we will separately calculate the ans ,
           now how to calculate the ans we will take the max of each cell that represents the gold present there
         */
        for(int j = m - 1 ; j >= 0 ; --j)
        {
            for(int i = 0 ; i < n ; ++i)
            {
                if(j == m-1)
                {
                    dp[i][j] = mine[i][j];
                }
                else if(i == 0)
                {
                    dp[i][j] = Math.max(dp[i][j+1] , dp[i+1][j+1])+mine[i][j];
                }
                else if(i == n-1)
                {
                    dp[i][j] = Math.max(dp[i][j+1] , dp[i-1][j+1])+mine[i][j];
                }
                else
                {
                    int dia = Math.max(dp[i-1][j+1] , dp[i+1][j+1]);
                    dp[i][j] = Math.max(dp[i][j+1] , dia)+mine[i][j];
                }

                if(j == 0)
                {
                    ans = Math.max(ans , dp[i][j]);
                }
            }
        }

        return ans;
    }
}
