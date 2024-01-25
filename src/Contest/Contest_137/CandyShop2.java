package Contest.Contest_137;

//File Created by -- > anuragbhatt
//Created On -- > 14/01/24,Sunday

import java.util.HashMap;
import java.util.HashSet;

public class CandyShop2 {

    public static void main(String[] args) {

        int[] arr = {1,4,5,1};

        System.out.println(candyShop(arr.length , arr));
    }

    public static int candyShop(int n , int[] candies)
    {
        var set = new HashSet<Integer>();

        for(int i : candies)
        {
            set.add(i);
        }

        int start = 0 , c = set.size() , min = Integer.MAX_VALUE , sum = 0;
        var map = new HashMap<Integer, Integer>();

        for(int i = 0 ; i < n ; ++i)
        {
            sum += candies[i];
            map.put(candies[i] , map.getOrDefault(candies[i] , 0 ) +1);

            while(map.size() == c)
            {
                min = Math.min(min , sum);

                int first = candies[start];
                int val = map.get(first);

                if(val > 1)
                {
                    --val;
                    map.put(first , val);
                }
                else map.remove(first);

                sum -= first;
                start ++;
            }
        }

        return min;
    }
}
