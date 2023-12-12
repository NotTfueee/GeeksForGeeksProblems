package Strings;

//File Created by -- > anuragbhatt
//Created On -- > 05/11/23,Sunday

import java.util.HashMap;

public class IsomorphicsStrings {

    public static void main(String[] args) {

    }

    public static boolean isoStrings(String S1 , String S2) {

        var map = new HashMap<Character , Character>();

        for(int i = 0 ; i < S1.length() ; ++i)
        {
            char item = S1.charAt(i);

            if(!map.containsKey(item))map.put(item , map.getOrDefault(item , S2.charAt(i)));
            else
            {
                if(map.get(item) != S2.charAt(i))return false;
            }
        }

        return true;
    }
}
