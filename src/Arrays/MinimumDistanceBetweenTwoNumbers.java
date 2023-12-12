package Arrays;

//File Created by -- > anuragbhatt
//Created On -- > 02/11/23,Thursday

public class MinimumDistanceBetweenTwoNumbers {

    public static void main(String[] args) {

        int[] arr = {1,2,2,2,2,2};

        System.out.println(minimum(arr , arr.length , 1, 2));
    }

    public static int minimum(int[] arr , int n , int x , int y)
    {
        int min = Integer.MAX_VALUE , xi = -1 , yi = -1;

        for(int i = 0 ; i < n ; ++i)
        {
            int item = arr[i];

            if(item == x)
            {
                xi = i;

                if(yi >= 0)min = Math.min(min , Math.abs(yi-xi));
            }
            else if(item == y)
            {
                yi = i;

                if(xi >= 0 )min = Math.min(min , Math.abs(yi - xi));
            }

            if(min == 1)return 1;

        }

        if( xi < 0 || yi < 0 || xi == yi)return -1;
        return min;
    }
}
