package Contest.Contest_139;

//File Created by -- > anuragbhatt
//Created On -- > 28/01/24,Sunday

import java.util.Arrays;

public class MaximumEnergy {

    public static void main(String[] args) {

        int[] e = {2};
        int[] p = {0 , 0 , 0 , 0};

        System.out.println(maximumEnergy(1 , e , 4, p));

    }

    public static int maximumEnergy(int n , int[] e , int k , int[] p)
    {
        int mod = (int) 1e9+7;

        Arrays.sort(p);

        long sum = 0 ;
        long[] pfs = new long[n];

        for(int i = 0 ; i < n ; ++i)
        {
            sum += e[i];
            pfs[i] = sum;
        }

        int loop = k / 2 , left = 0 , right = k-1 , ans = 0;

        while(loop-- > 0)
        {
            if(p[left] == 0)
            {
                ans = (int)(ans % mod + pfs[p[right]] % mod )%mod;
            }
            else
            {
                ans = (int)(ans % mod  + (pfs[p[right]] - pfs[p[left]-1]) % mod)%mod;
            }

            left ++;
            right--;
        }

        return ans % mod;
    }
}
