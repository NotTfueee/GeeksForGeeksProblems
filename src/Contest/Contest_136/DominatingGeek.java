package Contest.Contest_136;

//File Created by -- > anuragbhatt
//Created On -- > 15/01/24,Monday

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DominatingGeek {

    public static void main(String[] args) {

        int[] arr = {2 ,4 ,4 ,3 ,2 ,1 ,6 ,5,7};

        System.out.println(minOps(arr.length , arr));

    }

    public static int minOps(int n , int[] arr)
    {
        var map = new HashMap<Integer, Integer>();

        for(int i : arr)
        {
            map.put(i , map.getOrDefault(i , 0 ) + 1);
        }

        System.out.println(map);

        var occur = new ArrayList<Integer>();

        for(int i : map.keySet())
        {
            int val = map.get(i);

            occur.add(val);
        }

        Collections.sort(occur);

        System.out.println(occur);

        int half = n/2 , sum = 0 , count = 0;

        for(int i = occur.size()-1 ; i >= 0 ; --i)
        {
            sum += occur.get(i);
            if(half >= sum)count ++;
            else break;
        }

        return count ;
    }
}
