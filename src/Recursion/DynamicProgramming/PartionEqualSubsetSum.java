package Recursion.DynamicProgramming;

//File Created by -- > anuragbhatt
//Created On -- > 15/09/23,Friday

public class PartionEqualSubsetSum {

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};

        System.out.println(canPartition(arr));
    }

    public static int canPartition(int[] arr)
    {
        int sum = 0 , target = 0;

        for(int val : arr)
        {
            sum += val;
        }

        if(sum % 2 != 0)return 0;

        target = sum/2;
        boolean[][] hack = new boolean[arr.length + 1][target+1];
        hack[0][0] = true;

        for(int i = 1 ; i <= arr.length ; i ++)
        {
            int item = arr[i-1];

            for(int j = 0 ; j < target + 1; j ++)
            {
                if(j >= item)
                {
                    int index = j - item ;
                    if(hack[i-1][index] || hack[i-1][j])hack[i][j] = true;
                }
                else hack[i][j] = hack[i-1][j];
            }
        }

//        for(int i = 0 ; i <= arr.length ; i ++)
//        {
//            System.out.println(Arrays.toString(hack[i]));
//        }

        return hack[arr.length][target] ? 1 : 0;
    }
}
