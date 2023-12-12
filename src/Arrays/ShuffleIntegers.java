package Arrays;

//File Created by -- > anuragbhatt
//Created On -- > 25/11/23,Saturday

public class ShuffleIntegers {

    public static void main(String[] args) {

        long [] arr = {1, 2, 9, 15};

        shuffleArray(arr , 4);
    }

    public static void shuffleArray(long[] arr , int n)
    {
        int half = n/2;

        for(int i = half ; i < n ; ++i)
        {
            arr[i] = arr[i-half] * 10000 + arr[i];
        }

        for(int i = 0 ; i< half ; ++i)
        {
            arr[2 * i ] = arr[i + half] / 10000;
            arr[2 * i + 1] = arr[i + half] % 10000;
        }

    }
}
