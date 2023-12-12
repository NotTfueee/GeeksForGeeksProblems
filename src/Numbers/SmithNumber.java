package Numbers;

//File Created by -- > anuragbhatt
//Created On -- > 09/12/23,Saturday

import java.util.ArrayList;
import java.util.List;

public class SmithNumber {

    public static void main(String[] args) {
        System.out.println(smithNum(985));
    }

    public static int smithNum(int n)
    {

        if(isPrime(n))return 0;

        int sumOfDigits = sum(n) , sumOfFactors = 0;

        var factors = factors(n);

        for (Integer factor : factors) {
            if(factor > 9)factor = sum(factor);
            sumOfFactors += factor;
        }

        if(sumOfFactors == sumOfDigits)return 1;
        else return 0;
    }

    public static int sum(int n)
    {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static boolean isPrime(int n)
    {
        if(n <= 1)return false;

        for(int i = 2 ; i <= Math.sqrt(n) ; ++i)
        {
            if(n % i == 0)return false;
        }

        return true;
    }

    public static List<Integer> factors(int n)
    {
        var list = new ArrayList<Integer>();

        // we first get how many times the number is divisible by 2 at last when the number is not divisible by 2 it will become odd
        while(n % 2 == 0)
        {
            list.add(2);
            n /= 2;
        }

        // now n must be odd at this point ,so we will divide the number with all the odd numbers
        for(int i = 3 ; i <= Math.sqrt(n) ; i +=2 )
        {

            // we do the same we store how many times the number is divisible by the current odd number and store it in factors
            while(n % i == 0)
            {
                list.add(i);
                n /= i;
            }
        }

        /*
        now we check if the number remaining is greater than 2 it means that the remaining number is also a prime number as
        we have removed all the factors of 2 and 3
         */
        if(n > 2)list.add(n);

        return list;
    }

}
