package Recursion.DynamicProgramming;

//File Created by -- > anuragbhatt
//Created On -- > 14/09/23,Thursday

import java.util.Arrays;

public class PerfectSumProblem {

    public static void main(String[] args) {

        int [] arr = {2, 3, 5, 6, 8, 10};
        System.out.println(perfectSum(arr , 6 , 10));
    }

    public static int perfectSum(int[] arr , int N , int sum)
    {
        int[][] hack = new int[N+1][sum+1];
        hack[0][0] = 1;

        for(int i = 1 ; i <= N ; i ++)
        {
            int item = arr[i-1];
            for(int j = 0 ; j < sum + 1 ; j ++)
            {
                if(j >= item)
                {
                    int index = j - item ;
                    int upper = hack[i-1][index] + hack[i-1][j];
                    hack[i][j] = upper;
                }
                else
                {
                    hack[i][j] = hack[i-1][j];
                }
            }
        }

        for(int i = 0 ; i <= N ; i ++)
        {
            System.out.println(Arrays.toString(hack[i]));
        }

        return hack[N][sum];
    }
}
