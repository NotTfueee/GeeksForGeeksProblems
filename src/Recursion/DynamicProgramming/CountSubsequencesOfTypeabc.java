package Recursion.DynamicProgramming;

//File Created by -- > anuragbhatt
//Created On -- > 10/09/23,Sunday

public class CountSubsequencesOfTypeabc {

    public static void main(String[] args) {

        System.out.println(count("abbc"));
    }

    public static int count(String s)
    {
        int a = 1;
        int ab = 0;
        int abc = 0;

        for(int i = 1 ; i < s.length() ; i ++)
        {
            if(s.charAt(i) == 'a')a = 2*a + 1;
            else if(s.charAt(i) == 'b')ab = 2*ab + a;
            else abc = 2*abc + ab;
        }

        return abc % (int)(1e9+7);
    }
}
