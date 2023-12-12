package Stacks;

//File Created by -- > anuragbhatt
//Created On -- > 10/11/23,Friday

import java.util.Stack;

public class NumberFollowingAPattern {

    public static void main(String[] args) {

        System.out.println(print("IIDD"));
    }

    public static String print(String s)
    {
        var stack = new Stack<Integer>();
        int count = 1;
        String ans = "";

        for(int i = 0 ; i < s.length() ; ++i)
        {
            char item = s.charAt(i);

            if(item == 'I')
            {
                stack.push(count);
                count++;

                while(!stack.isEmpty())
                {
                    ans += stack.pop();
                }
            }
            else
            {
                stack.push(count);
                count++;
            }
        }

            stack.push(count);
            while(!stack.isEmpty())
            {
                ans += stack.pop();
            }

        return ans;
    }
}
