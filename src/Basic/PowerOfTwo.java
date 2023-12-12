package Basic;

//File Created by -- > anuragbhatt
//Created On -- > 18/09/23,Monday

import java.util.Scanner;

public class PowerOfTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long val = n & (n - 1);
        if(val == 0 )System.out.println("YES");
        else System.out.println("NO");
    }
}
