package Recursion.DynamicProgramming;

import java.util.Arrays;

public class TargetSumSubset {

    public static void main(String[] args)
    {
        int[] a = {4,2,7,1,3};
        System.out.println(isThereSubset(a , 10));
    }

    public static boolean isThereSubset(int[] arr , int target)
    {
        int n = arr.length;
        boolean[][] memo = new boolean[n+1][target+1];
        memo[0][0] = true;

        for(int i = 1 ; i < n + 1 ; i ++)
        {
            for(int j = 0 ; j < target + 1 ; j ++)
            {
                if(j == 0 )
                {
                    memo[i][j] = true;
                }
                else if (arr[i-1] > j )
                {
                    if(memo[i-1][j])memo[i][j] = true;
                }
                else
                {
                    if(j - arr[i-1] == 0 )memo[i][j] = true;
                    else if(memo[i-1][j])memo[i][j] = true;
                    else
                    {
                        int index = j - arr[i-1];
                        if(memo[i-1][index])memo[i][j] = true;
                    }
                }
            }
        }
        for(int i = 0 ; i < n+1 ; i ++)
        {
            System.out.println(Arrays.toString(memo[i]));
        }
        return memo[n][target];
    }
}
