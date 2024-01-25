package Heaps;//File Created by -- > anuragbhatt
//Created On -- > 19/01/24,Friday

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKNumbersInAStream {

    public static void main(String[] args) {

        int[] arr = {5, 2, 1, 3, 2};

        System.out.println(kTop(arr , arr.length , 1));

    }

    public static class Pair implements Comparable<Pair>
    {
        int e;
        int c;

        Pair(int e , int c)
        {
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.c == o.c)
            {
                return this.e - o.e;
            }
            else return o.c - this.c;
        }
    }
    public static ArrayList<ArrayList<Integer>> kTop (int[] arr , int n , int k)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        var map = new HashMap<Integer , Integer>();
        var pq = new PriorityQueue<Pair>();

        for(int i = 0 ; i < n ; ++i)
        {
            int item = arr[i];
            map.put(item , map.getOrDefault(item , 0 ) + 1);

            pq.clear();
            for(int e : map.keySet())
            {
                pq.add(new Pair(e , map.get(e)));
            }

            var curr = new ArrayList<Integer>();
            int j = 0 , size = pq.size();
            while(j < k && j < size)
            {
                Pair top = pq.remove();
                curr.add(top.e);
                j++;
            }

            ans.add(curr);
        }

        return ans;
    }
}
