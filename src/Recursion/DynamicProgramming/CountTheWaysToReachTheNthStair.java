package Recursion.DynamicProgramming;

public class CountTheWaysToReachTheNthStair {

    public static void main(String[] args)
    {
        System.out.println(countWays(10));
    }

    public static int countWays(int n )
    {
        if (n < 2) return 1;

        int prev1 = 1; // Count of ways for n-1 steps
        int prev2 = 1; // Count of ways for n-2 steps
        int current = 0; // Count of ways for the current step

        for (int i = 2; i <= n; i++) {
            current = (prev1 + prev2) % 1000000007;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}
