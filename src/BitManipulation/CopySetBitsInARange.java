package BitManipulation;

//File Created by -- > anuragbhatt
//Created On -- > 16/12/23,Saturday

public class CopySetBitsInARange {

    public static void main(String[] args) {

        System.out.println(setSetBit(44 , 3, 5 , 1));

    }

    public static int setSetBit(int x , int y , int r , int l)
    {
        int mask1= 1 << (r - l + 1);

        int mask2 = mask1 - 1;

        int mask3 = mask2 << (l-1);

        int mask4 = y & mask3;

        return (x | mask4);
    }
}
