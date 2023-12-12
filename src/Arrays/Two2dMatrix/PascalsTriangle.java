package Arrays.Two2dMatrix;

//File Created by -- > anuragbhatt
//Created On -- > 24/11/23,Friday

import java.util.ArrayList;

public class PascalsTriangle {

    public static void main(String[] args) {

        System.out.println(pascalsTriangle(5));

    }

    public static ArrayList<Long> pascalsTriangle(int n)
    {

        var ans = new ArrayList<Long>();

        if(n == 1 )
        {
            ans.add(1L);
            return ans;
        }
        else if(n == 2)
        {
            ans.add(1L);
            ans.add(1L);

            return ans;
        }


        long[][] arr = new long[n][n];

        long count = 1 , mod = (int) 1e9 + 7;

        for(int i = 0 ; i < n ; ++i)
        {
            for(int j = 0 ; j < n ; ++j)
            {
                if(j >= n - count) arr[i][j] = 1;
            }
            count ++;
        }

        for(int i = 2 ; i < n ; ++i)
        {
            for(int j = 0 ; j < n-1 ; ++j)
            {
                if(arr[i][j] > 0)
                {
                    arr[i][j] = (arr[i-1][j] % mod  + arr[i-1][j+1] % mod ) % mod ;
                }

                if(i == n -1 )ans.add((long)arr[i][j]);
            }
        }

        ans.add(1L);
        return ans;
    }
}
