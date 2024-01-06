package Math;

//File Created by -- > anuragbhatt
//Created On -- > 06/01/24,Saturday

public class TechFestAndTheQueue {

    public static void main(String[] args) {

        System.out.println(sumOfPowers(24,27));
    }

    public static long sumOfPowers(long a , long b)
    {
        long count = 0;
        for(long i = a ; i <= b ; ++i)
        {
            count += find(i);
        }

        return count;
    }

    public static long find(long a)
    {
        int count = 0 ;

        while(a % 2 == 0)
        {
            count ++;
            a /= 2;
        }

        for(long i = 3 ; i <= Math.sqrt(a) ; i += 2)
        {
            while(a % i == 0 )
            {
                count++;
                a /= i;
            }
        }

        if(a > 2)count++;

        return count;

    }
}
