package Recursion.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class GenrateAllBinaryStrings {

    public static void main(String[] args)
    {
        var result = new ArrayList<String>();

        var ans = findBin(3 , "" , result);

        System.out.println(ans);
    }

    public static List<String> findBin(int n , String ans , List<String> result)
    {
        if(ans.length() == n )
        {
            result.add(ans);
            return result;
        }

        findBin(n , ans + "0" , result);

        if(!ans.endsWith("1"))
        {
            findBin(n , ans+1 , result);
        }

        return result;
    }
}
