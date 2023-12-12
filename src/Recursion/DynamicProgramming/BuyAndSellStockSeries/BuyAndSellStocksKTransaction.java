package Recursion.DynamicProgramming.BuyAndSellStockSeries;

//File Created by -- > anuragbhatt
//Created On -- > 27/09/23,Wednesday

import java.util.Arrays;

public class BuyAndSellStocksKTransaction {

    public static void main(String[] args)
    {
        int[] prices = {10, 22, 5, 75, 65, 80};

        System.out.println(kTrans(prices , 2));
    }

    public static int kTrans(int[] prices , int k)
    {
        int[][] hack = new int[k+1][prices.length];

        for(int i = 1 ; i < k+1 ; ++i)
        {
            for(int j = 1 ; j < prices.length ; ++j)
            {
                int max = Integer.MIN_VALUE , previousDay = j - 1;

                while(previousDay >= 0 )
                {
                    int diff = hack[i-1][previousDay]+prices[j] - prices[previousDay];
                    max = Math.max(max , diff);
                    previousDay--;
                }

                hack[i][j] = Math.max(max , hack[i][j-1]);
            }
        }

        for(int i = 0 ;i < k+1 ; ++i)
        {
            System.out.println(Arrays.toString(hack[i]));
        }

        return hack[k][prices.length-1] ;
    }
}
