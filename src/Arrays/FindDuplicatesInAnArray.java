package Arrays;

//File Created by -- > anuragbhatt
//Created On -- > 28/09/23,Thursday

import java.util.ArrayList;

public class FindDuplicatesInAnArray {

    public static void main(String[] args) {

        int[] arr = {2,3,1,2,3};

        System.out.println(find(arr , 5));
    }

    public static ArrayList<Integer> find(int[] arr , int n )
    {
        var ans = new ArrayList<Integer>();

        for(int i = 0 ; i < n ; ++i)
        {
            int item = arr[i] % n;
            arr[item] += n;
        }

        for(int i = 0 ;i < n ; ++i)
        {
            int item = arr[i] / n;

            if(item >= 2 )ans.add(arr[i] % n);
        }

        return ans;
    }
}
