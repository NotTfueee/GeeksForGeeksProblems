package Recursion.DynamicProgramming;

//File Created by -- > anuragbhatt
//Created On -- > 26/02/24,Monday

import static java.lang.System.out;

public class ReachAGivenScore {

    public static void main(String[] args) {

        out.println(count(20));
    }

    public static long count(int n)
    {
        long[] dp = new long[n+1];
        dp[0] = 1;

        int[] points = {3,5,10};

        for(int i = 0 ; i < 3 ; ++i)
        {
            int item = points[i];

            for(int j = item ; j < n+1 ; ++j)
            {
                int idx = j - item;

                dp[j] = dp[idx] + dp[j];
            }
        }

        return dp[n];
    }
}
