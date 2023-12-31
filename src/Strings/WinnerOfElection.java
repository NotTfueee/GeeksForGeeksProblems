package Strings;

//File Created by -- > anuragbhatt
//Created On -- > 30/12/23,Saturday

import java.util.Arrays;
import java.util.HashMap;

public class WinnerOfElection {

    public static void main(String[] args) {

        String[] arr = {"john" , "johnny" , "jackie" , "johnny" , "john" , "jackie" , "jamie" , "jamie" , "john" , "johnny" , "jamie" , "johnny" , "john"};

        System.out.println(Arrays.toString(winner(arr , arr.length)));
    }

    public static String[] winner(String[] arr , int n )
    {
        var map = new HashMap<String , Integer>();

        for(int i = 0 ; i < n;  ++i)
        {
            String item = arr[i];

            map.put(item , map.getOrDefault(item , 0) + 1);
        }

        System.out.println(map);

        int max = 0;
        String ans = "";
        for(var s : map.keySet())
        {
            int val = map.get(s);

            if(val > max || (val == max) && s.compareTo(ans) < 0)
            {
                max = val;
                ans = s;
            }
        }
        return new String[] {ans , max+""};
    }


}
