package Recursion;

//File Created by -- > anuragbhatt
//Created On -- > 12/02/24,Monday

public class RecursiveSequence {

    public static void main(String[] args) {

        System.out.println(sequence(7));
    }

    public static long sequence(int n )
    {
        long sum = 0 , prev = 1;
        int mod = (int)1e9+7;

        for(long i = 1 ; i <= n ; ++i)
        {
            long mul = 1;

            for(long j = 1 ; j <= i ; ++j)
            {
                mul = (mul % mod * prev % mod) % mod;
                prev++;
            }

            sum = (sum % mod + mul % mod) % mod;
        }

        return sum % mod ;
    }
}
