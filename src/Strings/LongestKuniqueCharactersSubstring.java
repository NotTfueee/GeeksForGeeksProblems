package Strings;

import java.util.HashMap;

public class LongestKuniqueCharactersSubstring {

    public static void main (String [] args)
    {

        System.out.println(find("untxym" , 4));

    }

    public static int find(String s , int k)
    {
        var map = new HashMap<Character , Integer>();
        int start = 0 , max = 0 , i = 0;

        for(; i < s.length() ; i ++)
        {
            char item = s.charAt(i);
            if(!map.containsKey(item))
            {
                if(map.size()+1 <= k)map.put(item , 1);
                else {
                    max = Math.max(max , i - start);

                    while(map.size() >= k)
                    {
                        char waste = s.charAt(start);
                        int val = map.get(waste);

                        if(val > 1)
                        {
                            val--;
                            map.put(waste, val);
                        }
                        else map.remove(waste);

                        start++;
                    }

                    map.put(item , 1);
                }
            }
            else map.put(item , map.getOrDefault(item , 0)+1);
        }

        if(map.size() == k)max = Math.max(max , i-start);
        if(max < k)return -1;
        else return max;
    }
}
