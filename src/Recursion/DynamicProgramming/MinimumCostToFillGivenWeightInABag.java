package Recursion.DynamicProgramming;

//File Created by -- > anuragbhatt
//Created On -- > 13/09/23,Wednesday

import java.util.Arrays;

public class MinimumCostToFillGivenWeightInABag {

    public static void main(String[] args) {

        int[] cost = {-1 ,59 ,96 ,44 ,60 ,52 ,20 ,10 ,31 ,16,67};

        System.out.println(unboundedKnap(cost , 11 , 141));

    }


    public static int unboundedKnap(int[] cost, int N , int W)
    {
        int[][] hack = new int[N+1][W+1];

        for(int i = 1 ; i <= N ; i ++)
        {
            int item = cost[i-1];

            for(int j = 1 ; j < W+1 ; j ++)
            {
                if( j >= i)
                {
                    if(item < 0) hack[i][j] = hack[i-1][j];
                    else
                    {
                        int index = j - i ;
                        if(hack[i-1][j] == 0)
                        {
                            hack[i][j] = hack[i][index]+item;
                            continue;
                        }
                        hack[i][j] = Math.min(hack[i][index] + item , hack[i-1][j]);
                    }
                }
                else hack[i][j] = hack[i-1][j];
            }

        }

        for(int i = 0 ; i <=N ; i ++)
        {
            System.out.println(Arrays.toString(hack[i]));
        }

        return hack[N][W] > 0 ? hack[N][W] : -1;
    }
}
