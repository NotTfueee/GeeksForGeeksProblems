package Arrays;

//File Created by -- > anuragbhatt
//Created On -- > 05/11/23,Sunday

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElementsInAnArray {


    public static void main(String[] args) {

        int[] arr = {1,1,2,2,3,3,3,4};

        System.out.println(Arrays.toString(topK(arr , 2)));
    }

    public static int[] topK(int[] arr , int k)
    {
        var map = new HashMap<Integer , Integer>();
        var q = new PriorityQueue<Integer>((a,b) -> {
            if(map.get(a) == map.get(b))return b-a;

            return map.get(b)- map.get(a);
        });

        for(int a : arr) map.put(a , map.getOrDefault(a , 0 ) + 1);


        for(int key : map.keySet())
        {
            q.add(key);
        }

        int [] ans = new int[k];
        int i = 0;

        while(k-- > 0)
        {
            ans[i] = q.remove();
            i++;
        }

        return ans;
    }
}
