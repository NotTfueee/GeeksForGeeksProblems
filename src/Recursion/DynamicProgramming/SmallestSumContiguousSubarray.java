package Recursion.DynamicProgramming;

public class SmallestSumContiguousSubarray {

    public static void main(String[] args)
    {
        int[] a = {3,-4, 2,-3,-1, 7,-5};
        System.out.println(small(a));
    }

    public static int small(int[] arr )
    {
        int sum = 0 , min = Integer.MAX_VALUE;

        for(int i = 0 ; i < arr.length ; i ++)
        {
            if(sum <= 0 )sum += arr[i];
            else sum = arr[i];

            min = Math.min(min , sum);
        }

        return min;
    }
}
