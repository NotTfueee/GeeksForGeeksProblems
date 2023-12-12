package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StringPermutations {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0 ;i < T ; i ++)
        {
            String s = sc.next();

            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String str = new String(arr);

            StringPermutations obj = new StringPermutations();

            System.out.println(obj.permutations(str));
        }
    }

    public  ArrayList<String> permutations(String s)
    {

        if(s.length() == 0 )
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char first = s.charAt(0);
        String remain = s.substring(1);

        ArrayList<String> sub = permutations(remain);

        ArrayList<String > ans = new ArrayList<>();

        for(String val : sub)
        {
            ans.add(val);
            ans.add(first + val);
        }

        return ans;
    }
}
