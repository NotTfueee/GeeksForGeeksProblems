package Greedy;

//File Created by -- > anuragbhatt
//Created On -- > 14/09/23,Thursday

public class PaintFence {

    public static void main(String[] args) {

        System.out.println(countWays(2 , 4));
    }

    public static long countWays(int n , int k )
    {
        if(n == 1)return k;

        long prevLast2Same = k ,
                prevLast2Diff = k * (k-1) ,
                total = prevLast2Same + prevLast2Diff ,
                mod = (int)1e9+7;

        for(int i = 3 ; i <= n ; i ++)
        {
            prevLast2Same = prevLast2Diff;
            prevLast2Diff = (total * (k-1));

            total = (prevLast2Same + prevLast2Diff) % mod;
        }

        return total % mod;
    }
}
