package Arrays;

import java.util.ArrayList;

public class SubarrayWithGivenSum {

    public static void main(String[] args)
    {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(subSum (a, 10,15));
    }

    public static ArrayList<Integer> subSum(int[] arr , int n , int s)
    {
        int sum = 0 , start = 0;

        var ans = new ArrayList<Integer>();

        for(int i = 0 ; i < n ; i ++)
        {
            sum += arr[i];

            while(sum > s && start < n)
            {
                sum = sum - arr[start];
                start++;
            }

            if(sum == s)
            {
                ans.add(start+1);
                ans.add(i+1);
                return ans;
            }
        }

        ans.add(-1);
        return ans;
    }
}
