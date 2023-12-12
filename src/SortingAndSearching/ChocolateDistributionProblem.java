package SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ChocolateDistributionProblem {

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0 ; i < T ; i ++)
        {
            int n = sc.nextInt();

            var array = new ArrayList<Integer>();

            for(int j = 0 ; j < n ; j++)
            {
                array.add(sc.nextInt());
            }

            int m = sc.nextInt();

            System.out.println(findDiff(array , n  , m));
        }
    }

    public static long findDiff(ArrayList<Integer> a , int n , int m )
    {
       Collections.sort(a);

       int i = 0 , start = 0 , min = Integer.MAX_VALUE;
       for(int val : a)
       {
           if(i - start == m-1)
           {
               int diff = a.get(i) - a.get(start);
               min = Math.min(diff , min);
               start++;
           }
           i++;
       }


       return min;
    }
}
