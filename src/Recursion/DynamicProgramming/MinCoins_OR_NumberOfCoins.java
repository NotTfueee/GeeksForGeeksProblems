package Recursion.DynamicProgramming;

import java.util.Arrays;

public class MinCoins_OR_NumberOfCoins {
    public static void main(String[] args) {

        int[] a = {1,2,5};
        System.out.println(coinChange(a , 11));
    }

    public static int coinChange(int[] coins , int amount)
    {
        int n = coins.length ;
        int[] hack = new int[amount+1];
        Arrays.fill(hack , Integer.MAX_VALUE-1);
        hack[0] = 0 ;

        for(int i = 0 ; i < n ; i ++)
        {
            int coin = coins[i];

            for(int j = coin ; j <= amount ; j ++)
            {
                hack[j] = Math.min(hack[j] , hack[j - coin] + 1);
            }
        }

        System.out.println(Arrays.toString(hack));

        return hack[amount] == Integer.MAX_VALUE - 1 ? -1 : hack[amount];
    }
}
