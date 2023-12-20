package BitManipulation.GameTheory;

//File Created by -- > anuragbhatt
//Created On -- > 20/12/23,Wednesday

public class ModifiedGameOfNim {

    public static void main(String[] args) {

    }

    public static int findWinner(int n , int[] a)
    {
        int sum = 0 ;

        for(int ele : a )
        {
            sum ^= ele;
        }

        if(sum == 0 )return 1;

        if(n % 2 == 0)return 1;
        else return 2;
    }
}
