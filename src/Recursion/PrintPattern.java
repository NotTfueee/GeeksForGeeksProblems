package Recursion;

//File Created by -- > anuragbhatt
//Created On -- > 26/11/23,Sunday

import java.util.ArrayList;
import java.util.List;

public class PrintPattern {

    public static void main(String[] args) {

        System.out.println(pattern(10));
    }

    public static List<Integer> pattern(int n)
    {
        var ans = new ArrayList<Integer>();
        ans.add(n);

        patt(ans , n - 5 , n , false);

        return ans;
    }

    public static void patt(ArrayList<Integer> ans , int n , int num , boolean flag)
    {
        if(n == num)
        {
            ans.add(n);
            return ;
        }

        if(n <= 0)flag = true;

        ans.add(n);
        if(flag)patt(ans , n + 5 , num , flag);
        else patt(ans , n - 5 , num , flag);
    }
}
