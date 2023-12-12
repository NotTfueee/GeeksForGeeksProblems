package Recursion.DynamicProgramming;

public class CountPossibleWaysToConstructBuildings {

    public static void main(String[] args)
    {
        System.out.println(findBuild(10));
    }

    public static int findBuild(int n)
    {
        long prev1 = 1 , prev2 = 1 , mod = (int)(1e9+7);

        for(int i = 1 ; i <= n ; i ++)
        {
            long curr1 = prev2;
            long curr2 = (prev1 + prev2) % mod;

            prev1 = curr1;
            prev2 = curr2;
        }

        long ans = (prev2 * prev2) % mod;

        return (int)ans;
    }
}
