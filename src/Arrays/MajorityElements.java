package Arrays;

import java.util.Scanner;

public class MajorityElements {

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        MajorityElements obj = new MajorityElements();
        for(int i = 0 ; i < T ; i ++)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int j = 0 ; j < n ; j++)
            {
                arr[j] = sc.nextInt();
            }

            System.out.println(obj.printMajor(arr));
        }
    }

    public static int printMajor(int[] arr)
    {
        int count = 1 , res = arr[0];

        for(int i = 0 ; i < arr.length ; i ++)
        {
            if(count == 0 )
            {
                res = arr[i];
                count = 1;
            }
            else if (arr[i] != res)count--;
            else count++;
        }

        // to check if the res element is present in the array n/2 times or not
        count = 0;

        for(int i = 0 ; i < arr.length ; i ++)
        {
            if(arr[i] == res)count++;
        }

        if(count > arr.length/2)return res;
        else return -1;
    }
}
