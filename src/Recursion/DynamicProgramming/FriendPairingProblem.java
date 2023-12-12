package Recursion.DynamicProgramming;

//File Created by -- > anuragbhatt
//Created On -- > 17/09/23,Sunday

public class FriendPairingProblem {

    public static void main(String[] args) {
        System.out.println(friend(5));
    }

    public static long friend(int n ) {
        // using dp
        int[] hack = new int[n + 1];
        hack[1] = 1;// number of ways to pair a single person
        hack[2] = 2;// number of ways to pair two people 1-2 , 12

        for (int i = 3; i <= n; i++) {
            hack[i] = hack[i - 1] + hack[i - 2] * (i - 1);
        }

        return hack[n];

        // without dp

//        if(n <= 2)return n;
//
//        int single = 1, two = 2;
//
//        for (int i = 3; i <= n; i++)
//        {
//            int sum  = two + single * (n-1);
//            single = two ;
//            two = sum;
//        }
//
//        return two;
    }
}
