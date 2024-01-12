package Arrays.PrefixSuffixSum;

//File Created by -- > anuragbhatt
//Created On -- > 12/01/24,Friday

import java.util.HashMap;

public class LongestSubarrayWithSumDivisibleByK {

    public static void main(String[] args) {

        int[] arr =  {2 ,-7 ,2, -8, 0 ,5 ,-4, 6, -3 ,-2 ,-1};

        System.out.println(longSubarrayWithSumDivByK(arr , arr.length , 8));

    }

    public static int longSubarrayWithSumDivByK(int[] a, int n , int k )
    {
        var map = new HashMap<Integer , Integer>();
        map.put(0 , -1);

        int sum = 0 , max = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; ++i)
        {
            sum += a[i];

            int rem = sum % k ;

            if(rem < 0) rem += k;

            if(map.containsKey(rem))
            {
                int idx = map.get(rem);
                max = Math.max(max , i - idx);
            }
            else map.put(rem , i);
        }

        return max;
    }
}
