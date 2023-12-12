package Basic;

//File Created by -- > anuragbhatt
//Created On -- > 12/09/23,Tuesday

public class PerfectNumber {

    public static void main(String[] args) {

        System.out.println(perfect(6));
    }

    public static int perfect(int N)
    {
        long sum = 0;

        for(long i = 1 ; i <= Math.sqrt((double)N) ; i ++)
        {
            if((N%i) == 0 )sum += i/2;
        }
        System.out.println(sum);
        return sum == N ? 1 : 0;
    }

}
