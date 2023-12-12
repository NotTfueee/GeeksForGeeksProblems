package Recursion.DynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapSack {

    public static void main(String[] args)
    {
        int[] weights = {2,5,1,3,4};
        int[] values = {15,14,10,45,30};

        System.out.println(maxSum(weights , values , 7));
    }

    public static int maxSum(int[] w , int[] v , int maxW)
    {
        int n = w.length;

        int[] hack = new int[maxW+1];

        for(int i = 1; i < maxW + 1 ; i ++)
        {
            for(int j = 0 ; j < n ; j ++)
            {
                if(i >= w[j])
                {
                    int index = i - w[j];
                    int include = hack[index] + v[j];
                    hack[i] = Math.max(hack[i] , include);
                }
            }
        }

        System.out.println(Arrays.toString(hack));
        return hack[maxW];
    }
}
