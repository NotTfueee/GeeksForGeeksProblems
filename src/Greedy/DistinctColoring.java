package Greedy;

//File Created by -- > anuragbhatt
//Created On -- > 12/09/23,Tuesday

public class DistinctColoring {

    public static void main(String[] args)
    {
        int[] r = {2, 1, 3};
        int[] g = {3, 2, 1};
        int[] b = {1, 3, 2};

        System.out.println(color(3 , r , g, b));
    }

    public static int color(int N , int[] r ,int [] g ,int [] b)
    {
        int red = r[0] , green = g[0] , blue = b[0] , sum = 0;

        for(int i = 1 ; i < N ; i ++)
        {
            int currRed = r[i] + Math.min(green , blue);
            int currGreen = g[i] + Math.min(blue , red);
            int currBlue = b[i] + Math.min(red , green);

            red = currRed;
            green = currGreen ;
            blue = currBlue ;
        }

        return Math.min(red , Math.min(green , blue));
    }
}
