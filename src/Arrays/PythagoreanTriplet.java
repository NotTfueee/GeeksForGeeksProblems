package Arrays;

//File Created by -- > anuragbhatt
//Created On -- > 03/11/23,Friday

import java.util.Arrays;

public class PythagoreanTriplet {

    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 6, 5};

        System.out.println(checkTriplet(arr , arr.length));
    }

    public static boolean checkTriplet(int[] arr , int n )
    {
        Arrays.sort(arr);

        for(int i = n - 1 ; i >= 2 ; --i)
        {
            int c = (int)Math.pow(arr[i] , 2) , left = 0 , right = i - 1;

            while(left < right)
            {
                int a = (int)Math.pow(arr[left] , 2) , b = (int)Math.pow(arr[right] , 2) ;
                if(a + b == c)return true;
                else if(a + b < c )left ++;
                else if(a + b > c ) right --;
            }
        }
        return false;
    }
}
