package Arrays.PrefixSuffixSum;

//File Created by -- > anuragbhatt
//Created On -- > 12/01/24,Friday


public class LargestSumSubarrayOfSizeAtLeastK {

    public static void main(String[] args) {

        long [] arr = {2,3,1,-7,6,-5,-4,4,3,3,2,-9,-5,6,1,2,1,1};

        System.out.println(maxSumWithK(arr , arr.length , 4));
    }

    public static long maxSumWithK(long[] a , long n , long k )
    {
        int size = (int) n;
        long[] pfs = new long[size];

        long sum = 0;
        for(int i = 0 ; i < size ; ++i)
        {
            if(sum >= 0)
            {
                sum += a[i];
            }
            else sum = a[i];

            pfs[i] = sum;
        }

        int start = 0 ;
        sum = 0;
        long max = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; ++i)
        {
            sum += a[i];
            if(i - start == k-1)
            {
                max = Math.max(max , sum);
                if(start > 0)
                {
                    max = Math.max(max , sum + pfs[start-1]);
                }

                sum -= a[start];
                start ++;
            }
        }
        return max;
    }
}
