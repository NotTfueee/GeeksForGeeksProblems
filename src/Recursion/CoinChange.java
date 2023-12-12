package Recursion;

public class CoinChange {

    public static void main(String [] args)
    {
        int[] coin = {1,2,3};

       System.out.println( can(coin , 3, 4));

    }

    public static long count = 0;
    public static long can(int[] coins , int N , int sum)
    {
        if(sum == 0 )
        {
           count = 1;
           return count;
        }
        else if(sum < 0 ) return 0 ;

        for(int i = 0 ;i < N ; i++)
        {
            int rem = sum - coins[i];

            count = can(coins , N , rem);

        }

        return count;
    }
}
