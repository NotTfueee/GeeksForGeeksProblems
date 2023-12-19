package BitManipulation;

//File Created by -- > anuragbhatt
//Created On -- > 19/12/23,Tuesday

public class RightMostDifferentBit {

    public static void main(String[] args) {

        System.out.println(rightMost(52 , 4));
    }

    public static int rightMost(int m , int n )
    {
        int mask = m ^ n , count = 1;

        if(mask == 0 )return -1;

        while(mask > 0)
        {
            int num = mask & 1;
            if(num >= 1)break;
            else {
                mask = mask >> 1;
                count ++;
            }
        }

        return count;
    }
}
