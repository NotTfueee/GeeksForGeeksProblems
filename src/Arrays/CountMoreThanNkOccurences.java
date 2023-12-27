package Arrays;

//File Created by -- > anuragbhatt
//Created On -- > 23/12/23,Saturday

import java.util.HashMap;

public class CountMoreThanNkOccurences {

    public static void main(String[] args) {

        int[] arr = {2,3,3,2};
        System.out.println(countOccurence(arr.length , 4, arr));
    }

    public static int countOccurence(int n , int k , int[] arr)
    {
        var map = new HashMap<Integer, Integer>();

        for(int i = 0 ; i < n ; ++i)
        {
            int item = arr[i];
            map.put(item , map.getOrDefault(item , 0)+1);
        }

        int check = n / k , count = 0;

        for(int key : map.keySet())
        {
            int val = map.get(key);

            if(val > check)count++;
        }

        return count;
    }
}
