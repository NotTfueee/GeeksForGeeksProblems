package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 30/11/23,Thursday

public class ShortestPathFrom1ToN {

    public static void main(String[] args) {

        System.out.println(minSteps(11));
    }

    public static int minSteps(int n)
    {
        int ans = 0 ;

        while(n >= 3)
        {
            ans += (n % 3);
            n /= 3;
            ans ++;
        }

        return ans;
    }
}
