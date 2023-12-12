package Arrays;

public class KadanesAlgorithm {

    public static void main(String[] args)
    {
        int [] a = {-1,-2,-3,-4};
        System.out.println(maxSum(a , 4));
    }

    public static long maxSum(int[] arr , int n )
    {
        int sum = 0 , max = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i ++)
        {
            if(sum < 0 )sum = arr[i];
            else sum = sum + arr[i];

            max = Math.max(sum , max);
        }

        return max;
    }
}
