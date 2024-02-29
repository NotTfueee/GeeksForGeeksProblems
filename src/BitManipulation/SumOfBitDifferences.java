package BitManipulation;

//File Created by -- > anuragbhatt
//Created On -- > 29/02/24,Thursday

import static java.lang.System.out;

public class SumOfBitDifferences {

    public static void main(String[] args) {

        int[] arr = {1,3,5};
        out.println(sumBitDifferences(arr , arr.length));
    }

    public static long sumBitDifferences(int[] arr , int n) {

        long ans = 0;

        for(int i = 0 ; i < 32 ; ++i)
        {
            long on = 0 , off = 0;
            for(int j = 0 ; j < n ; ++j)
            {
                if((arr[j] & 1) == 0)off++;
                else on++;

                arr[j] = arr[j] >>1;
            }

            ans += ( on * off * 2);
        }
        return ans;
    }
}
