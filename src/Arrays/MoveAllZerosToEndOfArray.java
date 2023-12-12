package Arrays;

//File Created by -- > anuragbhatt
//Created On -- > 31/10/23,Tuesday

import java.util.Arrays;

public class MoveAllZerosToEndOfArray {

    public static void main(String[] args) {

        int[] arr = {0, 0, 0, 4};

        System.out.println(Arrays.toString(move(arr)));
    }

    public static int[]  move(int[] arr) {

        int count = 0;

        for(int i = 0 ; i < arr.length ; ++i)
        {
            if(arr[i] != 0 )
            {
                if(i != count)
                {
                    int temp = arr[i];
                    arr[i] = arr[count];
                    arr[count] = temp;
                }
                count++;
            }
        }


        return arr;
    }
}
