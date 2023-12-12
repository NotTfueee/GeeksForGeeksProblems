package Arrays.SlidingWindow;

//File Created by -- > anuragbhatt
//Created On -- > 05/10/23,Thursday

import java.util.HashSet;

public class CountNumberOfSubstring {

    public static void main(String[] args) {
        System.out.println(noOfSub("aba" , 2));
    }

    public static int noOfSub(String s , int k)
    {
        int left = 0 , count = 0 ;

        var set = new HashSet<Character>();
        set.add(s.charAt(0));

        for(int i = 1 ; i < s.length() ; ++i)
        {
            char item = s.charAt(i);

            if(set.size() < k)
            {
                set.add(item);
            }else
            {
                count ++;
                set.remove(s.charAt(left));
                left++;
            }
        }


        return count;
    }
}
