package Recursion.DynamicProgramming;

//File Created by -- > anuragbhatt
//Created On -- > 14/12/23,Thursday

public class PaintingTheFence {

    public static void main(String[] args) {

        System.out.println(countWays(5 , 3));
    }

    public static long countWays(int n , int k)
    {

        if(n == 1)return k;

        long mod = (int)1e9+7;

        long prevLast2Same = k , prevLast2Diff = ((k % mod) * (k - 1) % mod)%mod , total = (prevLast2Same + prevLast2Diff) % mod;


        for(int i = 2 ; i < n ; ++i)
        {
            long currSame = prevLast2Diff ;
            long currDiff = ((total % mod) * (k - 1) % mod ) %mod ;

            total = (currSame + currDiff) % mod;

            prevLast2Diff = currDiff;
        }

        return total % mod;
    }
}
