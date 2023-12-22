package Arrays.Intervals;

//File Created by -- > anuragbhatt
//Created On -- > 22/12/23,Friday

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumMeetingInOneRoom {

    public static void main(String[] args) {

        int[] start = {1,3,0,5,8,5};
        int[] finish = {2,4,6,7,9,9};

        System.out.println(maxMeetings(start.length , start , finish));

    }

    public static class Pair implements Comparable<Pair>
    {
        int st ;
        int ft ;
        int pos;

        Pair(int st , int ft , int pos)
        {
            this.st = st;
            this.ft = ft;
            this.pos = pos;
        }

        public int compareTo(Pair o)
        {
           if(this.ft != o.ft)return this.ft - o.ft;
           else return this.pos - o.pos;
        }
    }
    public static ArrayList<Integer> maxMeetings(int n , int[] s , int[] f)
    {
        var q = new PriorityQueue<Pair>();

        for(int i = 0 ; i < n ; ++i)
        {
            q.add(new Pair(s[i] , f[i] , i+1));
        }

        var ans = new ArrayList<Integer>();
        Pair first = q.remove();

        int prev = first.ft;
        ans.add(first.pos);

        while(!q.isEmpty())
        {
            Pair top = q.remove();

            if(prev < top.st)
            {
                ans.add(top.pos);
                prev = top.ft;
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
