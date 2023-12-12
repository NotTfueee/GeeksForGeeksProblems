package Recursion.DynamicProgramming;

import java.util.Arrays;

public class Problem0_1KnapSack {

    public static void main (String[]args)
    {
        int[] weights = {3,4,1,5,6};
        int[] values = {2,1,5,3,8};

        System.out.println(findMax(weights , values , 7));
    }

    public static int findMax(int[] w , int [] v , int maxW)
    {
        int n = w.length;
        int[] hack = new int[maxW+1];

        for(int i = 1 ; i <= n ; i ++)
        {
            int weight = w[i-1];
            for(int j = maxW  ; j >= weight  ; j --)
            {
                int exclude = hack[j];
                int index = j - weight;
                int include = hack[index] + v[i-1];
                hack[j] = Math.max(exclude , include);
            }
        }

        System.out.println(Arrays.toString(hack));
        return hack[maxW];
    }
}
