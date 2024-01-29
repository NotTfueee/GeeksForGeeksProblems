package Contest.Contest_139;

//File Created by -- > anuragbhatt
//Created On -- > 28/01/24,Sunday

import java.util.HashMap;
import java.util.PriorityQueue;

public class MaximumBattalions {

    public static void main(String[] args) {

        String[] names = {"abc" , "def" , "abc" , "aieh"};

        System.out.println(maximumBattalions(names.length , names));
    }

    public static class Pair implements Comparable <Pair>
    {
        int s ;
        int l ;

        Pair(int s , int l)
        {
            this.s = s;
            this.l = l;
        }

        public int compareTo(Pair o)
        {
            return this.s - o.s;
        }
    }
    public static int maximumBattalions(int N, String[] names)
    {
        var map = new HashMap<String ,Pair>();

        for(int i = 0 ; i < N ; ++i)
        {
            String s = names[i];

            if(map.containsKey(s))
            {
                var idx = map.get(s);

                map.put(s , new Pair(idx.s , i));
            }
            else
            {
                map.put(s , new Pair(i , i));
            }
        }

        var pq = new PriorityQueue<Pair>();


        for(String ch : map.keySet())
        {
            pq.add(map.get(ch));
        }

        int count = 1;

        Pair top = pq.remove();
        int prev = top.l , max = top.l;

        while(!pq.isEmpty())
        {
            Pair t= pq.remove();

            if(t.s > max)
            {
                count ++;
            }

            max = Math.max(max , t.l);
        }

        return count;
    }
}
