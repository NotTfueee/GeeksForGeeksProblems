package Arrays;

//File Created by -- > anuragbhatt
//Created On -- > 08/12/23,Friday

public class TransformToPrime {

    public static void main(String[] args) {
        int[] arr = {4};

        System.out.println(minNumber(arr , arr.length));
    }

    public static int minNumber(int[] arr , int n)
    {
        int sum = 0;

        for(int i = 0 ; i < n ; ++i)
        {
            sum += arr[i];
        }

        if(primeChecker(sum))return 0;

        int num = sum;
        sum++;

        while(!primeChecker(sum))
        {
            sum++;
        }

        return sum - num;
    }

    public static boolean primeChecker(int n)
    {
        if(n <= 1)return false;

        for(int i = 2 ; i <= Math.sqrt(n) ; ++i)
        {
            if(n % i == 0)return false;
        }

        return true;
    }
}
