package Arrays.SlidingWindow;

//File Created by -- > anuragbhatt
//Created On -- > 10/12/23,Sunday

import java.util.Arrays;
import java.util.HashSet;

public class SubArrayWith0Sum {

    public static void main(String[] args) {
        int[] arr = {4,2,-3,1,6};

        System.out.println(findSum(arr , arr.length));
    }

    public static boolean findSum(int[] arr , int n)
    {
        var set = new HashSet<Integer>();
        int[] pre = new int[n];

        int preSum = 0;
        for(int i = 0 ; i < n ; ++i)
        {
            preSum += arr[i];
            pre[i] = preSum;
        }

        System.out.println(Arrays.toString(pre));

        for(int i = 0 ; i < n ; ++i)
        {
            if(set.contains(pre[i]) || pre[i] == 0)return true;
            else set.add(pre[i]);
        }

        return false;
    }
}
