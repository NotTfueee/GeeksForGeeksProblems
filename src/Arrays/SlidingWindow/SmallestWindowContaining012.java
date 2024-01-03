package Arrays.SlidingWindow;

//File Created by -- > anuragbhatt
//Created On -- > 03/01/24,Wednesday

public class SmallestWindowContaining012 {

    public static void main(String[] args) {

        System.out.println(smallestSubstring("1210"));
    }

    public static int smallestSubstring(String s)
    {
        int  min = Integer.MAX_VALUE , start = 0 , one = 0 , two = 0 , zero = 0 ;

        for(int i = 0 ; i < s.length() ; ++i)
        {
            char item = s.charAt(i);

            if(item == '1')one ++;
            else if(item == '2')two++;
            else zero ++;

            while(one >= 1 && two >= 1 && zero >= 1)
            {
                min = Math.min(min , i - start + 1);
                char first = s.charAt(start);
                start ++;

                if(first == '1')one--;
                else if(first == '2')two--;
                else zero --;


            }

        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
