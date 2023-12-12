package Recursion.DynamicProgramming;

public class GoldmineProblem {

    public static void main(String[] args)
    {
        int[][] a =  {{1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}};
        System.out.println(maxGold(a));
    }

    public static int maxGold(int[][] mine)
    {
        int n = mine.length , m = mine[0].length;
        if(n == 1 )
        {
            int sum = 0 ;

            for(int i = 0 ; i < mine[0].length ; i ++)
            {
                sum += mine[0][i];
            }

            return sum;
        }

        int maxProfit = Integer.MIN_VALUE;
        int[][] memo = new int[n][m];

        for(int j = m-1 ; j >= 0 ; j --)
        {
            for(int i = n-1 ; i >= 0 ; i--)
            {
                if(j == m-1)
                {
                    memo[i][j] = mine[i][j];
                }
                else if(i == 0 )
                {
                    memo[i][j] = Math.max(memo[i][j+1] , memo[i+1][j+1])+mine[i][j];
                }
                else if(i == n - 1)
                {
                    memo[i][j] = Math.max(memo[i][j+1] , memo[i-1][j+1])+mine[i][j];
                }
                else
                {
                    int max = Math.max(memo[i-1][j+1] , memo[i][j+1]);
                    memo[i][j] = Math.max(max, memo[i+1][j+1])+mine[i][j];
                }

                if(j == 0 )
                {
                    maxProfit = Math.max(maxProfit , memo[i][j]);
                }
            }
        }

        return maxProfit;
    }
}
