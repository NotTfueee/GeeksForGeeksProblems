package Arrays.PrefixSuffixSum;

//File Created by -- > anuragbhatt
//Created On -- > 12/01/24,Friday


public class LargestSumSubarrayOfSizeAtLeastK {

    public static void main(String[] args) {

        long [] arr = {1, -2, 2, -3};

        System.out.println(maxSumWithK(arr , arr.length , 2));
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

        int start = 0;
        long max = Integer.MIN_VALUE;
        sum = 0 ;

        for(int i = 0 ; i < size ; ++i)
        {
            sum += a[i];
            if(i - start == k-1)
            {
                if(start > 0)
                {
                    max = Math.max(max , sum + pfs[start - 1]);
                }
                else max = Math.max(max , sum);

                sum -= a[start];
                start ++;
            }
        }

        return max;
    }
}
