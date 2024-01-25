package Graphs;

//File Created by -- > anuragbhatt
//Created On -- > 25/01/24,Thursday

import java.util.ArrayDeque;
import java.util.HashSet;

public class ShortestPrimePath {

    public static void main(String[] args) {

        System.out.println(solve(1033 , 8179));

    }

    public static int solve(int num1 , int num2)
    {
        var seen = new HashSet<Integer>();
        var q = new ArrayDeque<Integer>();
        q.add(num1);
        seen.add(num1);

        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size -- > 0)
            {
                int num = q.remove();
                if(num == num2)return level;

                // for the digit at 0th place 1st place 2nd place and 3rd place as the numbers are of exactly 4 digits
                for(int i = 0 ; i < 4 ; ++i)
                {
                    int factor = (int)Math.pow(10 , i);
                    int temp = num;

                    temp = temp - ( factor * ( (temp / factor) % 10));

                    for(int val = 0 ; val <= 9 ; ++val)
                    {
                        // add the number at the factor position then check
                        temp += (factor * val);

                        if(temp > 1000 && !seen.contains(temp) && isPrime(temp))
                        {
                            q.add(temp);
                            seen.add(temp);
                        }

                        /*
                        operations have been performed now remove that number which was added to the number so that we can
                        add new number at that location
                         */
                        temp -= (factor * val);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public static boolean isPrime(int n)
    {
        if(n <=1)return false;

        for(int i = 2 ; i <= Math.sqrt(n) ; ++i)
        {
            if(n % i == 0)return false;
        }

        return true;
    }
}
