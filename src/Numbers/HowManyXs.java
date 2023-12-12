package Numbers;

//File Created by -- > anuragbhatt
//Created On -- > 06/12/23,Wednesday

public class HowManyXs {

    public static void main(String[] args) {

        System.out.println(countX(18 , 81 , 9));
    }

    public static int countX(int l , int r , int x)
    {
        int count = 0 ;

        while(l+1 < r)
        {
            int num = l+1;

            while(num > 0)
            {
                int n = num % 10 ;

                if(n == x)count ++;

                num /= 10;
            }

            l++;
        }

        return count ;
    }

}
