package Arrays;

//File Created by -- > anuragbhatt
//Created On -- > 01/11/23,Wednesday

import java.util.Arrays;

public class FrequenciesOfLimitedRangeArrayElements {

    public static void main(String[] args) {
        int[] arr = {8,9};

        System.out.println(Arrays.toString(frequencies(arr , 9)));
    }

    public static int[] frequencies(int[] arr , int p)
    {
        for(int i = 0 ; i < arr.length ; ++i)
        {
            arr[i]  -= 1;
        }

        for(int i = 0 ; i < arr.length ; ++i)
        {
            int index = arr[i];

            if(index >= 0 && index < arr.length)arr[index] += p;
        }

        for(int i = 0 ; i < arr.length ; ++i)
        {
            arr[i] = arr[i] / p;
        }
        return arr;
    }
}
