package Contest.Contest_136;

//File Created by -- > anuragbhatt
//Created On -- > 15/01/24,Monday

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class GeeksLikeYou {

    public static void main(String[] args) {

        int[] arr = {-2,-3,5,-2,1};

        System.out.println(findAnswer(arr.length , arr ));
    }

    public static class Pair
    {
        int idx;
        long val;

        Pair(int idx , long val)
        {
            this.idx = idx;
            this.val = val;
        }
    }

    public static ArrayList<Integer> findAnswer(int n , int[] arr)
    {
        var stack = new Stack<Pair>();
        var ans = new ArrayList<Integer>();

        for(int i = n-1 ; i >= 0 ; --i)
        {
            if(arr[i] > 0)
            {
                ans.add(1);
                stack.push(new Pair(i , arr[i]));
                continue;
            }

            long curr = arr[i];
            int idx = 0;
            while(!stack.isEmpty() && curr <= 0)
            {
                var top = stack.pop();

                curr += top.val;
                idx = top.idx;
            }

            if(curr <= 0)
            {
                ans.add(0);
            }
            else
            {
                ans.add(idx - i + 1);
                stack.push(new Pair(idx , curr));
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
