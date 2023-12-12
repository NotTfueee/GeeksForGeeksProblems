package Recursion.DynamicProgramming;

public class CountBinaryStrings {

    public static void main (String[] args)
    {
        System.out.println(findBin(3));
    }

    public static long findBin(int n )
    {
        long  prev1 = 1 , prev2 = 1;
        int mod = (int)(1e9+7);

        for(int i = 1 ; i < n+1 ; i ++)
        {
            long curr1 = prev2;
            long curr2 = (prev1 + prev2) % mod;

            prev1 = curr1;
            prev2 = curr2;
        }

        return (prev2 % mod);
    }

}
