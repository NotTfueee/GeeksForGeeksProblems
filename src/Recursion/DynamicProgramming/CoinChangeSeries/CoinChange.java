package Recursion.DynamicProgramming.CoinChangeSeries;

public class CoinChange {

    public static void main(String[] args)
    {
        int[] a = {1,2,5};
        System.out.println(change(a , 5));
    }

    public static int change(int[] coins , int target)
    {
        int[] hack = new int[target+1];
        hack[0] = 1;

        for(int i = 0 ; i < coins.length ; i ++)
        {
            for(int j = coins[i] ; j < hack.length ; j++)
            {
                int index = j - coins[i];
                hack[j] = hack[j] + hack[index];
            }
        }

        return hack[target];
    }
}
