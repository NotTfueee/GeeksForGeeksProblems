package Recursion;

//File Created by -- > anuragbhatt
//Created On -- > 16/11/23,Thursday

import java.util.ArrayList;

public class FindTheString {

    public static void main(String[] args) {

        System.out.println(findString(2 , 3));

    }

    public static String findString(int n , int k)
    {
        var possible = new ArrayList<String>();

        allPossible( n , k , possible , "");

        System.out.println(possible);

        return "";
    }

    public static void allPossible(int n , int k , ArrayList<String> possible , String s)
    {
        if( s.length() == n)
        {
            possible.add(s);
            return;
        }

        for(int i = 0 ; i < k ; ++i)
        {
            allPossible(n , k , possible , s + i);
        }
    }
}
